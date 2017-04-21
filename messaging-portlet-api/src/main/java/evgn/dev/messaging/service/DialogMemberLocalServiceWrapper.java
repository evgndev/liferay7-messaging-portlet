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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DialogMemberLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DialogMemberLocalService
 * @generated
 */
@ProviderType
public class DialogMemberLocalServiceWrapper implements DialogMemberLocalService,
	ServiceWrapper<DialogMemberLocalService> {
	public DialogMemberLocalServiceWrapper(
		DialogMemberLocalService dialogMemberLocalService) {
		_dialogMemberLocalService = dialogMemberLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _dialogMemberLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dialogMemberLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _dialogMemberLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _dialogMemberLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _dialogMemberLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the dialog member to the database. Also notifies the appropriate model listeners.
	*
	* @param dialogMember the dialog member
	* @return the dialog member that was added
	*/
	@Override
	public evgn.dev.messaging.model.DialogMember addDialogMember(
		evgn.dev.messaging.model.DialogMember dialogMember) {
		return _dialogMemberLocalService.addDialogMember(dialogMember);
	}

	@Override
	public evgn.dev.messaging.model.DialogMember createDialogMember(
		long dialogId, com.liferay.portal.kernel.model.User user)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dialogMemberLocalService.createDialogMember(dialogId, user);
	}

	@Override
	public evgn.dev.messaging.model.DialogMember createDialogMember(
		long dialogId, long memberId, java.lang.String memberType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dialogMemberLocalService.createDialogMember(dialogId, memberId,
			memberType);
	}

	@Override
	public evgn.dev.messaging.model.DialogMember createDialogMember(
		long dialogId, long memberId, java.lang.String memberType,
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dialogMemberLocalService.createDialogMember(dialogId, memberId,
			memberType, name);
	}

	/**
	* Creates a new dialog member with the primary key. Does not add the dialog member to the database.
	*
	* @param dialogMemberId the primary key for the new dialog member
	* @return the new dialog member
	*/
	@Override
	public evgn.dev.messaging.model.DialogMember createDialogMember(
		long dialogMemberId) {
		return _dialogMemberLocalService.createDialogMember(dialogMemberId);
	}

	/**
	* Deletes the dialog member from the database. Also notifies the appropriate model listeners.
	*
	* @param dialogMember the dialog member
	* @return the dialog member that was removed
	*/
	@Override
	public evgn.dev.messaging.model.DialogMember deleteDialogMember(
		evgn.dev.messaging.model.DialogMember dialogMember) {
		return _dialogMemberLocalService.deleteDialogMember(dialogMember);
	}

	/**
	* Deletes the dialog member with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dialogMemberId the primary key of the dialog member
	* @return the dialog member that was removed
	* @throws PortalException if a dialog member with the primary key could not be found
	*/
	@Override
	public evgn.dev.messaging.model.DialogMember deleteDialogMember(
		long dialogMemberId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _dialogMemberLocalService.deleteDialogMember(dialogMemberId);
	}

	@Override
	public evgn.dev.messaging.model.DialogMember fetchDialogMember(
		long dialogMemberId) {
		return _dialogMemberLocalService.fetchDialogMember(dialogMemberId);
	}

	@Override
	public evgn.dev.messaging.model.DialogMember getByDialogAndMember(
		long dialogId, long memberId, java.lang.String memberType) {
		return _dialogMemberLocalService.getByDialogAndMember(dialogId,
			memberId, memberType);
	}

	/**
	* Returns the dialog member with the primary key.
	*
	* @param dialogMemberId the primary key of the dialog member
	* @return the dialog member
	* @throws PortalException if a dialog member with the primary key could not be found
	*/
	@Override
	public evgn.dev.messaging.model.DialogMember getDialogMember(
		long dialogMemberId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _dialogMemberLocalService.getDialogMember(dialogMemberId);
	}

	/**
	* Updates the dialog member in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dialogMember the dialog member
	* @return the dialog member that was updated
	*/
	@Override
	public evgn.dev.messaging.model.DialogMember updateDialogMember(
		evgn.dev.messaging.model.DialogMember dialogMember) {
		return _dialogMemberLocalService.updateDialogMember(dialogMember);
	}

	/**
	* Returns the number of dialog members.
	*
	* @return the number of dialog members
	*/
	@Override
	public int getDialogMembersCount() {
		return _dialogMemberLocalService.getDialogMembersCount();
	}

	@Override
	public java.lang.Object getMember(
		evgn.dev.messaging.model.DialogMember dialogMember)
		throws java.lang.Exception {
		return _dialogMemberLocalService.getMember(dialogMember);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _dialogMemberLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _dialogMemberLocalService.dynamicQuery(dynamicQuery);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _dialogMemberLocalService.dynamicQuery(dynamicQuery, start, end);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _dialogMemberLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* @return empty in error case
	*/
	@Override
	public java.util.List<evgn.dev.messaging.model.DialogMember> getByDialog(
		long dialogId) {
		return _dialogMemberLocalService.getByDialog(dialogId);
	}

	/**
	* @return empty in error case
	*/
	@Override
	public java.util.List<evgn.dev.messaging.model.DialogMember> getByUser(
		long userId) {
		return _dialogMemberLocalService.getByUser(userId);
	}

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
	@Override
	public java.util.List<evgn.dev.messaging.model.DialogMember> getDialogMembers(
		int start, int end) {
		return _dialogMemberLocalService.getDialogMembers(start, end);
	}

	/**
	* @return id of organizations which is member of this dialog
	*/
	@Override
	public java.util.List<java.lang.Object> getMembersByDialog(long dialogId) {
		return _dialogMemberLocalService.getMembersByDialog(dialogId);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _dialogMemberLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _dialogMemberLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public DialogMemberLocalService getWrappedService() {
		return _dialogMemberLocalService;
	}

	@Override
	public void setWrappedService(
		DialogMemberLocalService dialogMemberLocalService) {
		_dialogMemberLocalService = dialogMemberLocalService;
	}

	private DialogMemberLocalService _dialogMemberLocalService;
}