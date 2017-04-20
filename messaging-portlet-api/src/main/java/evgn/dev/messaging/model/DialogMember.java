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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the DialogMember service. Represents a row in the &quot;dmsg_DialogMember&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see DialogMemberModel
 * @see evgn.dev.messaging.model.impl.DialogMemberImpl
 * @see evgn.dev.messaging.model.impl.DialogMemberModelImpl
 * @generated
 */
@ImplementationClassName("evgn.dev.messaging.model.impl.DialogMemberImpl")
@ProviderType
public interface DialogMember extends DialogMemberModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link evgn.dev.messaging.model.impl.DialogMemberImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<DialogMember, Long> DIALOG_MEMBER_ID_ACCESSOR = new Accessor<DialogMember, Long>() {
			@Override
			public Long get(DialogMember dialogMember) {
				return dialogMember.getDialogMemberId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<DialogMember> getTypeClass() {
				return DialogMember.class;
			}
		};
}