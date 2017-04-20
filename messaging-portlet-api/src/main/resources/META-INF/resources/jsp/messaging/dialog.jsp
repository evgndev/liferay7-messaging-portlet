<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="evgn.dev.messaging.portlet.MessagingPortlet" %>
<%@ page import="evgn.dev.messaging.service.DialogLocalServiceUtil" %>
<%@ page import="evgn.dev.messaging.model.Dialog" %>
<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="evgn.dev.messaging.service.DialogMessageLocalServiceUtil" %>
<%@ page import="evgn.dev.messaging.util.UserCustomUtil" %>
<%@ include file="../init.jsp" %>
<%@ include file="../errors.jsp" %>

<%
    long dialogId = ParamUtil.getLong(request, MessagingPortlet.DIALOG_ID);
    Dialog dialog = DialogLocalServiceUtil.(dialogId);
    String topic = dialog.getTopic();

    PortletURL backURL = renderResponse.createRenderURL();
%>

<liferay-ui:header title="<%= topic %>" backURL="<%= backURL.toString() %>" showBackURL="true"/>

<%--Table--%>
<liferay-ui:search-container
        emptyResultsMessage="empty"
        delta="20"
>
    <liferay-ui:search-container-results>
        <%
            results = DialogMessageLocalServiceUtil.getMessages(dialogId);
            total = results.size();

            searchContainer.setTotal(total);
            searchContainer.setResults(results);
        %>
    </liferay-ui:search-container-results>

    <liferay-ui:search-container-row
            className="evgn.dev.messaging.model.DialogMessage"
            keyProperty="dialogMessageId"
            modelVar="dialogMessage"
            rowVar="row"
    >
        <liferay-ui:search-container-column-text name="">
            <div class="row">
                <div class="col-md-10">
                    <%= dialogMessage.getText() %>
                </div>
            </div>
            <div class="row">
                <div class="col-md-2 align-right">
                    <%= UserCustomUtil.getUserFIO(dialogMessage.getUserId()) %>
                </div>
            </div>
        </liferay-ui:search-container-column-text>
    </liferay-ui:search-container-row>
    <liferay-ui:search-iterator searchContainer="<%= searchContainer %>"/>
</liferay-ui:search-container>

<%--Create new message--%>
<div class="align-center">
    <liferay-portlet:renderURL var="createDialogURL">
        <liferay-portlet:param name="<%= JSP %>" value="<%= MessagingPortlet.JSP_MESSAGE %>"/>
        <liferay-portlet:param name="<%= MessagingPortlet.DIALOG_ID %>" value="<%= String.valueOf(dialogId) %>"/>
    </liferay-portlet:renderURL>
    <aui:a href="<%= createDialogURL %>">
        <liferay-ui:message key="messaging.reply"/>
    </aui:a>
</div>