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
 * Provides a wrapper for {@link DialogMessageLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DialogMessageLocalService
 * @generated
 */
@ProviderType
public class DialogMessageLocalServiceWrapper
	implements DialogMessageLocalService,
		ServiceWrapper<DialogMessageLocalService> {
	public DialogMessageLocalServiceWrapper(
		DialogMessageLocalService dialogMessageLocalService) {
		_dialogMessageLocalService = dialogMessageLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _dialogMessageLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dialogMessageLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _dialogMessageLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _dialogMessageLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _dialogMessageLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the dialog message to the database. Also notifies the appropriate model listeners.
	*
	* @param dialogMessage the dialog message
	* @return the dialog message that was added
	*/
	@Override
	public evgn.dev.messaging.model.DialogMessage addDialogMessage(
		evgn.dev.messaging.model.DialogMessage dialogMessage) {
		return _dialogMessageLocalService.addDialogMessage(dialogMessage);
	}

	/**
	* Creates a new dialog message with the primary key. Does not add the dialog message to the database.
	*
	* @param messageId the primary key for the new dialog message
	* @return the new dialog message
	*/
	@Override
	public evgn.dev.messaging.model.DialogMessage createDialogMessage(
		long messageId) {
		return _dialogMessageLocalService.createDialogMessage(messageId);
	}

	@Override
	public evgn.dev.messaging.model.DialogMessage createMessage(
		com.liferay.portal.kernel.model.User user, long dialogId,
		java.lang.String topic, java.lang.String text, long receiverId,
		java.lang.String receiverType, java.util.List<java.lang.String> errors)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dialogMessageLocalService.createMessage(user, dialogId, topic,
			text, receiverId, receiverType, errors);
	}

	/**
	* Deletes the dialog message from the database. Also notifies the appropriate model listeners.
	*
	* @param dialogMessage the dialog message
	* @return the dialog message that was removed
	*/
	@Override
	public evgn.dev.messaging.model.DialogMessage deleteDialogMessage(
		evgn.dev.messaging.model.DialogMessage dialogMessage) {
		return _dialogMessageLocalService.deleteDialogMessage(dialogMessage);
	}

	/**
	* Deletes the dialog message with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param messageId the primary key of the dialog message
	* @return the dialog message that was removed
	* @throws PortalException if a dialog message with the primary key could not be found
	*/
	@Override
	public evgn.dev.messaging.model.DialogMessage deleteDialogMessage(
		long messageId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _dialogMessageLocalService.deleteDialogMessage(messageId);
	}

	@Override
	public evgn.dev.messaging.model.DialogMessage fetchDialogMessage(
		long messageId) {
		return _dialogMessageLocalService.fetchDialogMessage(messageId);
	}

	/**
	* Returns the dialog message with the primary key.
	*
	* @param messageId the primary key of the dialog message
	* @return the dialog message
	* @throws PortalException if a dialog message with the primary key could not be found
	*/
	@Override
	public evgn.dev.messaging.model.DialogMessage getDialogMessage(
		long messageId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _dialogMessageLocalService.getDialogMessage(messageId);
	}

	@Override
	public evgn.dev.messaging.model.DialogMessage getLastMessage(long dialogId) {
		return _dialogMessageLocalService.getLastMessage(dialogId);
	}

	/**
	* Updates the dialog message in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dialogMessage the dialog message
	* @return the dialog message that was updated
	*/
	@Override
	public evgn.dev.messaging.model.DialogMessage updateDialogMessage(
		evgn.dev.messaging.model.DialogMessage dialogMessage) {
		return _dialogMessageLocalService.updateDialogMessage(dialogMessage);
	}

	/**
	* Returns the number of dialog messages.
	*
	* @return the number of dialog messages
	*/
	@Override
	public int getDialogMessagesCount() {
		return _dialogMessageLocalService.getDialogMessagesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _dialogMessageLocalService.getOSGiServiceIdentifier();
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
		return _dialogMessageLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link evgn.dev.messaging.model.impl.DialogMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _dialogMessageLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link evgn.dev.messaging.model.impl.DialogMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _dialogMessageLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns a range of all the dialog messages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link evgn.dev.messaging.model.impl.DialogMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dialog messages
	* @param end the upper bound of the range of dialog messages (not inclusive)
	* @return the range of dialog messages
	*/
	@Override
	public java.util.List<evgn.dev.messaging.model.DialogMessage> getDialogMessages(
		int start, int end) {
		return _dialogMessageLocalService.getDialogMessages(start, end);
	}

	@Override
	public java.util.List<evgn.dev.messaging.model.DialogMessage> getMessages(
		long dialogId) {
		return _dialogMessageLocalService.getMessages(dialogId);
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
		return _dialogMessageLocalService.dynamicQueryCount(dynamicQuery);
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
		return _dialogMessageLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public DialogMessageLocalService getWrappedService() {
		return _dialogMessageLocalService;
	}

	@Override
	public void setWrappedService(
		DialogMessageLocalService dialogMessageLocalService) {
		_dialogMessageLocalService = dialogMessageLocalService;
	}

	private DialogMessageLocalService _dialogMessageLocalService;
}