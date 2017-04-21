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

package evgn.dev.messaging.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link DialogMember}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DialogMember
 * @generated
 */
@ProviderType
public class DialogMemberWrapper implements DialogMember,
	ModelWrapper<DialogMember> {
	public DialogMemberWrapper(DialogMember dialogMember) {
		_dialogMember = dialogMember;
	}

	@Override
	public Class<?> getModelClass() {
		return DialogMember.class;
	}

	@Override
	public String getModelClassName() {
		return DialogMember.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dialogMemberId", getDialogMemberId());
		attributes.put("dialogId", getDialogId());
		attributes.put("memberId", getMemberId());
		attributes.put("memberType", getMemberType());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long dialogMemberId = (Long)attributes.get("dialogMemberId");

		if (dialogMemberId != null) {
			setDialogMemberId(dialogMemberId);
		}

		Long dialogId = (Long)attributes.get("dialogId");

		if (dialogId != null) {
			setDialogId(dialogId);
		}

		Long memberId = (Long)attributes.get("memberId");

		if (memberId != null) {
			setMemberId(memberId);
		}

		String memberType = (String)attributes.get("memberType");

		if (memberType != null) {
			setMemberType(memberType);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _dialogMember.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _dialogMember.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _dialogMember.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _dialogMember.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<evgn.dev.messaging.model.DialogMember> toCacheModel() {
		return _dialogMember.toCacheModel();
	}

	@Override
	public evgn.dev.messaging.model.DialogMember toEscapedModel() {
		return new DialogMemberWrapper(_dialogMember.toEscapedModel());
	}

	@Override
	public evgn.dev.messaging.model.DialogMember toUnescapedModel() {
		return new DialogMemberWrapper(_dialogMember.toUnescapedModel());
	}

	@Override
	public int compareTo(evgn.dev.messaging.model.DialogMember dialogMember) {
		return _dialogMember.compareTo(dialogMember);
	}

	@Override
	public int hashCode() {
		return _dialogMember.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _dialogMember.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new DialogMemberWrapper((DialogMember)_dialogMember.clone());
	}

	/**
	* Returns the member type of this dialog member.
	*
	* @return the member type of this dialog member
	*/
	@Override
	public java.lang.String getMemberType() {
		return _dialogMember.getMemberType();
	}

	/**
	* Returns the name of this dialog member.
	*
	* @return the name of this dialog member
	*/
	@Override
	public java.lang.String getName() {
		return _dialogMember.getName();
	}

	@Override
	public java.lang.String toString() {
		return _dialogMember.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _dialogMember.toXmlString();
	}

	/**
	* Returns the dialog ID of this dialog member.
	*
	* @return the dialog ID of this dialog member
	*/
	@Override
	public long getDialogId() {
		return _dialogMember.getDialogId();
	}

	/**
	* Returns the dialog member ID of this dialog member.
	*
	* @return the dialog member ID of this dialog member
	*/
	@Override
	public long getDialogMemberId() {
		return _dialogMember.getDialogMemberId();
	}

	/**
	* Returns the member ID of this dialog member.
	*
	* @return the member ID of this dialog member
	*/
	@Override
	public long getMemberId() {
		return _dialogMember.getMemberId();
	}

	/**
	* Returns the primary key of this dialog member.
	*
	* @return the primary key of this dialog member
	*/
	@Override
	public long getPrimaryKey() {
		return _dialogMember.getPrimaryKey();
	}

	@Override
	public void persist() {
		_dialogMember.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_dialogMember.setCachedModel(cachedModel);
	}

	/**
	* Sets the dialog ID of this dialog member.
	*
	* @param dialogId the dialog ID of this dialog member
	*/
	@Override
	public void setDialogId(long dialogId) {
		_dialogMember.setDialogId(dialogId);
	}

	/**
	* Sets the dialog member ID of this dialog member.
	*
	* @param dialogMemberId the dialog member ID of this dialog member
	*/
	@Override
	public void setDialogMemberId(long dialogMemberId) {
		_dialogMember.setDialogMemberId(dialogMemberId);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_dialogMember.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_dialogMember.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_dialogMember.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the member ID of this dialog member.
	*
	* @param memberId the member ID of this dialog member
	*/
	@Override
	public void setMemberId(long memberId) {
		_dialogMember.setMemberId(memberId);
	}

	/**
	* Sets the member type of this dialog member.
	*
	* @param memberType the member type of this dialog member
	*/
	@Override
	public void setMemberType(java.lang.String memberType) {
		_dialogMember.setMemberType(memberType);
	}

	/**
	* Sets the name of this dialog member.
	*
	* @param name the name of this dialog member
	*/
	@Override
	public void setName(java.lang.String name) {
		_dialogMember.setName(name);
	}

	@Override
	public void setNew(boolean n) {
		_dialogMember.setNew(n);
	}

	/**
	* Sets the primary key of this dialog member.
	*
	* @param primaryKey the primary key of this dialog member
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_dialogMember.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_dialogMember.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DialogMemberWrapper)) {
			return false;
		}

		DialogMemberWrapper dialogMemberWrapper = (DialogMemberWrapper)obj;

		if (Objects.equals(_dialogMember, dialogMemberWrapper._dialogMember)) {
			return true;
		}

		return false;
	}

	@Override
	public DialogMember getWrappedModel() {
		return _dialogMember;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _dialogMember.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _dialogMember.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_dialogMember.resetOriginalValues();
	}

	private final DialogMember _dialogMember;
}