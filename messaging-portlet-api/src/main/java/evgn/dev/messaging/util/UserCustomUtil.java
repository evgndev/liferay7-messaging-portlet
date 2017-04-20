package evgn.dev.messaging.util;

import com.google.common.base.Joiner;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

/**
 * Created by evgndev on 14.11.16.
 */
public class UserCustomUtil {
    private static final Log LOG = LogFactoryUtil.getLog(UserCustomUtil.class.getName());

    public static final String ROLE_USER = "User";
    public static final String ROLE_ENROLLEE = "Enrollee";
    public static final String ROLE_UNIVERSITY = "University";
    public static final String ROLE_AGENT = "Agent";
    public static final String ROLE_SITE_ADMIN = "SiteAdmin";
    public static final String ROLE_GUEST = "Guest";

    public static long getUserIdFromContext() throws Exception {
        ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
        if (null == serviceContext) {
            throw new IllegalStateException("ServiceContext is unavailable");
        }

        return serviceContext.getUserId();
    }

    public static User getUserFromContext() throws Exception {
        return UserLocalServiceUtil.getUser(getUserIdFromContext());
    }

    public static boolean isUserHaveRole(User user, String requiredRoleStr) {
        for (Role role : user.getRoles()) {
            if (role.getName().equalsIgnoreCase(requiredRoleStr)) {
                return true;
            }
        }
        return false;
    }

    public static String getUserFIO(User user) {
        String fio = "";
        if (user != null) {
            fio = Joiner.on(" ").join(
                    user.getLastName(),
                    user.getFirstName(),
                    user.getMiddleName()
            );
        }

        return fio;
    }

    public static String getUserFIO(long userId) {
        User user = UserLocalServiceUtil.fetchUser(userId);
        return getUserFIO(user);
    }
}
