<%@ page import="evgn.dev.messaging.service.DialogLocalServiceUtil" %>
<%@ page import="java.util.List" %>
<%@ page import="evgn.dev.messaging.portlet.MessagingPortlet" %>
<%@ page import="evgn.dev.messaging.service.DialogMessageLocalServiceUtil" %>
<%@ page import="evgn.dev.messaging.model.DialogMessage" %>
<%@ page import="evgn.dev.messaging.util.PermissionUtil" %>
<%@ page import="evgn.dev.messaging.util.UserCustomUtil" %>
<%@ page import="evgn.dev.messaging.service.DialogMemberLocalServiceUtil" %>
<%@ page import="evgn.dev.messaging.model.DialogMember" %>
<%@ page import="com.google.common.base.Joiner" %>
<%@ page import="com.google.common.base.Strings" %>
<%@ page import="javax.portlet.PortletURL" %>

<%@ include file="../init.jsp" %>
<%@ include file="../errors.jsp" %>

<%
    PortletURL tableURL = renderResponse.createRenderURL();
%>

<%--Create new --%>
<c:if test="<%= PermissionUtil.hasPermission(scopeGroupId, portletDisplay, "CREATE_MSG")
        && PermissionUtil.hasPermission(scopeGroupId, portletDisplay, "CREATE_DIALOG") %>">
    <div>
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
        emptyResultsMessage="messaging.empty"
        delta="20"
        iteratorURL="<%= tableURL %>"
>
    <liferay-ui:search-container-results>
        <%
            total = DialogLocalServiceUtil.getUserDialogsCount(user).intValue();

            if (total > 0) {
                results = DialogLocalServiceUtil.getUserDialogs(user, searchContainer.getStart(), searchContainer.getEnd());
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
            <%
                DialogMessage lastMessage = DialogMessageLocalServiceUtil.getLastMessage(dialog.getDialogId());
                String lastMessageText = "";
                String lastMessageSender = "";
                //set last msg data
                if (lastMessage != null) {
                    //get text
                    lastMessageText = lastMessage.getText();
                    if (lastMessageText.length() > 200) {
                        lastMessageText = lastMessageText.substring(0, 200) + "...";
                    }

                    //get sender
                    boolean isUserMsg = lastMessage.getUserId() == user.getUserId();
                    lastMessageSender = ResourcesUtil.getString(locale, "you");
                    if (!isUserMsg) {
                        lastMessageSender = UserCustomUtil.getUserFIO(lastMessage.getUserId());
                    }
                    lastMessageSender += ": ";
                }

                //get members
                List<String> memberNames = new ArrayList<>();
                for (DialogMember dialogMember : DialogMemberLocalServiceUtil.getByDialog(dialog.getDialogId())) {
                    if (dialogMember.getMemberId() != user.getUserId() && !Strings.isNullOrEmpty(dialogMember.getName())) {
                        memberNames.add(dialogMember.getName());
                    }
                }
                String members = Joiner.on(", ").join(memberNames);
            %>
            <div class="row">
                <div class="col-md-10">
                    <div>
                        <span class="bold-text"><%= dialog.getTopic() %></span>
                        &nbsp;
                        &nbsp;
                        <span class="fs15 c666"><%= members %></span>
                    </div>
                    <div class="fs15 ml10 c777">
                        <span class="bold-text">
                            <%= lastMessageSender %>
                        </span>
                        <span>
                            <%= lastMessageText %>
                        </span>
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
<style>
    .msgCreation {
        display: block !important;
    }
</style>