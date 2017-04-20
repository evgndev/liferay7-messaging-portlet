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

import evgn.dev.messaging.exception.NoSuchDialogMessageException;
import evgn.dev.messaging.model.DialogMessage;

/**
 * The persistence interface for the dialog message service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see evgn.dev.messaging.service.persistence.impl.DialogMessagePersistenceImpl
 * @see DialogMessageUtil
 * @generated
 */
@ProviderType
public interface DialogMessagePersistence extends BasePersistence<DialogMessage> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DialogMessageUtil} to access the dialog message persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the dialog messages where dialogId = &#63;.
	*
	* @param dialogId the dialog ID
	* @return the matching dialog messages
	*/
	public java.util.List<DialogMessage> findByDialog(long dialogId);

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
	public java.util.List<DialogMessage> findByDialog(long dialogId, int start,
		int end);

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
	public java.util.List<DialogMessage> findByDialog(long dialogId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<DialogMessage> orderByComparator);

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
	public java.util.List<DialogMessage> findByDialog(long dialogId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<DialogMessage> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first dialog message in the ordered set where dialogId = &#63;.
	*
	* @param dialogId the dialog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dialog message
	* @throws NoSuchDialogMessageException if a matching dialog message could not be found
	*/
	public DialogMessage findByDialog_First(long dialogId,
		com.liferay.portal.kernel.util.OrderByComparator<DialogMessage> orderByComparator)
		throws NoSuchDialogMessageException;

	/**
	* Returns the first dialog message in the ordered set where dialogId = &#63;.
	*
	* @param dialogId the dialog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dialog message, or <code>null</code> if a matching dialog message could not be found
	*/
	public DialogMessage fetchByDialog_First(long dialogId,
		com.liferay.portal.kernel.util.OrderByComparator<DialogMessage> orderByComparator);

	/**
	* Returns the last dialog message in the ordered set where dialogId = &#63;.
	*
	* @param dialogId the dialog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dialog message
	* @throws NoSuchDialogMessageException if a matching dialog message could not be found
	*/
	public DialogMessage findByDialog_Last(long dialogId,
		com.liferay.portal.kernel.util.OrderByComparator<DialogMessage> orderByComparator)
		throws NoSuchDialogMessageException;

	/**
	* Returns the last dialog message in the ordered set where dialogId = &#63;.
	*
	* @param dialogId the dialog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dialog message, or <code>null</code> if a matching dialog message could not be found
	*/
	public DialogMessage fetchByDialog_Last(long dialogId,
		com.liferay.portal.kernel.util.OrderByComparator<DialogMessage> orderByComparator);

	/**
	* Returns the dialog messages before and after the current dialog message in the ordered set where dialogId = &#63;.
	*
	* @param messageId the primary key of the current dialog message
	* @param dialogId the dialog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dialog message
	* @throws NoSuchDialogMessageException if a dialog message with the primary key could not be found
	*/
	public DialogMessage[] findByDialog_PrevAndNext(long messageId,
		long dialogId,
		com.liferay.portal.kernel.util.OrderByComparator<DialogMessage> orderByComparator)
		throws NoSuchDialogMessageException;

	/**
	* Removes all the dialog messages where dialogId = &#63; from the database.
	*
	* @param dialogId the dialog ID
	*/
	public void removeByDialog(long dialogId);

	/**
	* Returns the number of dialog messages where dialogId = &#63;.
	*
	* @param dialogId the dialog ID
	* @return the number of matching dialog messages
	*/
	public int countByDialog(long dialogId);

	/**
	* Caches the dialog message in the entity cache if it is enabled.
	*
	* @param dialogMessage the dialog message
	*/
	public void cacheResult(DialogMessage dialogMessage);

	/**
	* Caches the dialog messages in the entity cache if it is enabled.
	*
	* @param dialogMessages the dialog messages
	*/
	public void cacheResult(java.util.List<DialogMessage> dialogMessages);

	/**
	* Creates a new dialog message with the primary key. Does not add the dialog message to the database.
	*
	* @param messageId the primary key for the new dialog message
	* @return the new dialog message
	*/
	public DialogMessage create(long messageId);

	/**
	* Removes the dialog message with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param messageId the primary key of the dialog message
	* @return the dialog message that was removed
	* @throws NoSuchDialogMessageException if a dialog message with the primary key could not be found
	*/
	public DialogMessage remove(long messageId)
		throws NoSuchDialogMessageException;

	public DialogMessage updateImpl(DialogMessage dialogMessage);

	/**
	* Returns the dialog message with the primary key or throws a {@link NoSuchDialogMessageException} if it could not be found.
	*
	* @param messageId the primary key of the dialog message
	* @return the dialog message
	* @throws NoSuchDialogMessageException if a dialog message with the primary key could not be found
	*/
	public DialogMessage findByPrimaryKey(long messageId)
		throws NoSuchDialogMessageException;

	/**
	* Returns the dialog message with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param messageId the primary key of the dialog message
	* @return the dialog message, or <code>null</code> if a dialog message with the primary key could not be found
	*/
	public DialogMessage fetchByPrimaryKey(long messageId);

	@Override
	public java.util.Map<java.io.Serializable, DialogMessage> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the dialog messages.
	*
	* @return the dialog messages
	*/
	public java.util.List<DialogMessage> findAll();

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
	public java.util.List<DialogMessage> findAll(int start, int end);

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
	public java.util.List<DialogMessage> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DialogMessage> orderByComparator);

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
	public java.util.List<DialogMessage> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DialogMessage> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the dialog messages from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of dialog messages.
	*
	* @return the number of dialog messages
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}