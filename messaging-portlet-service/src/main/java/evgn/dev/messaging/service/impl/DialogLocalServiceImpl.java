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
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import evgn.dev.messaging.model.DialogMember;
import evgn.dev.messaging.service.DialogMemberLocalServiceUtil;
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

    /**
     * @return id of organizations which is member of this dialog
     */
    public List<Object> getDialogMembers(long dialogId) {
        List<Object> members = new ArrayList<>();
        try {
            List<DialogMember> dialogMembers = DialogMemberLocalServiceUtil.getByDialog(dialogId);
            for (DialogMember dialogMember : dialogMembers) {
                Object member = getMember(dialogMember);
                if (member != null) {
                    members.add(member);
                }
            }
        } catch (Exception e) {
            LOG.error("Cannot get members", e);
        }
        return members;
    }

    public Object getMember(DialogMember dialogMember) throws Exception {
        Object member = null;
        String memberType = dialogMember.getMemberType();
        if (memberType.equalsIgnoreCase("user")) {
             member = UserLocalServiceUtil.getUser(dialogMember.getMemberId());
        } else {
            LOG.error("Wrong member type " + memberType);
        }
        return member;
    }
}