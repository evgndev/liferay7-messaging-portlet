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
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import evgn.dev.messaging.model.DialogMember;
import evgn.dev.messaging.model.DialogMemberModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the DialogMember service. Represents a row in the &quot;dmsg_DialogMember&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link DialogMemberModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DialogMemberImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DialogMemberImpl
 * @see DialogMember
 * @see DialogMemberModel
 * @generated
 */
@ProviderType
public class DialogMemberModelImpl extends BaseModelImpl<DialogMember>
	implements DialogMemberModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a dialog member model instance should use the {@link DialogMember} interface instead.
	 */
	public static final String TABLE_NAME = "dmsg_DialogMember";
	public static final Object[][] TABLE_COLUMNS = {
			{ "dialogMemberId", Types.BIGINT },
			{ "dialogId", Types.BIGINT },
			{ "memberId", Types.BIGINT },
			{ "memberType", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("dialogMemberId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("dialogId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("memberId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("memberType", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table dmsg_DialogMember (dialogMemberId LONG not null primary key,dialogId LONG,memberId LONG,memberType VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table dmsg_DialogMember";
	public static final String ORDER_BY_JPQL = " ORDER BY dialogMember.dialogMemberId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY dmsg_DialogMember.dialogMemberId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(evgn.dev.messaging.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.evgn.dev.messaging.model.DialogMember"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(evgn.dev.messaging.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.evgn.dev.messaging.model.DialogMember"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(evgn.dev.messaging.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.evgn.dev.messaging.model.DialogMember"),
			true);
	public static final long DIALOGID_COLUMN_BITMASK = 1L;
	public static final long MEMBERID_COLUMN_BITMASK = 2L;
	public static final long MEMBERTYPE_COLUMN_BITMASK = 4L;
	public static final long DIALOGMEMBERID_COLUMN_BITMASK = 8L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(evgn.dev.messaging.service.util.ServiceProps.get(
				"lock.expiration.time.evgn.dev.messaging.model.DialogMember"));

	public DialogMemberModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _dialogMemberId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDialogMemberId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _dialogMemberId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

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
	public long getMemberId() {
		return _memberId;
	}

	@Override
	public void setMemberId(long memberId) {
		_columnBitmask |= MEMBERID_COLUMN_BITMASK;

		if (!_setOriginalMemberId) {
			_setOriginalMemberId = true;

			_originalMemberId = _memberId;
		}

		_memberId = memberId;
	}

	public long getOriginalMemberId() {
		return _originalMemberId;
	}

	@Override
	public String getMemberType() {
		if (_memberType == null) {
			return StringPool.BLANK;
		}
		else {
			return _memberType;
		}
	}

	@Override
	public void setMemberType(String memberType) {
		_columnBitmask |= MEMBERTYPE_COLUMN_BITMASK;

		if (_originalMemberType == null) {
			_originalMemberType = _memberType;
		}

		_memberType = memberType;
	}

	public String getOriginalMemberType() {
		return GetterUtil.getString(_originalMemberType);
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			DialogMember.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public DialogMember toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (DialogMember)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		DialogMemberImpl dialogMemberImpl = new DialogMemberImpl();

		dialogMemberImpl.setDialogMemberId(getDialogMemberId());
		dialogMemberImpl.setDialogId(getDialogId());
		dialogMemberImpl.setMemberId(getMemberId());
		dialogMemberImpl.setMemberType(getMemberType());

		dialogMemberImpl.resetOriginalValues();

		return dialogMemberImpl;
	}

	@Override
	public int compareTo(DialogMember dialogMember) {
		long primaryKey = dialogMember.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DialogMember)) {
			return false;
		}

		DialogMember dialogMember = (DialogMember)obj;

		long primaryKey = dialogMember.getPrimaryKey();

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
		DialogMemberModelImpl dialogMemberModelImpl = this;

		dialogMemberModelImpl._originalDialogId = dialogMemberModelImpl._dialogId;

		dialogMemberModelImpl._setOriginalDialogId = false;

		dialogMemberModelImpl._originalMemberId = dialogMemberModelImpl._memberId;

		dialogMemberModelImpl._setOriginalMemberId = false;

		dialogMemberModelImpl._originalMemberType = dialogMemberModelImpl._memberType;

		dialogMemberModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<DialogMember> toCacheModel() {
		DialogMemberCacheModel dialogMemberCacheModel = new DialogMemberCacheModel();

		dialogMemberCacheModel.dialogMemberId = getDialogMemberId();

		dialogMemberCacheModel.dialogId = getDialogId();

		dialogMemberCacheModel.memberId = getMemberId();

		dialogMemberCacheModel.memberType = getMemberType();

		String memberType = dialogMemberCacheModel.memberType;

		if ((memberType != null) && (memberType.length() == 0)) {
			dialogMemberCacheModel.memberType = null;
		}

		return dialogMemberCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{dialogMemberId=");
		sb.append(getDialogMemberId());
		sb.append(", dialogId=");
		sb.append(getDialogId());
		sb.append(", memberId=");
		sb.append(getMemberId());
		sb.append(", memberType=");
		sb.append(getMemberType());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("evgn.dev.messaging.model.DialogMember");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>dialogMemberId</column-name><column-value><![CDATA[");
		sb.append(getDialogMemberId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dialogId</column-name><column-value><![CDATA[");
		sb.append(getDialogId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>memberId</column-name><column-value><![CDATA[");
		sb.append(getMemberId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>memberType</column-name><column-value><![CDATA[");
		sb.append(getMemberType());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = DialogMember.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			DialogMember.class
		};
	private long _dialogMemberId;
	private long _dialogId;
	private long _originalDialogId;
	private boolean _setOriginalDialogId;
	private long _memberId;
	private long _originalMemberId;
	private boolean _setOriginalMemberId;
	private String _memberType;
	private String _originalMemberType;
	private long _columnBitmask;
	private DialogMember _escapedModel;
}