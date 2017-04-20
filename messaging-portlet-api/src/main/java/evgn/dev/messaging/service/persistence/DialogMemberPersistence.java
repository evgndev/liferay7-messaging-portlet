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

import evgn.dev.messaging.exception.NoSuchDialogMemberException;
import evgn.dev.messaging.model.DialogMember;

/**
 * The persistence interface for the dialog member service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see evgn.dev.messaging.service.persistence.impl.DialogMemberPersistenceImpl
 * @see DialogMemberUtil
 * @generated
 */
@ProviderType
public interface DialogMemberPersistence extends BasePersistence<DialogMember> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DialogMemberUtil} to access the dialog member persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the dialog members where dialogId = &#63;.
	*
	* @param dialogId the dialog ID
	* @return the matching dialog members
	*/
	public java.util.List<DialogMember> findByDialog(long dialogId);

	/**
	* Returns a range of all the dialog members where dialogId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DialogMemberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dialogId the dialog ID
	* @param start the lower bound of the range of dialog members
	* @param end the upper bound of the range of dialog members (not inclusive)
	* @return the range of matching dialog members
	*/
	public java.util.List<DialogMember> findByDialog(long dialogId, int start,
		int end);

	/**
	* Returns an ordered range of all the dialog members where dialogId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DialogMemberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dialogId the dialog ID
	* @param start the lower bound of the range of dialog members
	* @param end the upper bound of the range of dialog members (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dialog members
	*/
	public java.util.List<DialogMember> findByDialog(long dialogId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<DialogMember> orderByComparator);

	/**
	* Returns an ordered range of all the dialog members where dialogId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DialogMemberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dialogId the dialog ID
	* @param start the lower bound of the range of dialog members
	* @param end the upper bound of the range of dialog members (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching dialog members
	*/
	public java.util.List<DialogMember> findByDialog(long dialogId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<DialogMember> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first dialog member in the ordered set where dialogId = &#63;.
	*
	* @param dialogId the dialog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dialog member
	* @throws NoSuchDialogMemberException if a matching dialog member could not be found
	*/
	public DialogMember findByDialog_First(long dialogId,
		com.liferay.portal.kernel.util.OrderByComparator<DialogMember> orderByComparator)
		throws NoSuchDialogMemberException;

	/**
	* Returns the first dialog member in the ordered set where dialogId = &#63;.
	*
	* @param dialogId the dialog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dialog member, or <code>null</code> if a matching dialog member could not be found
	*/
	public DialogMember fetchByDialog_First(long dialogId,
		com.liferay.portal.kernel.util.OrderByComparator<DialogMember> orderByComparator);

	/**
	* Returns the last dialog member in the ordered set where dialogId = &#63;.
	*
	* @param dialogId the dialog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dialog member
	* @throws NoSuchDialogMemberException if a matching dialog member could not be found
	*/
	public DialogMember findByDialog_Last(long dialogId,
		com.liferay.portal.kernel.util.OrderByComparator<DialogMember> orderByComparator)
		throws NoSuchDialogMemberException;

	/**
	* Returns the last dialog member in the ordered set where dialogId = &#63;.
	*
	* @param dialogId the dialog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dialog member, or <code>null</code> if a matching dialog member could not be found
	*/
	public DialogMember fetchByDialog_Last(long dialogId,
		com.liferay.portal.kernel.util.OrderByComparator<DialogMember> orderByComparator);

	/**
	* Returns the dialog members before and after the current dialog member in the ordered set where dialogId = &#63;.
	*
	* @param dialogMemberId the primary key of the current dialog member
	* @param dialogId the dialog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dialog member
	* @throws NoSuchDialogMemberException if a dialog member with the primary key could not be found
	*/
	public DialogMember[] findByDialog_PrevAndNext(long dialogMemberId,
		long dialogId,
		com.liferay.portal.kernel.util.OrderByComparator<DialogMember> orderByComparator)
		throws NoSuchDialogMemberException;

	/**
	* Removes all the dialog members where dialogId = &#63; from the database.
	*
	* @param dialogId the dialog ID
	*/
	public void removeByDialog(long dialogId);

	/**
	* Returns the number of dialog members where dialogId = &#63;.
	*
	* @param dialogId the dialog ID
	* @return the number of matching dialog members
	*/
	public int countByDialog(long dialogId);

	/**
	* Returns all the dialog members where memberId = &#63; and memberType = &#63;.
	*
	* @param memberId the member ID
	* @param memberType the member type
	* @return the matching dialog members
	*/
	public java.util.List<DialogMember> findByMember(long memberId,
		java.lang.String memberType);

	/**
	* Returns a range of all the dialog members where memberId = &#63; and memberType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DialogMemberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param memberId the member ID
	* @param memberType the member type
	* @param start the lower bound of the range of dialog members
	* @param end the upper bound of the range of dialog members (not inclusive)
	* @return the range of matching dialog members
	*/
	public java.util.List<DialogMember> findByMember(long memberId,
		java.lang.String memberType, int start, int end);

	/**
	* Returns an ordered range of all the dialog members where memberId = &#63; and memberType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DialogMemberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param memberId the member ID
	* @param memberType the member type
	* @param start the lower bound of the range of dialog members
	* @param end the upper bound of the range of dialog members (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dialog members
	*/
	public java.util.List<DialogMember> findByMember(long memberId,
		java.lang.String memberType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DialogMember> orderByComparator);

	/**
	* Returns an ordered range of all the dialog members where memberId = &#63; and memberType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DialogMemberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param memberId the member ID
	* @param memberType the member type
	* @param start the lower bound of the range of dialog members
	* @param end the upper bound of the range of dialog members (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching dialog members
	*/
	public java.util.List<DialogMember> findByMember(long memberId,
		java.lang.String memberType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DialogMember> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first dialog member in the ordered set where memberId = &#63; and memberType = &#63;.
	*
	* @param memberId the member ID
	* @param memberType the member type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dialog member
	* @throws NoSuchDialogMemberException if a matching dialog member could not be found
	*/
	public DialogMember findByMember_First(long memberId,
		java.lang.String memberType,
		com.liferay.portal.kernel.util.OrderByComparator<DialogMember> orderByComparator)
		throws NoSuchDialogMemberException;

	/**
	* Returns the first dialog member in the ordered set where memberId = &#63; and memberType = &#63;.
	*
	* @param memberId the member ID
	* @param memberType the member type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dialog member, or <code>null</code> if a matching dialog member could not be found
	*/
	public DialogMember fetchByMember_First(long memberId,
		java.lang.String memberType,
		com.liferay.portal.kernel.util.OrderByComparator<DialogMember> orderByComparator);

	/**
	* Returns the last dialog member in the ordered set where memberId = &#63; and memberType = &#63;.
	*
	* @param memberId the member ID
	* @param memberType the member type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dialog member
	* @throws NoSuchDialogMemberException if a matching dialog member could not be found
	*/
	public DialogMember findByMember_Last(long memberId,
		java.lang.String memberType,
		com.liferay.portal.kernel.util.OrderByComparator<DialogMember> orderByComparator)
		throws NoSuchDialogMemberException;

	/**
	* Returns the last dialog member in the ordered set where memberId = &#63; and memberType = &#63;.
	*
	* @param memberId the member ID
	* @param memberType the member type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dialog member, or <code>null</code> if a matching dialog member could not be found
	*/
	public DialogMember fetchByMember_Last(long memberId,
		java.lang.String memberType,
		com.liferay.portal.kernel.util.OrderByComparator<DialogMember> orderByComparator);

	/**
	* Returns the dialog members before and after the current dialog member in the ordered set where memberId = &#63; and memberType = &#63;.
	*
	* @param dialogMemberId the primary key of the current dialog member
	* @param memberId the member ID
	* @param memberType the member type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dialog member
	* @throws NoSuchDialogMemberException if a dialog member with the primary key could not be found
	*/
	public DialogMember[] findByMember_PrevAndNext(long dialogMemberId,
		long memberId, java.lang.String memberType,
		com.liferay.portal.kernel.util.OrderByComparator<DialogMember> orderByComparator)
		throws NoSuchDialogMemberException;

	/**
	* Removes all the dialog members where memberId = &#63; and memberType = &#63; from the database.
	*
	* @param memberId the member ID
	* @param memberType the member type
	*/
	public void removeByMember(long memberId, java.lang.String memberType);

	/**
	* Returns the number of dialog members where memberId = &#63; and memberType = &#63;.
	*
	* @param memberId the member ID
	* @param memberType the member type
	* @return the number of matching dialog members
	*/
	public int countByMember(long memberId, java.lang.String memberType);

	/**
	* Returns the dialog member where dialogId = &#63; and memberId = &#63; and memberType = &#63; or throws a {@link NoSuchDialogMemberException} if it could not be found.
	*
	* @param dialogId the dialog ID
	* @param memberId the member ID
	* @param memberType the member type
	* @return the matching dialog member
	* @throws NoSuchDialogMemberException if a matching dialog member could not be found
	*/
	public DialogMember findByDialogAndMember(long dialogId, long memberId,
		java.lang.String memberType) throws NoSuchDialogMemberException;

	/**
	* Returns the dialog member where dialogId = &#63; and memberId = &#63; and memberType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param dialogId the dialog ID
	* @param memberId the member ID
	* @param memberType the member type
	* @return the matching dialog member, or <code>null</code> if a matching dialog member could not be found
	*/
	public DialogMember fetchByDialogAndMember(long dialogId, long memberId,
		java.lang.String memberType);

	/**
	* Returns the dialog member where dialogId = &#63; and memberId = &#63; and memberType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param dialogId the dialog ID
	* @param memberId the member ID
	* @param memberType the member type
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching dialog member, or <code>null</code> if a matching dialog member could not be found
	*/
	public DialogMember fetchByDialogAndMember(long dialogId, long memberId,
		java.lang.String memberType, boolean retrieveFromCache);

	/**
	* Removes the dialog member where dialogId = &#63; and memberId = &#63; and memberType = &#63; from the database.
	*
	* @param dialogId the dialog ID
	* @param memberId the member ID
	* @param memberType the member type
	* @return the dialog member that was removed
	*/
	public DialogMember removeByDialogAndMember(long dialogId, long memberId,
		java.lang.String memberType) throws NoSuchDialogMemberException;

	/**
	* Returns the number of dialog members where dialogId = &#63; and memberId = &#63; and memberType = &#63;.
	*
	* @param dialogId the dialog ID
	* @param memberId the member ID
	* @param memberType the member type
	* @return the number of matching dialog members
	*/
	public int countByDialogAndMember(long dialogId, long memberId,
		java.lang.String memberType);

	/**
	* Caches the dialog member in the entity cache if it is enabled.
	*
	* @param dialogMember the dialog member
	*/
	public void cacheResult(DialogMember dialogMember);

	/**
	* Caches the dialog members in the entity cache if it is enabled.
	*
	* @param dialogMembers the dialog members
	*/
	public void cacheResult(java.util.List<DialogMember> dialogMembers);

	/**
	* Creates a new dialog member with the primary key. Does not add the dialog member to the database.
	*
	* @param dialogMemberId the primary key for the new dialog member
	* @return the new dialog member
	*/
	public DialogMember create(long dialogMemberId);

	/**
	* Removes the dialog member with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dialogMemberId the primary key of the dialog member
	* @return the dialog member that was removed
	* @throws NoSuchDialogMemberException if a dialog member with the primary key could not be found
	*/
	public DialogMember remove(long dialogMemberId)
		throws NoSuchDialogMemberException;

	public DialogMember updateImpl(DialogMember dialogMember);

	/**
	* Returns the dialog member with the primary key or throws a {@link NoSuchDialogMemberException} if it could not be found.
	*
	* @param dialogMemberId the primary key of the dialog member
	* @return the dialog member
	* @throws NoSuchDialogMemberException if a dialog member with the primary key could not be found
	*/
	public DialogMember findByPrimaryKey(long dialogMemberId)
		throws NoSuchDialogMemberException;

	/**
	* Returns the dialog member with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param dialogMemberId the primary key of the dialog member
	* @return the dialog member, or <code>null</code> if a dialog member with the primary key could not be found
	*/
	public DialogMember fetchByPrimaryKey(long dialogMemberId);

	@Override
	public java.util.Map<java.io.Serializable, DialogMember> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the dialog members.
	*
	* @return the dialog members
	*/
	public java.util.List<DialogMember> findAll();

	/**
	* Returns a range of all the dialog members.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DialogMemberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dialog members
	* @param end the upper bound of the range of dialog members (not inclusive)
	* @return the range of dialog members
	*/
	public java.util.List<DialogMember> findAll(int start, int end);

	/**
	* Returns an ordered range of all the dialog members.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DialogMemberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dialog members
	* @param end the upper bound of the range of dialog members (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of dialog members
	*/
	public java.util.List<DialogMember> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DialogMember> orderByComparator);

	/**
	* Returns an ordered range of all the dialog members.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DialogMemberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dialog members
	* @param end the upper bound of the range of dialog members (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of dialog members
	*/
	public java.util.List<DialogMember> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DialogMember> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the dialog members from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of dialog members.
	*
	* @return the number of dialog members
	*/
	public int countAll();
}