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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Dialog}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Dialog
 * @generated
 */
@ProviderType
public class DialogWrapper implements Dialog, ModelWrapper<Dialog> {
	public DialogWrapper(Dialog dialog) {
		_dialog = dialog;
	}

	@Override
	public Class<?> getModelClass() {
		return Dialog.class;
	}

	@Override
	public String getModelClassName() {
		return Dialog.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dialogId", getDialogId());
		attributes.put("topic", getTopic());
		attributes.put("creatorMemberId", getCreatorMemberId());
		attributes.put("lastMessageDate", getLastMessageDate());
		attributes.put("lastMessageId", getLastMessageId());
		attributes.put("disableAnswering", getDisableAnswering());
		attributes.put("createDate", getCreateDate());
		attributes.put("creatorUserId", getCreatorUserId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long dialogId = (Long)attributes.get("dialogId");

		if (dialogId != null) {
			setDialogId(dialogId);
		}

		String topic = (String)attributes.get("topic");

		if (topic != null) {
			setTopic(topic);
		}

		Long creatorMemberId = (Long)attributes.get("creatorMemberId");

		if (creatorMemberId != null) {
			setCreatorMemberId(creatorMemberId);
		}

		Date lastMessageDate = (Date)attributes.get("lastMessageDate");

		if (lastMessageDate != null) {
			setLastMessageDate(lastMessageDate);
		}

		Long lastMessageId = (Long)attributes.get("lastMessageId");

		if (lastMessageId != null) {
			setLastMessageId(lastMessageId);
		}

		Boolean disableAnswering = (Boolean)attributes.get("disableAnswering");

		if (disableAnswering != null) {
			setDisableAnswering(disableAnswering);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long creatorUserId = (Long)attributes.get("creatorUserId");

		if (creatorUserId != null) {
			setCreatorUserId(creatorUserId);
		}
	}

	/**
	* Returns the disable answering of this dialog.
	*
	* @return the disable answering of this dialog
	*/
	@Override
	public boolean getDisableAnswering() {
		return _dialog.getDisableAnswering();
	}

	@Override
	public boolean isCachedModel() {
		return _dialog.isCachedModel();
	}

	/**
	* Returns <code>true</code> if this dialog is disable answering.
	*
	* @return <code>true</code> if this dialog is disable answering; <code>false</code> otherwise
	*/
	@Override
	public boolean isDisableAnswering() {
		return _dialog.isDisableAnswering();
	}

	@Override
	public boolean isEscapedModel() {
		return _dialog.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _dialog.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _dialog.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<evgn.dev.messaging.model.Dialog> toCacheModel() {
		return _dialog.toCacheModel();
	}

	@Override
	public evgn.dev.messaging.model.Dialog toEscapedModel() {
		return new DialogWrapper(_dialog.toEscapedModel());
	}

	@Override
	public evgn.dev.messaging.model.Dialog toUnescapedModel() {
		return new DialogWrapper(_dialog.toUnescapedModel());
	}

	@Override
	public int compareTo(evgn.dev.messaging.model.Dialog dialog) {
		return _dialog.compareTo(dialog);
	}

	@Override
	public int hashCode() {
		return _dialog.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _dialog.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new DialogWrapper((Dialog)_dialog.clone());
	}

	/**
	* Returns the creator user uuid of this dialog.
	*
	* @return the creator user uuid of this dialog
	*/
	@Override
	public java.lang.String getCreatorUserUuid() {
		return _dialog.getCreatorUserUuid();
	}

	/**
	* Returns the topic of this dialog.
	*
	* @return the topic of this dialog
	*/
	@Override
	public java.lang.String getTopic() {
		return _dialog.getTopic();
	}

	@Override
	public java.lang.String toString() {
		return _dialog.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _dialog.toXmlString();
	}

	/**
	* Returns the create date of this dialog.
	*
	* @return the create date of this dialog
	*/
	@Override
	public Date getCreateDate() {
		return _dialog.getCreateDate();
	}

	/**
	* Returns the last message date of this dialog.
	*
	* @return the last message date of this dialog
	*/
	@Override
	public Date getLastMessageDate() {
		return _dialog.getLastMessageDate();
	}

	/**
	* Returns the creator member ID of this dialog.
	*
	* @return the creator member ID of this dialog
	*/
	@Override
	public long getCreatorMemberId() {
		return _dialog.getCreatorMemberId();
	}

	/**
	* Returns the creator user ID of this dialog.
	*
	* @return the creator user ID of this dialog
	*/
	@Override
	public long getCreatorUserId() {
		return _dialog.getCreatorUserId();
	}

	/**
	* Returns the dialog ID of this dialog.
	*
	* @return the dialog ID of this dialog
	*/
	@Override
	public long getDialogId() {
		return _dialog.getDialogId();
	}

	/**
	* Returns the last message ID of this dialog.
	*
	* @return the last message ID of this dialog
	*/
	@Override
	public long getLastMessageId() {
		return _dialog.getLastMessageId();
	}

	/**
	* Returns the primary key of this dialog.
	*
	* @return the primary key of this dialog
	*/
	@Override
	public long getPrimaryKey() {
		return _dialog.getPrimaryKey();
	}

	@Override
	public void persist() {
		_dialog.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_dialog.setCachedModel(cachedModel);
	}

	/**
	* Sets the create date of this dialog.
	*
	* @param createDate the create date of this dialog
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_dialog.setCreateDate(createDate);
	}

	/**
	* Sets the creator member ID of this dialog.
	*
	* @param creatorMemberId the creator member ID of this dialog
	*/
	@Override
	public void setCreatorMemberId(long creatorMemberId) {
		_dialog.setCreatorMemberId(creatorMemberId);
	}

	/**
	* Sets the creator user ID of this dialog.
	*
	* @param creatorUserId the creator user ID of this dialog
	*/
	@Override
	public void setCreatorUserId(long creatorUserId) {
		_dialog.setCreatorUserId(creatorUserId);
	}

	/**
	* Sets the creator user uuid of this dialog.
	*
	* @param creatorUserUuid the creator user uuid of this dialog
	*/
	@Override
	public void setCreatorUserUuid(java.lang.String creatorUserUuid) {
		_dialog.setCreatorUserUuid(creatorUserUuid);
	}

	/**
	* Sets the dialog ID of this dialog.
	*
	* @param dialogId the dialog ID of this dialog
	*/
	@Override
	public void setDialogId(long dialogId) {
		_dialog.setDialogId(dialogId);
	}

	/**
	* Sets whether this dialog is disable answering.
	*
	* @param disableAnswering the disable answering of this dialog
	*/
	@Override
	public void setDisableAnswering(boolean disableAnswering) {
		_dialog.setDisableAnswering(disableAnswering);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_dialog.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_dialog.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_dialog.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the last message date of this dialog.
	*
	* @param lastMessageDate the last message date of this dialog
	*/
	@Override
	public void setLastMessageDate(Date lastMessageDate) {
		_dialog.setLastMessageDate(lastMessageDate);
	}

	/**
	* Sets the last message ID of this dialog.
	*
	* @param lastMessageId the last message ID of this dialog
	*/
	@Override
	public void setLastMessageId(long lastMessageId) {
		_dialog.setLastMessageId(lastMessageId);
	}

	@Override
	public void setNew(boolean n) {
		_dialog.setNew(n);
	}

	/**
	* Sets the primary key of this dialog.
	*
	* @param primaryKey the primary key of this dialog
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_dialog.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_dialog.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the topic of this dialog.
	*
	* @param topic the topic of this dialog
	*/
	@Override
	public void setTopic(java.lang.String topic) {
		_dialog.setTopic(topic);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DialogWrapper)) {
			return false;
		}

		DialogWrapper dialogWrapper = (DialogWrapper)obj;

		if (Objects.equals(_dialog, dialogWrapper._dialog)) {
			return true;
		}

		return false;
	}

	@Override
	public Dialog getWrappedModel() {
		return _dialog;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _dialog.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _dialog.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_dialog.resetOriginalValues();
	}

	private final Dialog _dialog;
}