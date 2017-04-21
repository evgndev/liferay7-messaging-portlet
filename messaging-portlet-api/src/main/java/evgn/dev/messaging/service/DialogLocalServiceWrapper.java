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
 * Provides a wrapper for {@link DialogLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DialogLocalService
 * @generated
 */
@ProviderType
public class DialogLocalServiceWrapper implements DialogLocalService,
	ServiceWrapper<DialogLocalService> {
	public DialogLocalServiceWrapper(DialogLocalService dialogLocalService) {
		_dialogLocalService = dialogLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _dialogLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dialogLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _dialogLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _dialogLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _dialogLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the dialog to the database. Also notifies the appropriate model listeners.
	*
	* @param dialog the dialog
	* @return the dialog that was added
	*/
	@Override
	public evgn.dev.messaging.model.Dialog addDialog(
		evgn.dev.messaging.model.Dialog dialog) {
		return _dialogLocalService.addDialog(dialog);
	}

	/**
	* Creates a new dialog with the primary key. Does not add the dialog to the database.
	*
	* @param dialogId the primary key for the new dialog
	* @return the new dialog
	*/
	@Override
	public evgn.dev.messaging.model.Dialog createDialog(long dialogId) {
		return _dialogLocalService.createDialog(dialogId);
	}

	/**
	* Deletes the dialog from the database. Also notifies the appropriate model listeners.
	*
	* @param dialog the dialog
	* @return the dialog that was removed
	*/
	@Override
	public evgn.dev.messaging.model.Dialog deleteDialog(
		evgn.dev.messaging.model.Dialog dialog) {
		return _dialogLocalService.deleteDialog(dialog);
	}

	/**
	* Deletes the dialog with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dialogId the primary key of the dialog
	* @return the dialog that was removed
	* @throws PortalException if a dialog with the primary key could not be found
	*/
	@Override
	public evgn.dev.messaging.model.Dialog deleteDialog(long dialogId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _dialogLocalService.deleteDialog(dialogId);
	}

	@Override
	public evgn.dev.messaging.model.Dialog fetchDialog(long dialogId) {
		return _dialogLocalService.fetchDialog(dialogId);
	}

	/**
	* Returns the dialog with the primary key.
	*
	* @param dialogId the primary key of the dialog
	* @return the dialog
	* @throws PortalException if a dialog with the primary key could not be found
	*/
	@Override
	public evgn.dev.messaging.model.Dialog getDialog(long dialogId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _dialogLocalService.getDialog(dialogId);
	}

	/**
	* Updates the dialog in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dialog the dialog
	* @return the dialog that was updated
	*/
	@Override
	public evgn.dev.messaging.model.Dialog updateDialog(
		evgn.dev.messaging.model.Dialog dialog) {
		return _dialogLocalService.updateDialog(dialog);
	}

	/**
	* Returns the number of dialogs.
	*
	* @return the number of dialogs
	*/
	@Override
	public int getDialogsCount() {
		return _dialogLocalService.getDialogsCount();
	}

	@Override
	public java.lang.Long getUserDialogsCount(
		com.liferay.portal.kernel.model.User user) {
		return _dialogLocalService.getUserDialogsCount(user);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _dialogLocalService.getOSGiServiceIdentifier();
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
		return _dialogLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link evgn.dev.messaging.model.impl.DialogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _dialogLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link evgn.dev.messaging.model.impl.DialogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _dialogLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns a range of all the dialogs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link evgn.dev.messaging.model.impl.DialogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dialogs
	* @param end the upper bound of the range of dialogs (not inclusive)
	* @return the range of dialogs
	*/
	@Override
	public java.util.List<evgn.dev.messaging.model.Dialog> getDialogs(
		int start, int end) {
		return _dialogLocalService.getDialogs(start, end);
	}

	@Override
	public java.util.List<evgn.dev.messaging.model.Dialog> getUserDialogs(
		com.liferay.portal.kernel.model.User user, int start, int end) {
		return _dialogLocalService.getUserDialogs(user, start, end);
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
		return _dialogLocalService.dynamicQueryCount(dynamicQuery);
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
		return _dialogLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public DialogLocalService getWrappedService() {
		return _dialogLocalService;
	}

	@Override
	public void setWrappedService(DialogLocalService dialogLocalService) {
		_dialogLocalService = dialogLocalService;
	}

	private DialogLocalService _dialogLocalService;
}