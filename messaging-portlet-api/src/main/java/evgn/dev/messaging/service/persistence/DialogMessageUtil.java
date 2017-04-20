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

package evgn.dev.messaging.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import evgn.dev.messaging.model.DialogMessage;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the dialog message service. This utility wraps {@link evgn.dev.messaging.service.persistence.impl.DialogMessagePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DialogMessagePersistence
 * @see evgn.dev.messaging.service.persistence.impl.DialogMessagePersistenceImpl
 * @generated
 */
@ProviderType
public class DialogMessageUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(DialogMessage dialogMessage) {
		getPersistence().clearCache(dialogMessage);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DialogMessage> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DialogMessage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DialogMessage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DialogMessage> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DialogMessage update(DialogMessage dialogMessage) {
		return getPersistence().update(dialogMessage);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DialogMessage update(DialogMessage dialogMessage,
		ServiceContext serviceContext) {
		return getPersistence().update(dialogMessage, serviceContext);
	}

	/**
	* Returns all the dialog messages where dialogId = &#63;.
	*
	* @param dialogId the dialog ID
	* @return the matching dialog messages
	*/
	public static List<DialogMessage> findByDialog(long dialogId) {
		return getPersistence().findByDialog(dialogId);
	}

	/**
	* Returns a range of all the dialog messages where dialogId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DialogMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dialogId the dialog ID
	* @param start the lower bound of the range of dialog messages
	* @param end the upper bound of the range of dialog messages (not inclusive)
	* @return the range of matching dialog messages
	*/
	public static List<DialogMessage> findByDialog(long dialogId, int start,
		int end) {
		return getPersistence().findByDialog(dialogId, start, end);
	}

	/**
	* Returns an ordered range of all the dialog messages where dialogId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DialogMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dialogId the dialog ID
	* @param start the lower bound of the range of dialog messages
	* @param end the upper bound of the range of dialog messages (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dialog messages
	*/
	public static List<DialogMessage> findByDialog(long dialogId, int start,
		int end, OrderByComparator<DialogMessage> orderByComparator) {
		return getPersistence()
				   .findByDialog(dialogId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the dialog messages where dialogId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DialogMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dialogId the dialog ID
	* @param start the lower bound of the range of dialog messages
	* @param end the upper bound of the range of dialog messages (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching dialog messages
	*/
	public static List<DialogMessage> findByDialog(long dialogId, int start,
		int end, OrderByComparator<DialogMessage> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByDialog(dialogId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first dialog message in the ordered set where dialogId = &#63;.
	*
	* @param dialogId the dialog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dialog message
	* @throws NoSuchDialogMessageException if a matching dialog message could not be found
	*/
	public static DialogMessage findByDialog_First(long dialogId,
		OrderByComparator<DialogMessage> orderByComparator)
		throws evgn.dev.messaging.exception.NoSuchDialogMessageException {
		return getPersistence().findByDialog_First(dialogId, orderByComparator);
	}

	/**
	* Returns the first dialog message in the ordered set where dialogId = &#63;.
	*
	* @param dialogId the dialog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dialog message, or <code>null</code> if a matching dialog message could not be found
	*/
	public static DialogMessage fetchByDialog_First(long dialogId,
		OrderByComparator<DialogMessage> orderByComparator) {
		return getPersistence().fetchByDialog_First(dialogId, orderByComparator);
	}

	/**
	* Returns the last dialog message in the ordered set where dialogId = &#63;.
	*
	* @param dialogId the dialog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dialog message
	* @throws NoSuchDialogMessageException if a matching dialog message could not be found
	*/
	public static DialogMessage findByDialog_Last(long dialogId,
		OrderByComparator<DialogMessage> orderByComparator)
		throws evgn.dev.messaging.exception.NoSuchDialogMessageException {
		return getPersistence().findByDialog_Last(dialogId, orderByComparator);
	}

	/**
	* Returns the last dialog message in the ordered set where dialogId = &#63;.
	*
	* @param dialogId the dialog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dialog message, or <code>null</code> if a matching dialog message could not be found
	*/
	public static DialogMessage fetchByDialog_Last(long dialogId,
		OrderByComparator<DialogMessage> orderByComparator) {
		return getPersistence().fetchByDialog_Last(dialogId, orderByComparator);
	}

	/**
	* Returns the dialog messages before and after the current dialog message in the ordered set where dialogId = &#63;.
	*
	* @param messageId the primary key of the current dialog message
	* @param dialogId the dialog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dialog message
	* @throws NoSuchDialogMessageException if a dialog message with the primary key could not be found
	*/
	public static DialogMessage[] findByDialog_PrevAndNext(long messageId,
		long dialogId, OrderByComparator<DialogMessage> orderByComparator)
		throws evgn.dev.messaging.exception.NoSuchDialogMessageException {
		return getPersistence()
				   .findByDialog_PrevAndNext(messageId, dialogId,
			orderByComparator);
	}

	/**
	* Removes all the dialog messages where dialogId = &#63; from the database.
	*
	* @param dialogId the dialog ID
	*/
	public static void removeByDialog(long dialogId) {
		getPersistence().removeByDialog(dialogId);
	}

	/**
	* Returns the number of dialog messages where dialogId = &#63;.
	*
	* @param dialogId the dialog ID
	* @return the number of matching dialog messages
	*/
	public static int countByDialog(long dialogId) {
		return getPersistence().countByDialog(dialogId);
	}

	/**
	* Caches the dialog message in the entity cache if it is enabled.
	*
	* @param dialogMessage the dialog message
	*/
	public static void cacheResult(DialogMessage dialogMessage) {
		getPersistence().cacheResult(dialogMessage);
	}

	/**
	* Caches the dialog messages in the entity cache if it is enabled.
	*
	* @param dialogMessages the dialog messages
	*/
	public static void cacheResult(List<DialogMessage> dialogMessages) {
		getPersistence().cacheResult(dialogMessages);
	}

	/**
	* Creates a new dialog message with the primary key. Does not add the dialog message to the database.
	*
	* @param messageId the primary key for the new dialog message
	* @return the new dialog message
	*/
	public static DialogMessage create(long messageId) {
		return getPersistence().create(messageId);
	}

	/**
	* Removes the dialog message with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param messageId the primary key of the dialog message
	* @return the dialog message that was removed
	* @throws NoSuchDialogMessageException if a dialog message with the primary key could not be found
	*/
	public static DialogMessage remove(long messageId)
		throws evgn.dev.messaging.exception.NoSuchDialogMessageException {
		return getPersistence().remove(messageId);
	}

	public static DialogMessage updateImpl(DialogMessage dialogMessage) {
		return getPersistence().updateImpl(dialogMessage);
	}

	/**
	* Returns the dialog message with the primary key or throws a {@link NoSuchDialogMessageException} if it could not be found.
	*
	* @param messageId the primary key of the dialog message
	* @return the dialog message
	* @throws NoSuchDialogMessageException if a dialog message with the primary key could not be found
	*/
	public static DialogMessage findByPrimaryKey(long messageId)
		throws evgn.dev.messaging.exception.NoSuchDialogMessageException {
		return getPersistence().findByPrimaryKey(messageId);
	}

	/**
	* Returns the dialog message with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param messageId the primary key of the dialog message
	* @return the dialog message, or <code>null</code> if a dialog message with the primary key could not be found
	*/
	public static DialogMessage fetchByPrimaryKey(long messageId) {
		return getPersistence().fetchByPrimaryKey(messageId);
	}

	public static java.util.Map<java.io.Serializable, DialogMessage> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the dialog messages.
	*
	* @return the dialog messages
	*/
	public static List<DialogMessage> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the dialog messages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DialogMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dialog messages
	* @param end the upper bound of the range of dialog messages (not inclusive)
	* @return the range of dialog messages
	*/
	public static List<DialogMessage> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the dialog messages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DialogMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dialog messages
	* @param end the upper bound of the range of dialog messages (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of dialog messages
	*/
	public static List<DialogMessage> findAll(int start, int end,
		OrderByComparator<DialogMessage> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the dialog messages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DialogMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dialog messages
	* @param end the upper bound of the range of dialog messages (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of dialog messages
	*/
	public static List<DialogMessage> findAll(int start, int end,
		OrderByComparator<DialogMessage> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the dialog messages from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of dialog messages.
	*
	* @return the number of dialog messages
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static DialogMessagePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<DialogMessagePersistence, DialogMessagePersistence> _serviceTracker =
		ServiceTrackerFactory.open(DialogMessagePersistence.class);
}