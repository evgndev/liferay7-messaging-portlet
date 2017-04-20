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

import evgn.dev.messaging.model.Dialog;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Dialog in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Dialog
 * @generated
 */
@ProviderType
public class DialogCacheModel implements CacheModel<Dialog>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DialogCacheModel)) {
			return false;
		}

		DialogCacheModel dialogCacheModel = (DialogCacheModel)obj;

		if (dialogId == dialogCacheModel.dialogId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, dialogId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{dialogId=");
		sb.append(dialogId);
		sb.append(", topic=");
		sb.append(topic);
		sb.append(", creatorMemberId=");
		sb.append(creatorMemberId);
		sb.append(", lastMessageDate=");
		sb.append(lastMessageDate);
		sb.append(", lastMessageId=");
		sb.append(lastMessageId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", creatorUserId=");
		sb.append(creatorUserId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Dialog toEntityModel() {
		DialogImpl dialogImpl = new DialogImpl();

		dialogImpl.setDialogId(dialogId);

		if (topic == null) {
			dialogImpl.setTopic(StringPool.BLANK);
		}
		else {
			dialogImpl.setTopic(topic);
		}

		dialogImpl.setCreatorMemberId(creatorMemberId);

		if (lastMessageDate == Long.MIN_VALUE) {
			dialogImpl.setLastMessageDate(null);
		}
		else {
			dialogImpl.setLastMessageDate(new Date(lastMessageDate));
		}

		dialogImpl.setLastMessageId(lastMessageId);

		if (createDate == Long.MIN_VALUE) {
			dialogImpl.setCreateDate(null);
		}
		else {
			dialogImpl.setCreateDate(new Date(createDate));
		}

		dialogImpl.setCreatorUserId(creatorUserId);

		dialogImpl.resetOriginalValues();

		return dialogImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		dialogId = objectInput.readLong();
		topic = objectInput.readUTF();

		creatorMemberId = objectInput.readLong();
		lastMessageDate = objectInput.readLong();

		lastMessageId = objectInput.readLong();
		createDate = objectInput.readLong();

		creatorUserId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(dialogId);

		if (topic == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(topic);
		}

		objectOutput.writeLong(creatorMemberId);
		objectOutput.writeLong(lastMessageDate);

		objectOutput.writeLong(lastMessageId);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(creatorUserId);
	}

	public long dialogId;
	public String topic;
	public long creatorMemberId;
	public long lastMessageDate;
	public long lastMessageId;
	public long createDate;
	public long creatorUserId;
}