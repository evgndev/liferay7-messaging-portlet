<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="evgn.dev.messaging.portlet.MessagingPortlet" %>
<%@ page import="evgn.dev.messaging.service.DialogLocalServiceUtil" %>
<%@ page import="evgn.dev.messaging.model.Dialog" %>
<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="evgn.dev.messaging.service.DialogMessageLocalServiceUtil" %>
<%@ page import="evgn.dev.messaging.util.UserCustomUtil" %>
<%@ page import="evgn.dev.messaging.util.DateCustomUtil" %>
<%@ page import="evgn.dev.messaging.util.PermissionUtil" %>
<%@ include file="../init.jsp" %>
<%@ include file="../errors.jsp" %>

<%
    long dialogId = ParamUtil.getLong(request, MessagingPortlet.DIALOG_ID);

    Dialog dialog = DialogLocalServiceUtil.fetchDialog(dialogId);
    String topic = dialog.getTopic();

    PortletURL backURL = renderResponse.createRenderURL();
%>

<liferay-ui:header title="<%= topic %>" backURL="<%= backURL.toString() %>" showBackURL="true"/>

<%--Table--%>
<liferay-ui:search-container
        emptyResultsMessage="empty"
        delta="1000"
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
            <%
                boolean isUserMsg = dialogMessage.getUserId() == user.getUserId();
                String css = isUserMsg ? "align-right" : "";
                String sender = ResourcesUtil.getString(locale, "you");
                if (!isUserMsg) {
                    sender = UserCustomUtil.getUserFIO(dialogMessage.getUserId());
                }
            %>
            <div class="">
                <div class="bold-text <%= css %>">
                    <%= sender %>
                </div>
                <div class="c777 ml10 <%= css %>">
                    <%= dialogMessage.getText() %>
                </div>
                <div class="align-right fs14">
                    <%= DateCustomUtil.toViewFormatDateWithTime(dialogMessage.getCreateDate()) %>
                </div>
            </div>
        </liferay-ui:search-container-column-text>
    </liferay-ui:search-container-row>
    <liferay-ui:search-iterator searchContainer="<%= searchContainer %>"/>
</liferay-ui:search-container>

<%--Create new message--%>
<c:if test="<%= PermissionUtil.hasPermission(scopeGroupId, portletDisplay, "CREATE_MSG")%>">
    <div class="align-center">
        <liferay-portlet:renderURL var="createDialogURL">
            <liferay-portlet:param name="<%= JSP %>" value="<%= MessagingPortlet.JSP_MESSAGE %>"/>
            <liferay-portlet:param name="<%= MessagingPortlet.DIALOG_ID %>" value="<%= String.valueOf(dialogId) %>"/>
        </liferay-portlet:renderURL>
        <aui:a href="<%= createDialogURL %>">
            <liferay-ui:message key="messaging.reply"/>
        </aui:a>
    </div>
</c:if>