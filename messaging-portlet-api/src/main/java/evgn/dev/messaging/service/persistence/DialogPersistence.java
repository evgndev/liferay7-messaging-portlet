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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import evgn.dev.messaging.exception.NoSuchDialogException;
import evgn.dev.messaging.model.Dialog;

/**
 * The persistence interface for the dialog service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see evgn.dev.messaging.service.persistence.impl.DialogPersistenceImpl
 * @see DialogUtil
 * @generated
 */
@ProviderType
public interface DialogPersistence extends BasePersistence<Dialog> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DialogUtil} to access the dialog persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the dialog in the entity cache if it is enabled.
	*
	* @param dialog the dialog
	*/
	public void cacheResult(Dialog dialog);

	/**
	* Caches the dialogs in the entity cache if it is enabled.
	*
	* @param dialogs the dialogs
	*/
	public void cacheResult(java.util.List<Dialog> dialogs);

	/**
	* Creates a new dialog with the primary key. Does not add the dialog to the database.
	*
	* @param dialogId the primary key for the new dialog
	* @return the new dialog
	*/
	public Dialog create(long dialogId);

	/**
	* Removes the dialog with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dialogId the primary key of the dialog
	* @return the dialog that was removed
	* @throws NoSuchDialogException if a dialog with the primary key could not be found
	*/
	public Dialog remove(long dialogId) throws NoSuchDialogException;

	public Dialog updateImpl(Dialog dialog);

	/**
	* Returns the dialog with the primary key or throws a {@link NoSuchDialogException} if it could not be found.
	*
	* @param dialogId the primary key of the dialog
	* @return the dialog
	* @throws NoSuchDialogException if a dialog with the primary key could not be found
	*/
	public Dialog findByPrimaryKey(long dialogId) throws NoSuchDialogException;

	/**
	* Returns the dialog with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param dialogId the primary key of the dialog
	* @return the dialog, or <code>null</code> if a dialog with the primary key could not be found
	*/
	public Dialog fetchByPrimaryKey(long dialogId);

	@Override
	public java.util.Map<java.io.Serializable, Dialog> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the dialogs.
	*
	* @return the dialogs
	*/
	public java.util.List<Dialog> findAll();

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
	public java.util.List<Dialog> findAll(int start, int end);

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
	public java.util.List<Dialog> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Dialog> orderByComparator);

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
	public java.util.List<Dialog> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Dialog> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the dialogs from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of dialogs.
	*
	* @return the number of dialogs
	*/
	public int countAll();
}