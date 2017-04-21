package evgn.dev.messaging.util;

import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PropsUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by eugene on 21.04.17.
 */
public class PropertiesUtil {

    private static final Log LOG = LogFactoryUtil.getLog(PropertiesUtil.class.getName());

    /**
     * String with user ids
     */
    public static Set<Long> getAvailableReceivers(User user) {
        Set<Long> userIds = new HashSet<>();

        String propertyPrefix = "messaging.receivers.";

        for (Role role : RoleLocalServiceUtil.getUserRoles(user.getUserId())) {
            String roleName = role.getName();
            String receiversStr = GetterUtil.getString(PropsUtil.get(propertyPrefix + roleName));
            if (!Strings.isNullOrEmpty(receiversStr)) {
                for (String receiverIdStr : Splitter.on(",").trimResults().splitToList(receiversStr)) {
                    long receiverId = Long.parseLong(receiverIdStr);
                    userIds.add(receiverId);
                }
            }
        }

        return userIds;
    }
}
