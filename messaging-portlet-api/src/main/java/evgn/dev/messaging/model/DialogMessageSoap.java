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
public class DialogMessageSoap implements Serializable {
	public static DialogMessageSoap toSoapModel(DialogMessage model) {
		DialogMessageSoap soapModel = new DialogMessageSoap();

		soapModel.setMessageId(model.getMessageId());
		soapModel.setDialogId(model.getDialogId());
		soapModel.setText(model.getText());
		soapModel.setDialogMemberId(model.getDialogMemberId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());

		return soapModel;
	}

	public static DialogMessageSoap[] toSoapModels(DialogMessage[] models) {
		DialogMessageSoap[] soapModels = new DialogMessageSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DialogMessageSoap[][] toSoapModels(DialogMessage[][] models) {
		DialogMessageSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DialogMessageSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DialogMessageSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DialogMessageSoap[] toSoapModels(List<DialogMessage> models) {
		List<DialogMessageSoap> soapModels = new ArrayList<DialogMessageSoap>(models.size());

		for (DialogMessage model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DialogMessageSoap[soapModels.size()]);
	}

	public DialogMessageSoap() {
	}

	public long getPrimaryKey() {
		return _messageId;
	}

	public void setPrimaryKey(long pk) {
		setMessageId(pk);
	}

	public long getMessageId() {
		return _messageId;
	}

	public void setMessageId(long messageId) {
		_messageId = messageId;
	}

	public long getDialogId() {
		return _dialogId;
	}

	public void setDialogId(long dialogId) {
		_dialogId = dialogId;
	}

	public String getText() {
		return _text;
	}

	public void setText(String text) {
		_text = text;
	}

	public long getDialogMemberId() {
		return _dialogMemberId;
	}

	public void setDialogMemberId(long dialogMemberId) {
		_dialogMemberId = dialogMemberId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	private long _messageId;
	private long _dialogId;
	private String _text;
	private long _dialogMemberId;
	private long _userId;
	private Date _createDate;
}