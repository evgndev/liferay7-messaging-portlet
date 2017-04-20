<%@ page import="com.liferay.portal.kernel.log.LogFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.log.Log" %>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="com.liferay.portal.kernel.portlet.PortletURLFactoryUtil" %>
<%@ page import="javax.portlet.PortletRequest" %>

<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>

<liferay-theme:defineObjects/>
<portlet:defineObjects/>

<%!
    static final String CMD = Constants.CMD;
    static final String CUR = "cur";
    static final String DELTA = "delta";
    static final String TAB = "tab";
    static final String ORDER_BY_TYPE = "orderByType";
    static final String ORDER_BY_COL = "orderByCol";
    static final String JSP = "jspPage";
    static final String IS_VIEW = "isView";
    static final String AJAX_JSP = "ajaxJsp";
    static final String BACK_URL = "backURL";
%>
<%
    String jspPath = request.getPathInfo();
    final Log LOG = LogFactoryUtil.getLog(jspPath.replace(".jsp", "_jsp"));

    final String portletFullName = portletDisplay.getNamespace()
            .substring(1, portletDisplay.getNamespace().length() - 1);
%>

<%-- General js with jsp tags--%>
<script type="text/javascript">

    var A = AUI();

    //    AUI().use('aui-base', function (A) {
    //
    //    });

    /**
     * Provide portlet namespace
     * @returns string portlet:namespace
     */
    function getNamespace() {
        return "<portlet:namespace/>";
    }

    function getPortletName() {
        return "<%= portletFullName %>";
    }

    function getPlid() {
        return "<%= plid %>";
    }

    function getBasePortletUrl() {
        return '<%= PortletURLFactoryUtil.create(
                request, portletFullName, themeDisplay.getPlid(), PortletRequest.ACTION_PHASE) %>';
    }

    /**
     * Add namespace prefix.
     * Add portlet namespace of current portlet to param
     * @param parameter
     * @returns string portlet:namespace + parameter
     */
    function ns(parameter) {
        return getNamespace() + parameter;
    }

    /**
     * Add namespace Id prefix.
     * Add id selector with portlet namespace of current portlet to param
     * @param parameter
     * @returns string # + portlet:namespace + parameter
     */
    function nsId(parameter) {
        return "#" + ns(parameter);
    }

    /**
     * @param portletName
     * @param plid
     */
    function createResourceURL(portletName, plid) {
        if (!portletName) {
            portletName = getPortletName();
        }

        if (!plid) {
            plid = getPlid();
        }

        return addMainParams(Liferay.PortletURL.createResourceURL(), portletName, plid);
    }

    function addMainParams(renderUrl, portletName, plid) {
        renderUrl.setPortletId(portletName);
        renderUrl.setPlid(plid);
        return renderUrl;
    }

    function getActionURL(actionName, portletName, plid) {
        return addMainParams(getActionURL(actionName), portletName, plid);
    }

    function getActionURL(actionName) {
        var basePortletUrl = getBasePortletUrl();

        var actionURL = Liferay.PortletURL.createURL(basePortletUrl);

        actionURL.setPortletId(getPortletName());
        actionURL.setPlid(getPlid());
        actionURL.setWindowState("normal");
        actionURL.setPortletMode("view");

        if (actionName) {
            actionURL.setName(actionName);
        }

        return actionURL;
    }

</script>