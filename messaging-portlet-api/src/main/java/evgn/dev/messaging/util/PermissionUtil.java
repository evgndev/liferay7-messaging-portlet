package evgn.dev.messaging.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.theme.PortletDisplay;

/**
 * Created by eugene on 20.04.17.
 */
public class PermissionUtil {
    private static final Log LOG = LogFactoryUtil.getLog(PermissionUtil.class.getName());

    public static boolean hasPermission(long scopeGroupId, PortletDisplay portletDisplay, String action) {
        PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();
        return permissionChecker.hasPermission(
                scopeGroupId, portletDisplay.getRootPortletId(), portletDisplay.getResourcePK(), action);
    }
}
