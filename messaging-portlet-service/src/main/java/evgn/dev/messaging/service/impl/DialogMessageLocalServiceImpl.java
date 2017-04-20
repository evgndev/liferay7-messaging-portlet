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
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import evgn.dev.messaging.model.Dialog;
import evgn.dev.messaging.model.DialogMember;
import evgn.dev.messaging.model.DialogMessage;
import evgn.dev.messaging.model.impl.DialogMessageImpl;
import evgn.dev.messaging.service.DialogMemberLocalServiceUtil;
import evgn.dev.messaging.service.base.DialogMessageLocalServiceBaseImpl;

import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * The implementation of the dialog message local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link evgn.dev.messaging.service.DialogMessageLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DialogMessageLocalServiceBaseImpl
 * @see evgn.dev.messaging.service.DialogMessageLocalServiceUtil
 */
@ProviderType
public class DialogMessageLocalServiceImpl
        extends DialogMessageLocalServiceBaseImpl {
    /*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link evgn.dev.messaging.service.DialogMessageLocalServiceUtil} to access the dialog message local service.
	 */

    private static final Log LOG = LogFactoryUtil.getLog(DialogMessageLocalServiceImpl.class.getName());

    public DialogMessage createMessage(User user,
                                       long dialogId,
                                       String topic,
                                       String text,
                                       long receiverId,
                                       String receiverType,
                                       List<String> errors) throws SystemException {

        try {
            DialogMember senderDialogMember;
            Dialog dialog = dialogPersistence.fetchByPrimaryKey(dialogId);

            if (dialog == null) {
                //create new dialog
                dialogId = CounterLocalServiceUtil.increment(Dialog.class.getName());
                dialog = dialogPersistence.create(dialogId);
                dialog.setCreateDate(new Date());
                dialog.setCreatorUserId(user.getUserId());
                dialog.setTopic(topic);

                //save receiver member
                DialogMemberLocalServiceUtil.createDialogMember(dialogId, receiverId, receiverType);
                //save sender member
                senderDialogMember = DialogMemberLocalServiceUtil.createDialogMember(dialogId, user);

                dialog.setCreatorMemberId(senderDialogMember.getDialogMemberId());
            } else {
                //get member
                senderDialogMember = DialogMemberLocalServiceUtil.getByDialogAndMember(
                        dialogId, user.getUserId(), DialogMemberLocalServiceImpl.MEMBER_TYPE_USER);
            }

            //create message
            long messageId = CounterLocalServiceUtil.increment(DialogMessage.class.getName());
            DialogMessage message = dialogMessagePersistence.create(messageId);

            //set message data
            message.setUserId(user.getUserId());
            message.setCreateDate(new Date());
            message.setText(text);
            message.setDialogMemberId(senderDialogMember.getDialogMemberId());
            message.setDialogId(dialogId);

            //set dialog last message data
            dialog.setLastMessageDate(new Date());
            dialog.setLastMessageId(messageId);

            // save dialog
            dialogPersistence.update(dialog);

            //save message
            dialogMessagePersistence.update(message);

            return message;
        } catch (Exception e) {
            throw new SystemException("Cannot create message", e);
        }
    }

    public List<DialogMessage> getMessages(long dialogId) {

        List<DialogMessage> messages = Collections.emptyList();

        try {
            messages = dialogMessagePersistence.findByDialog(dialogId);
        } catch (Exception e) {
            LOG.error("Cannot get messages by dialog " + dialogId, e);
        }

        return messages;
    }

    public DialogMessage getLastMessage(long dialogId) {

        DialogMessage message = null;
        try {
            OrderByComparator orderByComparator = OrderByComparatorFactoryUtil
                    .create(DialogMessageImpl.TABLE_NAME, "createDate", true);

            message = dialogMessagePersistence.fetchByDialog_Last(dialogId, orderByComparator);
        } catch (Exception e) {
            LOG.error("Cannot get last message by dialog " + dialogId, e);
        }

        return message;
    }
}