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

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import evgn.dev.messaging.model.DialogMember;
import evgn.dev.messaging.service.DialogMemberLocalServiceUtil;
import evgn.dev.messaging.service.base.DialogMemberLocalServiceBaseImpl;

import java.util.Collections;
import java.util.List;

/**
 * The implementation of the dialog member local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link evgn.dev.messaging.service.DialogMemberLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DialogMemberLocalServiceBaseImpl
 * @see evgn.dev.messaging.service.DialogMemberLocalServiceUtil
 */
@ProviderType
public class DialogMemberLocalServiceImpl
        extends DialogMemberLocalServiceBaseImpl {
    /*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link evgn.dev.messaging.service.DialogMemberLocalServiceUtil} to access the dialog member local service.
	 */

    private static Log LOG = LogFactoryUtil.getLog(DialogMemberLocalServiceImpl.class);

    public static final String MEMBER_TYPE_USER = "user";

    public DialogMember createDialogMember(long dialogId, User user) throws SystemException {
        return createDialogMember(dialogId, user.getUserId(), MEMBER_TYPE_USER);
    }

    public DialogMember createDialogMember(long dialogId, long memberId, String memberType) throws SystemException {
        try {
            long dialogMemberId = CounterLocalServiceUtil.increment(DialogMember.class.getName());
            DialogMember dialogMember = DialogMemberLocalServiceUtil.createDialogMember(dialogMemberId);
            dialogMember.setDialogId(dialogId);
            dialogMember.setMemberId(memberId);
            dialogMember.setMemberType(memberType);
            DialogMemberLocalServiceUtil.updateDialogMember(dialogMember);
            return dialogMember;
        } catch (Exception e) {
            throw new SystemException("Cannot create dialog member");
        }
    }

    /**
     * @return empty in error case
     */
    public List<DialogMember> getByDialog(long dialogId) {

        List<DialogMember> result = Collections.emptyList();
        try {
            result = dialogMemberPersistence.findByDialog(dialogId);
        } catch (Exception e) {
            LOG.error("Cannot get DialogMember by dialogId " + dialogId, e);
        }

        return result;
    }

    public DialogMember getByDialogAndMember(long dialogId, long memberId, String memberType) {

        DialogMember result = null;
        try {
            result = dialogMemberPersistence.findByDialogAndMember(dialogId, memberId, memberType);
        } catch (Exception e) {
            LOG.error("Cannot get DialogMember", e);
        }

        return result;
    }
}