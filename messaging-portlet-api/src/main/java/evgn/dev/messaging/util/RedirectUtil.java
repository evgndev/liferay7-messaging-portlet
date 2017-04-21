package evgn.dev.messaging.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.portlet.LiferayPortletConfig;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Evgeny Krysenko
 */
public class RedirectUtil {

    private static final Log LOG = LogFactoryUtil.getLog(RedirectUtil.class.getName());

    public static final String PAGE = "jspPage";
    public static final String TAB = "tab";

    public static void backWithError(ActionRequest request,
                                     ActionResponse response,
                                     List<String> errors,
                                     String errorJspPage) {

        if (!errors.isEmpty()) {
            if (errorJspPage != null && !errorJspPage.isEmpty()) {
                redirect(response, errorJspPage);
            }

            int counter = 0;
            for (String error : errors) {
                error = String.format("%04d#:%s", counter, error);
                SessionErrors.add(request, error);
                counter++;
            }

            hideDefaultErrorMsg(request);
        }
    }

    public static void hideDefaultErrorMsg(ActionRequest request) {
        PortletConfig portletConfig = (PortletConfig) request.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
        LiferayPortletConfig liferayPortletConfig = (LiferayPortletConfig) portletConfig;
        String portletId = liferayPortletConfig.getPortletId();
        SessionMessages.add(request, portletId + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
    }

    public static void redirect(ActionResponse response, String page) {
        response.setRenderParameter(PAGE, page);
    }

    public static void redirectToLayout(String friendlyUrl, RenderRequest renderRequest, RenderResponse renderResponse, ThemeDisplay themeDisplay) throws IOException {
        try {
            Layout profileLayout = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
                    themeDisplay.getScopeGroupId(), false, friendlyUrl);
            if (profileLayout != null) {
                HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(renderRequest);
                HttpServletResponse httpServletResponse = PortalUtil.getHttpServletResponse(renderResponse);
                httpServletResponse.sendRedirect(profileLayout.getRegularURL(httpServletRequest));
            } else {
                LOG.error("Cannot get layout " + friendlyUrl);
            }
        } catch (PortalException e) {
            LOG.error("Cannot redirect to " + friendlyUrl, e);
        }
    }

    /**
     * Redirect back to view mode.
     * https://web.liferay.com/community/forums/-/message_boards/message/52447581
     */
    public static void redirect(ActionRequest request, ActionResponse response, String portletName) {
        try {
            ThemeDisplay themeDisplay =
                    (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
            PortletURL redirect =
                    PortletURLFactoryUtil.create(
                            PortalUtil.getHttpServletRequest(request), portletName,
                            themeDisplay.getLayout().getPlid(), PortletRequest.RENDER_PHASE);
            redirect.setPortletMode(PortletMode.VIEW);
            redirect.setWindowState(WindowState.NORMAL);
            response.sendRedirect(redirect.toString());
        } catch (Exception e) {
            LOG.error("Redirect error", e);
        }
    }
}
