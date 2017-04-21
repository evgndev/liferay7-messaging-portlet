<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="evgn.dev.messaging.portlet.MessagingPortlet" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="evgn.dev.messaging.model.Dialog" %>
<%@ page import="evgn.dev.messaging.service.DialogLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.model.User" %>
<%@ page import="com.liferay.portal.kernel.service.UserLocalServiceUtil" %>
<%@ page import="evgn.dev.messaging.util.UserCustomUtil" %>
<%@ include file="../init.jsp" %>
<%@ include file="../errors.jsp" %>

<%
    long dialogId = ParamUtil.getLong(request, MessagingPortlet.DIALOG_ID);
    Dialog dialog = DialogLocalServiceUtil.fetchDialog(dialogId);
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
                for (User toUser : users) {
                    if (toUser.getUserId() == user.getUserId()) continue;
                    if (toUser.isDefaultUser()) continue;
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