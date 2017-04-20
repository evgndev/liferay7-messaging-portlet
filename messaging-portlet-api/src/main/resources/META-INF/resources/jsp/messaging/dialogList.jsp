<%@ page import="evgn.dev.messaging.service.DialogLocalServiceUtil" %>
<%@ page import="evgn.dev.messaging.model.Dialog" %>
<%@ page import="java.util.List" %>
<%@ page import="evgn.dev.messaging.portlet.MessagingPortlet" %>
<%@ page import="evgn.dev.messaging.service.DialogMessageLocalServiceUtil" %>
<%@ page import="evgn.dev.messaging.model.DialogMessage" %>
<%@ page import="com.liferay.portal.kernel.service.permission.PortletPermissionUtil" %>

<%@ include file="../init.jsp" %>
<%@ include file="../errors.jsp" %>

<%
    List<Dialog> dialogs = DialogLocalServiceUtil.getUserDialogs(user);
    long dialogsCount = dialogs.size();
%>

<%--Create new--%>
<c:if test="<%= PortletPermissionUtil.contains(permissionChecker, portletName, "CREATE_MSG") %>">
    <div class="">
        <liferay-portlet:renderURL var="createDialogURL">
            <liferay-portlet:param name="<%= JSP %>" value="<%= MessagingPortlet.JSP_MESSAGE %>"/>
        </liferay-portlet:renderURL>
        <aui:a href="<%= createDialogURL %>">
            <liferay-ui:message key="messaging.createDialog"/>
        </aui:a>
    </div>
</c:if>

<%--Table--%>
<liferay-ui:search-container
        emptyResultsMessage="message.empty"
        delta="20"
>
    <liferay-ui:search-container-results>
        <%
            total = (int) dialogsCount;

            if (total > 0) {
                results = dialogs;
            }

            searchContainer.setTotal(total);
            searchContainer.setResults(results);
        %>
    </liferay-ui:search-container-results>

    <liferay-ui:search-container-row
            className="evgn.dev.messaging.model.Dialog"
            keyProperty="dialogId"
            modelVar="dialog"
            rowVar="row"
    >
        <liferay-ui:search-container-column-text name="">
            <div class="row">
                <div class="col-md-10">
                    <div class="row bold-text">
                        <%= dialog.getTopic() %>
                    </div>
                    <div class="row">
                        <%
                            DialogMessage lastMessage = DialogMessageLocalServiceUtil
                                    .getLastMessage(dialog.getDialogId());
                            String lastMessageText = "";
                            if (lastMessage != null) {
                                lastMessageText = lastMessage.getText();
                            }
                            if (lastMessageText.length() > 200) {
                                lastMessageText = lastMessageText.substring(0, 200) + "...";
                            }
                        %>
                        <%= lastMessageText %>
                    </div>
                </div>
                <div class="col-md-2 align-right">
                    <liferay-portlet:renderURL var="openURL">
                        <liferay-portlet:param name="<%= JSP %>"
                                               value="<%= MessagingPortlet.JSP_DIALOG %>"
                        />
                        <liferay-portlet:param name="<%= MessagingPortlet.DIALOG_ID %>"
                                               value="<%= String.valueOf(dialog.getDialogId()) %>"
                        />
                    </liferay-portlet:renderURL>
                    <aui:button value="view" cssClass="mt5 mb5" href="<%= openURL %>"/>
                </div>
            </div>
        </liferay-ui:search-container-column-text>
    </liferay-ui:search-container-row>
    <liferay-ui:search-iterator searchContainer="<%= searchContainer %>"/>
</liferay-ui:search-container>
