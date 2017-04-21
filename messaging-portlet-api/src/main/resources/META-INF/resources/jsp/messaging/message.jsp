<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="evgn.dev.messaging.portlet.MessagingPortlet" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="evgn.dev.messaging.model.Dialog" %>
<%@ page import="evgn.dev.messaging.service.DialogLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.model.User" %>
<%@ page import="com.liferay.portal.kernel.service.UserLocalServiceUtil" %>
<%@ page import="evgn.dev.messaging.util.UserCustomUtil" %>
<%@ page import="com.google.common.base.Strings" %>
<%@ page import="com.google.common.base.Splitter" %>
<%@ page import="evgn.dev.messaging.util.PermissionUtil" %>
<%@ page import="evgn.dev.messaging.util.PropertiesUtil" %>

<%@ include file="../init.jsp" %>
<%@ include file="../errors.jsp" %>

<%
    long dialogId = ParamUtil.getLong(request, MessagingPortlet.DIALOG_ID);
    Dialog dialog = DialogLocalServiceUtil.fetchDialog(dialogId);

    String receiverAvailableUserIdsStr = ParamUtil.getString(request, "availableUserIds");

    long userId = user.getUserId();

    boolean isNewDialog = dialog == null;
    String topic = "";
    if (!isNewDialog) {
        topic = dialog.getTopic();
    }
    PortletURL backURL = renderResponse.createRenderURL();
%>

<liferay-ui:header title="messaging.creation" backURL="<%= backURL.toString() %>" showBackURL="true"/>

<portlet:actionURL name="createMessage" var="createMessageURL">
    <portlet:param name="<%= MessagingPortlet.DIALOG_ID %>" value="<%= String.valueOf(dialogId) %>"/>
</portlet:actionURL>

<aui:form action="<%= createMessageURL %>">

    <%--Receiver--%>
    <c:if test="<%= isNewDialog %>">
        <%
            List<User> users = UserLocalServiceUtil.getUsers(-1, -1);
        %>
        <aui:select name="<%= MessagingPortlet.RECEIVER %>"
                    label="messaging.receiver" required="true">
            <%
                Set<Long> availableUserIds = new HashSet<>();
                if (!Strings.isNullOrEmpty(receiverAvailableUserIdsStr)) {
                    for (String userIdStr : Splitter.on(",").trimResults().split(receiverAvailableUserIdsStr)) {
                        try {
                            long availableUserId = Long.parseLong(userIdStr);
                            availableUserIds.add(availableUserId);
                        } catch (Exception e) {
                            LOG.error("Cannot parse user id " + userIdStr, e);
                        }
                    }
                }
                availableUserIds.addAll(PropertiesUtil.getAvailableReceivers(user));

                for (User toUser : users) {

                    if (toUser.getUserId() == userId) continue;
                    if (toUser.isDefaultUser()) continue;

                    if (availableUserIds.contains(toUser.getUserId())) {
                        //ok
                    } else if (availableUserIds.isEmpty()
                            && PermissionUtil.hasPermission(scopeGroupId, portletDisplay, "CREATE_DIALOG")) {
                        //ok
                    } else {
                        continue;
                    }
            %>
            <aui:option label="<%= UserCustomUtil.getUserFIO(toUser) %>"
                        value="<%= String.valueOf(toUser.getUserId()) %>"
            />
            <%
                }
            %>
        </aui:select>
    </c:if>

    <%--Topick--%>
    <aui:input name="<%= MessagingPortlet.TOPIC %>"
               label="messaging.topic"
               disabled="<%= !isNewDialog %>"
               value="<%= topic %>"
    >
        <aui:validator name="required"/>
    </aui:input>

    <%--Message--%>
    <aui:input name="<%= MessagingPortlet.TEXT %>"
               label="messaging.text"
               type="textarea"
    >
        <aui:validator name="required"/>
    </aui:input>

    <%--Send--%>
    <aui:button type="submit" value="send"/>
</aui:form>