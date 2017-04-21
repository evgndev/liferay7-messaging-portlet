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
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class DialogMemberSoap implements Serializable {
	public static DialogMemberSoap toSoapModel(DialogMember model) {
		DialogMemberSoap soapModel = new DialogMemberSoap();

		soapModel.setDialogMemberId(model.getDialogMemberId());
		soapModel.setDialogId(model.getDialogId());
		soapModel.setMemberId(model.getMemberId());
		soapModel.setMemberType(model.getMemberType());
		soapModel.setName(model.getName());

		return soapModel;
	}

	public static DialogMemberSoap[] toSoapModels(DialogMember[] models) {
		DialogMemberSoap[] soapModels = new DialogMemberSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DialogMemberSoap[][] toSoapModels(DialogMember[][] models) {
		DialogMemberSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DialogMemberSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DialogMemberSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DialogMemberSoap[] toSoapModels(List<DialogMember> models) {
		List<DialogMemberSoap> soapModels = new ArrayList<DialogMemberSoap>(models.size());

		for (DialogMember model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DialogMemberSoap[soapModels.size()]);
	}

	public DialogMemberSoap() {
	}

	public long getPrimaryKey() {
		return _dialogMemberId;
	}

	public void setPrimaryKey(long pk) {
		setDialogMemberId(pk);
	}

	public long getDialogMemberId() {
		return _dialogMemberId;
	}

	public void setDialogMemberId(long dialogMemberId) {
		_dialogMemberId = dialogMemberId;
	}

	public long getDialogId() {
		return _dialogId;
	}

	public void setDialogId(long dialogId) {
		_dialogId = dialogId;
	}

	public long getMemberId() {
		return _memberId;
	}

	public void setMemberId(long memberId) {
		_memberId = memberId;
	}

	public String getMemberType() {
		return _memberType;
	}

	public void setMemberType(String memberType) {
		_memberType = memberType;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	private long _dialogMemberId;
	private long _dialogId;
	private long _memberId;
	private String _memberType;
	private String _name;
}