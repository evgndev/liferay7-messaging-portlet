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

package evgn.dev.messaging.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import evgn.dev.messaging.model.DialogMember;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service interface for DialogMember. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see DialogMemberLocalServiceUtil
 * @see evgn.dev.messaging.service.base.DialogMemberLocalServiceBaseImpl
 * @see evgn.dev.messaging.service.impl.DialogMemberLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface DialogMemberLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DialogMemberLocalServiceUtil} to access the dialog member local service. Add custom service methods to {@link evgn.dev.messaging.service.impl.DialogMemberLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	public DynamicQuery dynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	* @throws PortalException
	*/
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	* Adds the dialog member to the database. Also notifies the appropriate model listeners.
	*
	* @param dialogMember the dialog member
	* @return the dialog member that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public DialogMember addDialogMember(DialogMember dialogMember);

	public DialogMember createDialogMember(long dialogId, User user)
		throws SystemException;

	public DialogMember createDialogMember(long dialogId, long memberId,
		java.lang.String memberType) throws SystemException;

	/**
	* Creates a new dialog member with the primary key. Does not add the dialog member to the database.
	*
	* @param dialogMemberId the primary key for the new dialog member
	* @return the new dialog member
	*/
	public DialogMember createDialogMember(long dialogMemberId);

	/**
	* Deletes the dialog member from the database. Also notifies the appropriate model listeners.
	*
	* @param dialogMember the dialog member
	* @return the dialog member that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public DialogMember deleteDialogMember(DialogMember dialogMember);

	/**
	* Deletes the dialog member with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dialogMemberId the primary key of the dialog member
	* @return the dialog member that was removed
	* @throws PortalException if a dialog member with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public DialogMember deleteDialogMember(long dialogMemberId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DialogMember fetchDialogMember(long dialogMemberId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DialogMember getByDialogAndMember(long dialogId, long memberId,
		java.lang.String memberType);

	/**
	* Returns the dialog member with the primary key.
	*
	* @param dialogMemberId the primary key of the dialog member
	* @return the dialog member
	* @throws PortalException if a dialog member with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DialogMember getDialogMember(long dialogMemberId)
		throws PortalException;

	/**
	* Updates the dialog member in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dialogMember the dialog member
	* @return the dialog member that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public DialogMember updateDialogMember(DialogMember dialogMember);

	/**
	* Returns the number of dialog members.
	*
	* @return the number of dialog members
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getDialogMembersCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.Object getMember(DialogMember dialogMember)
		throws java.lang.Exception;

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link evgn.dev.messaging.model.impl.DialogMemberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end);

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link evgn.dev.messaging.model.impl.DialogMemberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator);

	/**
	* @return empty in error case
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DialogMember> getByDialog(long dialogId);

	/**
	* @return empty in error case
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DialogMember> getByUser(long userId);

	/**
	* Returns a range of all the dialog members.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link evgn.dev.messaging.model.impl.DialogMemberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dialog members
	* @param end the upper bound of the range of dialog members (not inclusive)
	* @return the range of dialog members
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DialogMember> getDialogMembers(int start, int end);

	/**
	* @return id of organizations which is member of this dialog
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<java.lang.Object> getMembersByDialod(long dialogId);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection);
}