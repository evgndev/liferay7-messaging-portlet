/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package evgn.dev.messaging.service.impl;

import aQute.bnd.annotation.ProviderType;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import evgn.dev.messaging.model.Dialog;
import evgn.dev.messaging.model.DialogMember;
import evgn.dev.messaging.service.DialogMemberLocalServiceUtil;
import evgn.dev.messaging.service.base.DialogLocalServiceBaseImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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


    public List<Dialog> getUserDialogs(User user) {
        List<Dialog> dialogs = new ArrayList<>();
        String userScreenName = "null";

        try {
            userScreenName = user.getScreenName();
            List<DialogMember> members = DialogMemberLocalServiceUtil.getByUser(user.getUserId());
            Set<Long> dialogIds = new HashSet<>();
            for (DialogMember dialogMember : members) {
                dialogIds.add(dialogMember.getDialogId());
            }
            for (Long dialogId : dialogIds) {
                Dialog dialog = dialogPersistence.fetchByPrimaryKey(dialogId);
                if (dialog != null) {
                    dialogs.add(dialog);
                } else {
                    LOG.warn("Cannot get dialog by id " + dialogId);
                }
            }

        } catch (Exception e) {
            LOG.error("Cannot get dialogs for user " + userScreenName, e);
        }
        return dialogs;
    }
}