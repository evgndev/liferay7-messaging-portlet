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

package evgn.dev.messaging.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import evgn.dev.messaging.model.DialogMessage;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DialogMessage in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see DialogMessage
 * @generated
 */
@ProviderType
public class DialogMessageCacheModel implements CacheModel<DialogMessage>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DialogMessageCacheModel)) {
			return false;
		}

		DialogMessageCacheModel dialogMessageCacheModel = (DialogMessageCacheModel)obj;

		if (messageId == dialogMessageCacheModel.messageId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, messageId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{messageId=");
		sb.append(messageId);
		sb.append(", dialogId=");
		sb.append(dialogId);
		sb.append(", text=");
		sb.append(text);
		sb.append(", dialogMemberId=");
		sb.append(dialogMemberId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DialogMessage toEntityModel() {
		DialogMessageImpl dialogMessageImpl = new DialogMessageImpl();

		dialogMessageImpl.setMessageId(messageId);
		dialogMessageImpl.setDialogId(dialogId);

		if (text == null) {
			dialogMessageImpl.setText(StringPool.BLANK);
		}
		else {
			dialogMessageImpl.setText(text);
		}

		dialogMessageImpl.setDialogMemberId(dialogMemberId);
		dialogMessageImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			dialogMessageImpl.setCreateDate(null);
		}
		else {
			dialogMessageImpl.setCreateDate(new Date(createDate));
		}

		dialogMessageImpl.resetOriginalValues();

		return dialogMessageImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		messageId = objectInput.readLong();

		dialogId = objectInput.readLong();
		text = objectInput.readUTF();

		dialogMemberId = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(messageId);

		objectOutput.writeLong(dialogId);

		if (text == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(text);
		}

		objectOutput.writeLong(dialogMemberId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
	}

	public long messageId;
	public long dialogId;
	public String text;
	public long dialogMemberId;
	public long userId;
	public long createDate;
}