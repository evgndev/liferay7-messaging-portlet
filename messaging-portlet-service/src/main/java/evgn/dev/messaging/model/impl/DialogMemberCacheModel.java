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

import evgn.dev.messaging.model.DialogMember;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing DialogMember in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see DialogMember
 * @generated
 */
@ProviderType
public class DialogMemberCacheModel implements CacheModel<DialogMember>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DialogMemberCacheModel)) {
			return false;
		}

		DialogMemberCacheModel dialogMemberCacheModel = (DialogMemberCacheModel)obj;

		if (dialogMemberId == dialogMemberCacheModel.dialogMemberId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, dialogMemberId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{dialogMemberId=");
		sb.append(dialogMemberId);
		sb.append(", dialogId=");
		sb.append(dialogId);
		sb.append(", memberId=");
		sb.append(memberId);
		sb.append(", memberType=");
		sb.append(memberType);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DialogMember toEntityModel() {
		DialogMemberImpl dialogMemberImpl = new DialogMemberImpl();

		dialogMemberImpl.setDialogMemberId(dialogMemberId);
		dialogMemberImpl.setDialogId(dialogId);
		dialogMemberImpl.setMemberId(memberId);

		if (memberType == null) {
			dialogMemberImpl.setMemberType(StringPool.BLANK);
		}
		else {
			dialogMemberImpl.setMemberType(memberType);
		}

		dialogMemberImpl.resetOriginalValues();

		return dialogMemberImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		dialogMemberId = objectInput.readLong();

		dialogId = objectInput.readLong();

		memberId = objectInput.readLong();
		memberType = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(dialogMemberId);

		objectOutput.writeLong(dialogId);

		objectOutput.writeLong(memberId);

		if (memberType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(memberType);
		}
	}

	public long dialogMemberId;
	public long dialogId;
	public long memberId;
	public String memberType;
}