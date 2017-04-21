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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class DialogSoap implements Serializable {
	public static DialogSoap toSoapModel(Dialog model) {
		DialogSoap soapModel = new DialogSoap();

		soapModel.setDialogId(model.getDialogId());
		soapModel.setTopic(model.getTopic());
		soapModel.setCreatorMemberId(model.getCreatorMemberId());
		soapModel.setLastMessageDate(model.getLastMessageDate());
		soapModel.setLastMessageId(model.getLastMessageId());
		soapModel.setDisableAnswering(model.getDisableAnswering());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setCreatorUserId(model.getCreatorUserId());

		return soapModel;
	}

	public static DialogSoap[] toSoapModels(Dialog[] models) {
		DialogSoap[] soapModels = new DialogSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DialogSoap[][] toSoapModels(Dialog[][] models) {
		DialogSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DialogSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DialogSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DialogSoap[] toSoapModels(List<Dialog> models) {
		List<DialogSoap> soapModels = new ArrayList<DialogSoap>(models.size());

		for (Dialog model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DialogSoap[soapModels.size()]);
	}

	public DialogSoap() {
	}

	public long getPrimaryKey() {
		return _dialogId;
	}

	public void setPrimaryKey(long pk) {
		setDialogId(pk);
	}

	public long getDialogId() {
		return _dialogId;
	}

	public void setDialogId(long dialogId) {
		_dialogId = dialogId;
	}

	public String getTopic() {
		return _topic;
	}

	public void setTopic(String topic) {
		_topic = topic;
	}

	public long getCreatorMemberId() {
		return _creatorMemberId;
	}

	public void setCreatorMemberId(long creatorMemberId) {
		_creatorMemberId = creatorMemberId;
	}

	public Date getLastMessageDate() {
		return _lastMessageDate;
	}

	public void setLastMessageDate(Date lastMessageDate) {
		_lastMessageDate = lastMessageDate;
	}

	public long getLastMessageId() {
		return _lastMessageId;
	}

	public void setLastMessageId(long lastMessageId) {
		_lastMessageId = lastMessageId;
	}

	public boolean getDisableAnswering() {
		return _disableAnswering;
	}

	public boolean isDisableAnswering() {
		return _disableAnswering;
	}

	public void setDisableAnswering(boolean disableAnswering) {
		_disableAnswering = disableAnswering;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public long getCreatorUserId() {
		return _creatorUserId;
	}

	public void setCreatorUserId(long creatorUserId) {
		_creatorUserId = creatorUserId;
	}

	private long _dialogId;
	private String _topic;
	private long _creatorMemberId;
	private Date _lastMessageDate;
	private long _lastMessageId;
	private boolean _disableAnswering;
	private Date _createDate;
	private long _creatorUserId;
}