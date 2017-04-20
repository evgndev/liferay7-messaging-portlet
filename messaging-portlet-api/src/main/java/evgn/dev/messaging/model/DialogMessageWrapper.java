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
 * This class is a wrapper for {@link DialogMessage}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DialogMessage
 * @generated
 */
@ProviderType
public class DialogMessageWrapper implements DialogMessage,
	ModelWrapper<DialogMessage> {
	public DialogMessageWrapper(DialogMessage dialogMessage) {
		_dialogMessage = dialogMessage;
	}

	@Override
	public Class<?> getModelClass() {
		return DialogMessage.class;
	}

	@Override
	public String getModelClassName() {
		return DialogMessage.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("messageId", getMessageId());
		attributes.put("dialogId", getDialogId());
		attributes.put("text", getText());
		attributes.put("dialogMemberId", getDialogMemberId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long messageId = (Long)attributes.get("messageId");

		if (messageId != null) {
			setMessageId(messageId);
		}

		Long dialogId = (Long)attributes.get("dialogId");

		if (dialogId != null) {
			setDialogId(dialogId);
		}

		String text = (String)attributes.get("text");

		if (text != null) {
			setText(text);
		}

		Long dialogMemberId = (Long)attributes.get("dialogMemberId");

		if (dialogMemberId != null) {
			setDialogMemberId(dialogMemberId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _dialogMessage.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _dialogMessage.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _dialogMessage.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _dialogMessage.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<evgn.dev.messaging.model.DialogMessage> toCacheModel() {
		return _dialogMessage.toCacheModel();
	}

	@Override
	public evgn.dev.messaging.model.DialogMessage toEscapedModel() {
		return new DialogMessageWrapper(_dialogMessage.toEscapedModel());
	}

	@Override
	public evgn.dev.messaging.model.DialogMessage toUnescapedModel() {
		return new DialogMessageWrapper(_dialogMessage.toUnescapedModel());
	}

	@Override
	public int compareTo(evgn.dev.messaging.model.DialogMessage dialogMessage) {
		return _dialogMessage.compareTo(dialogMessage);
	}

	@Override
	public int hashCode() {
		return _dialogMessage.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _dialogMessage.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new DialogMessageWrapper((DialogMessage)_dialogMessage.clone());
	}

	/**
	* Returns the text of this dialog message.
	*
	* @return the text of this dialog message
	*/
	@Override
	public java.lang.String getText() {
		return _dialogMessage.getText();
	}

	/**
	* Returns the user uuid of this dialog message.
	*
	* @return the user uuid of this dialog message
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _dialogMessage.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _dialogMessage.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _dialogMessage.toXmlString();
	}

	/**
	* Returns the create date of this dialog message.
	*
	* @return the create date of this dialog message
	*/
	@Override
	public Date getCreateDate() {
		return _dialogMessage.getCreateDate();
	}

	/**
	* Returns the dialog ID of this dialog message.
	*
	* @return the dialog ID of this dialog message
	*/
	@Override
	public long getDialogId() {
		return _dialogMessage.getDialogId();
	}

	/**
	* Returns the dialog member ID of this dialog message.
	*
	* @return the dialog member ID of this dialog message
	*/
	@Override
	public long getDialogMemberId() {
		return _dialogMessage.getDialogMemberId();
	}

	/**
	* Returns the message ID of this dialog message.
	*
	* @return the message ID of this dialog message
	*/
	@Override
	public long getMessageId() {
		return _dialogMessage.getMessageId();
	}

	/**
	* Returns the primary key of this dialog message.
	*
	* @return the primary key of this dialog message
	*/
	@Override
	public long getPrimaryKey() {
		return _dialogMessage.getPrimaryKey();
	}

	/**
	* Returns the user ID of this dialog message.
	*
	* @return the user ID of this dialog message
	*/
	@Override
	public long getUserId() {
		return _dialogMessage.getUserId();
	}

	@Override
	public void persist() {
		_dialogMessage.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_dialogMessage.setCachedModel(cachedModel);
	}

	/**
	* Sets the create date of this dialog message.
	*
	* @param createDate the create date of this dialog message
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_dialogMessage.setCreateDate(createDate);
	}

	/**
	* Sets the dialog ID of this dialog message.
	*
	* @param dialogId the dialog ID of this dialog message
	*/
	@Override
	public void setDialogId(long dialogId) {
		_dialogMessage.setDialogId(dialogId);
	}

	/**
	* Sets the dialog member ID of this dialog message.
	*
	* @param dialogMemberId the dialog member ID of this dialog message
	*/
	@Override
	public void setDialogMemberId(long dialogMemberId) {
		_dialogMessage.setDialogMemberId(dialogMemberId);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_dialogMessage.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_dialogMessage.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_dialogMessage.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the message ID of this dialog message.
	*
	* @param messageId the message ID of this dialog message
	*/
	@Override
	public void setMessageId(long messageId) {
		_dialogMessage.setMessageId(messageId);
	}

	@Override
	public void setNew(boolean n) {
		_dialogMessage.setNew(n);
	}

	/**
	* Sets the primary key of this dialog message.
	*
	* @param primaryKey the primary key of this dialog message
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_dialogMessage.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_dialogMessage.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the text of this dialog message.
	*
	* @param text the text of this dialog message
	*/
	@Override
	public void setText(java.lang.String text) {
		_dialogMessage.setText(text);
	}

	/**
	* Sets the user ID of this dialog message.
	*
	* @param userId the user ID of this dialog message
	*/
	@Override
	public void setUserId(long userId) {
		_dialogMessage.setUserId(userId);
	}

	/**
	* Sets the user uuid of this dialog message.
	*
	* @param userUuid the user uuid of this dialog message
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_dialogMessage.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DialogMessageWrapper)) {
			return false;
		}

		DialogMessageWrapper dialogMessageWrapper = (DialogMessageWrapper)obj;

		if (Objects.equals(_dialogMessage, dialogMessageWrapper._dialogMessage)) {
			return true;
		}

		return false;
	}

	@Override
	public DialogMessage getWrappedModel() {
		return _dialogMessage;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _dialogMessage.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _dialogMessage.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_dialogMessage.resetOriginalValues();
	}

	private final DialogMessage _dialogMessage;
}