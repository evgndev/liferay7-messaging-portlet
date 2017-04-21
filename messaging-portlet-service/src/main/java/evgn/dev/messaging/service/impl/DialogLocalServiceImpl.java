/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package evgn.dev.messaging.service.impl;

import aQute.bnd.annotation.ProviderType;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import evgn.dev.messaging.model.Dialog;
import evgn.dev.messaging.service.base.DialogLocalServiceBaseImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * The implementation of the dialog local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link evgn.dev.messaging.service.DialogLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DialogLocalServiceBaseImpl
 * @see evgn.dev.messaging.service.DialogLocalServiceUtil
 */
@ProviderType
public class DialogLocalServiceImpl extends DialogLocalServiceBaseImpl {

    /*
     * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link evgn.dev.messaging.service.DialogLocalServiceUtil} to access the dialog local service.
	 */
    private static Log LOG = LogFactoryUtil.getLog(DialogLocalServiceImpl.class.getName());

    public List<Dialog> getUserDialogs(User user, int start, int end) {
        List<Dialog> dialogs = new ArrayList<>();
        String userScreenName = "null";

        try {
            userScreenName = user.getScreenName();

            DynamicQuery dynamicQuery = getUserDialogsQuery(user);
            dynamicQuery.addOrder(OrderFactoryUtil.desc("lastMessageDate"));

            dialogs = dynamicQuery(dynamicQuery, start, end);
        } catch (Exception e) {
            LOG.error("Cannot get dialogs for user " + userScreenName, e);
        }
        return dialogs;
    }

    public Long getUserDialogsCount(User user) {
        Long count = 0L;
        String userScreenName = "null";

        try {
            userScreenName = user.getScreenName();
            DynamicQuery dynamicQuery = getUserDialogsQuery(user);
            count = dynamicQueryCount(dynamicQuery);
        } catch (Exception e) {
            LOG.error("Cannot get dialog count for user " + userScreenName, e);
        }
        return count;
    }

    private DynamicQuery getUserDialogsQuery(User user) {
        DynamicQuery dynamicQuery = dynamicQuery();
        Criterion criterion = RestrictionsFactoryUtil.sqlRestriction(
                "dialogId in (" +
                        "select dialogId from dMsg_dialogMember " +
                        "where memberId = " + user.getUserId() +
                        " and memberType = 'user'" +
                        ")"
        );
        dynamicQuery.add(criterion);
        return dynamicQuery;
    }
}