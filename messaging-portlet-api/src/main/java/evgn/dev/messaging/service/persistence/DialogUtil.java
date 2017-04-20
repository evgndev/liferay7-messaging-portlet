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

import evgn.dev.messaging.model.Dialog;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the dialog service. This utility wraps {@link evgn.dev.messaging.service.persistence.impl.DialogPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DialogPersistence
 * @see evgn.dev.messaging.service.persistence.impl.DialogPersistenceImpl
 * @generated
 */
@ProviderType
public class DialogUtil {
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
	public static void clearCache(Dialog dialog) {
		getPersistence().clearCache(dialog);
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
	public static List<Dialog> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Dialog> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Dialog> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator<Dialog> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Dialog update(Dialog dialog) {
		return getPersistence().update(dialog);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Dialog update(Dialog dialog, ServiceContext serviceContext) {
		return getPersistence().update(dialog, serviceContext);
	}

	/**
	* Caches the dialog in the entity cache if it is enabled.
	*
	* @param dialog the dialog
	*/
	public static void cacheResult(Dialog dialog) {
		getPersistence().cacheResult(dialog);
	}

	/**
	* Caches the dialogs in the entity cache if it is enabled.
	*
	* @param dialogs the dialogs
	*/
	public static void cacheResult(List<Dialog> dialogs) {
		getPersistence().cacheResult(dialogs);
	}

	/**
	* Creates a new dialog with the primary key. Does not add the dialog to the database.
	*
	* @param dialogId the primary key for the new dialog
	* @return the new dialog
	*/
	public static Dialog create(long dialogId) {
		return getPersistence().create(dialogId);
	}

	/**
	* Removes the dialog with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dialogId the primary key of the dialog
	* @return the dialog that was removed
	* @throws NoSuchDialogException if a dialog with the primary key could not be found
	*/
	public static Dialog remove(long dialogId)
		throws evgn.dev.messaging.exception.NoSuchDialogException {
		return getPersistence().remove(dialogId);
	}

	public static Dialog updateImpl(Dialog dialog) {
		return getPersistence().updateImpl(dialog);
	}

	/**
	* Returns the dialog with the primary key or throws a {@link NoSuchDialogException} if it could not be found.
	*
	* @param dialogId the primary key of the dialog
	* @return the dialog
	* @throws NoSuchDialogException if a dialog with the primary key could not be found
	*/
	public static Dialog findByPrimaryKey(long dialogId)
		throws evgn.dev.messaging.exception.NoSuchDialogException {
		return getPersistence().findByPrimaryKey(dialogId);
	}

	/**
	* Returns the dialog with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param dialogId the primary key of the dialog
	* @return the dialog, or <code>null</code> if a dialog with the primary key could not be found
	*/
	public static Dialog fetchByPrimaryKey(long dialogId) {
		return getPersistence().fetchByPrimaryKey(dialogId);
	}

	public static java.util.Map<java.io.Serializable, Dialog> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the dialogs.
	*
	* @return the dialogs
	*/
	public static List<Dialog> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the dialogs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DialogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dialogs
	* @param end the upper bound of the range of dialogs (not inclusive)
	* @return the range of dialogs
	*/
	public static List<Dialog> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the dialogs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DialogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dialogs
	* @param end the upper bound of the range of dialogs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of dialogs
	*/
	public static List<Dialog> findAll(int start, int end,
		OrderByComparator<Dialog> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the dialogs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DialogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dialogs
	* @param end the upper bound of the range of dialogs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of dialogs
	*/
	public static List<Dialog> findAll(int start, int end,
		OrderByComparator<Dialog> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the dialogs from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of dialogs.
	*
	* @return the number of dialogs
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DialogPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<DialogPersistence, DialogPersistence> _serviceTracker =
		ServiceTrackerFactory.open(DialogPersistence.class);
}