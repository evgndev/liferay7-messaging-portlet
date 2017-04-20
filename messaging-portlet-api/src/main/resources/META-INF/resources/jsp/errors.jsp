<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.liferay.portal.kernel.servlet.SessionErrors" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.Collator" %>
<%@ page import="com.liferay.portal.kernel.log.Log" %>
<%@ page import="com.liferay.portal.kernel.log.LogFactoryUtil" %>
<%@ page import="evgn.dev.messaging.util.ResourcesUtil" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects/>

<%--
To automatizate error output and prametrized error message.

To automatizate just define error message in localized property file.

To use parametrized message put "$argument" after message in error produced code and use %s in properties file.
Example:

    produce error:
    SessionErrors.add(request, "some.user.error.code$" + username + "$" + userId);

    properties file:
    some.user.error.code=User with name %s and id %s has some errors

    in jsp:
    <%@ include file="/jsp/errors.jsp" %>

--%>
<%
    /*
     Parametrized ordered errors
     */
    Log LOG_ERR = LogFactoryUtil.getLog("error_jsp");
    try {//encapsulate data
        Map<String, String> errors = new LinkedHashMap<>();
        List<String> stringErrorsList = new LinkedList<>();
        stringErrorsList.addAll(SessionErrors.keySet(liferayPortletRequest));
        stringErrorsList.sort(Collator.getInstance());

        //max count of errors on page
        int maxViewCount = 10;

        // fill errors map
        int counter = 1;
        for (String err : stringErrorsList) {
            String errMsg = err;
            if (errMsg.contains("#:")) {
                errMsg = errMsg.substring(errMsg.indexOf("#:") + 2);
            }

            // the end: show count of other errors
            if (counter > maxViewCount) {
                String errorKey = "other.errors";
                String msgTemplate = ResourcesUtil.getString(errorKey);
                int otherErrorsCount = SessionErrors.size(renderRequest) - maxViewCount;
                errMsg = String.format(msgTemplate, otherErrorsCount);
                errors.put(err, errMsg);
                break;
            }

            // #: error.msg.name$arg$arg2
            if (errMsg.contains("$")) {
                // Split to 2 part by "$": first is error key, second is arguments
                String[] dividedSrt = errMsg.split("\\$", 2);
                // get first part - error key
                String errPrefix = dividedSrt[0];

                // get error message by error key
                String msgTemplate = ResourcesUtil.getString(errPrefix);
                // get second part and split to arguments
                String[] arguments = dividedSrt[1].split("\\$");
                // fill template
                errMsg = String.format(msgTemplate, arguments);
            }

            errors.put(err, errMsg);

            counter++;
        }

        // reverse for UI
        LinkedList<String> keyList = new LinkedList<>(errors.keySet());
        Collections.reverse(keyList);

        // to show
        for (String errKey : keyList) {
            String errMsg = errors.get(errKey);
%>
<div class="custom-error">
    <liferay-ui:error key="<%= errKey %>" message="<%= errMsg %>"/>
</div>
<%
        }
    } catch (Exception e) {
        LOG_ERR.error("Cannot generate errors jsp!", e);
    }
%>
<style type="text/css">
    /*hide all default message*/
    .alert-error {
        display: none !important;
    }

    /*show only custom message*/
    .custom-error > .alert-error {
        display: block !important;
    }
</style>