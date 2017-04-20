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

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import evgn.dev.messaging.model.DialogMessage;
import evgn.dev.messaging.model.DialogMessageModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the DialogMessage service. Represents a row in the &quot;dmsg_DialogMessage&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link DialogMessageModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DialogMessageImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DialogMessageImpl
 * @see DialogMessage
 * @see DialogMessageModel
 * @generated
 */
@ProviderType
public class DialogMessageModelImpl extends BaseModelImpl<DialogMessage>
	implements DialogMessageModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a dialog message model instance should use the {@link DialogMessage} interface instead.
	 */
	public static final String TABLE_NAME = "dmsg_DialogMessage";
	public static final Object[][] TABLE_COLUMNS = {
			{ "messageId", Types.BIGINT },
			{ "dialogId", Types.BIGINT },
			{ "text_", Types.VARCHAR },
			{ "dialogMemberId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("messageId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("dialogId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("text_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("dialogMemberId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE = "create table dmsg_DialogMessage (messageId LONG not null primary key,dialogId LONG,text_ VARCHAR(75) null,dialogMemberId LONG,userId LONG,createDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table dmsg_DialogMessage";
	public static final String ORDER_BY_JPQL = " ORDER BY dialogMessage.createDate ASC";
	public static final String ORDER_BY_SQL = " ORDER BY dmsg_DialogMessage.createDate ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(evgn.dev.messaging.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.evgn.dev.messaging.model.DialogMessage"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(evgn.dev.messaging.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.evgn.dev.messaging.model.DialogMessage"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(evgn.dev.messaging.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.evgn.dev.messaging.model.DialogMessage"),
			true);
	public static final long DIALOGID_COLUMN_BITMASK = 1L;
	public static final long CREATEDATE_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(evgn.dev.messaging.service.util.ServiceProps.get(
				"lock.expiration.time.evgn.dev.messaging.model.DialogMessage"));

	public DialogMessageModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _messageId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setMessageId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _messageId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

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
	public long getMessageId() {
		return _messageId;
	}

	@Override
	public void setMessageId(long messageId) {
		_messageId = messageId;
	}

	@Override
	public long getDialogId() {
		return _dialogId;
	}

	@Override
	public void setDialogId(long dialogId) {
		_columnBitmask |= DIALOGID_COLUMN_BITMASK;

		if (!_setOriginalDialogId) {
			_setOriginalDialogId = true;

			_originalDialogId = _dialogId;
		}

		_dialogId = dialogId;
	}

	public long getOriginalDialogId() {
		return _originalDialogId;
	}

	@Override
	public String getText() {
		if (_text == null) {
			return StringPool.BLANK;
		}
		else {
			return _text;
		}
	}

	@Override
	public void setText(String text) {
		_text = text;
	}

	@Override
	public long getDialogMemberId() {
		return _dialogMemberId;
	}

	@Override
	public void setDialogMemberId(long dialogMemberId) {
		_dialogMemberId = dialogMemberId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_columnBitmask = -1L;

		_createDate = createDate;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			DialogMessage.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public DialogMessage toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (DialogMessage)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		DialogMessageImpl dialogMessageImpl = new DialogMessageImpl();

		dialogMessageImpl.setMessageId(getMessageId());
		dialogMessageImpl.setDialogId(getDialogId());
		dialogMessageImpl.setText(getText());
		dialogMessageImpl.setDialogMemberId(getDialogMemberId());
		dialogMessageImpl.setUserId(getUserId());
		dialogMessageImpl.setCreateDate(getCreateDate());

		dialogMessageImpl.resetOriginalValues();

		return dialogMessageImpl;
	}

	@Override
	public int compareTo(DialogMessage dialogMessage) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(),
				dialogMessage.getCreateDate());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DialogMessage)) {
			return false;
		}

		DialogMessage dialogMessage = (DialogMessage)obj;

		long primaryKey = dialogMessage.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		DialogMessageModelImpl dialogMessageModelImpl = this;

		dialogMessageModelImpl._originalDialogId = dialogMessageModelImpl._dialogId;

		dialogMessageModelImpl._setOriginalDialogId = false;

		dialogMessageModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<DialogMessage> toCacheModel() {
		DialogMessageCacheModel dialogMessageCacheModel = new DialogMessageCacheModel();

		dialogMessageCacheModel.messageId = getMessageId();

		dialogMessageCacheModel.dialogId = getDialogId();

		dialogMessageCacheModel.text = getText();

		String text = dialogMessageCacheModel.text;

		if ((text != null) && (text.length() == 0)) {
			dialogMessageCacheModel.text = null;
		}

		dialogMessageCacheModel.dialogMemberId = getDialogMemberId();

		dialogMessageCacheModel.userId = getUserId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			dialogMessageCacheModel.createDate = createDate.getTime();
		}
		else {
			dialogMessageCacheModel.createDate = Long.MIN_VALUE;
		}

		return dialogMessageCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{messageId=");
		sb.append(getMessageId());
		sb.append(", dialogId=");
		sb.append(getDialogId());
		sb.append(", text=");
		sb.append(getText());
		sb.append(", dialogMemberId=");
		sb.append(getDialogMemberId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("evgn.dev.messaging.model.DialogMessage");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>messageId</column-name><column-value><![CDATA[");
		sb.append(getMessageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dialogId</column-name><column-value><![CDATA[");
		sb.append(getDialogId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>text</column-name><column-value><![CDATA[");
		sb.append(getText());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dialogMemberId</column-name><column-value><![CDATA[");
		sb.append(getDialogMemberId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = DialogMessage.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			DialogMessage.class
		};
	private long _messageId;
	private long _dialogId;
	private long _originalDialogId;
	private boolean _setOriginalDialogId;
	private String _text;
	private long _dialogMemberId;
	private long _userId;
	private Date _createDate;
	private long _columnBitmask;
	private DialogMessage _escapedModel;
}