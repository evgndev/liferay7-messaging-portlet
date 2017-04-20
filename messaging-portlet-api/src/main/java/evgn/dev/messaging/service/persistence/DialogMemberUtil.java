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

import evgn.dev.messaging.model.DialogMember;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the dialog member service. This utility wraps {@link evgn.dev.messaging.service.persistence.impl.DialogMemberPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DialogMemberPersistence
 * @see evgn.dev.messaging.service.persistence.impl.DialogMemberPersistenceImpl
 * @generated
 */
@ProviderType
public class DialogMemberUtil {
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
	public static void clearCache(DialogMember dialogMember) {
		getPersistence().clearCache(dialogMember);
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
	public static List<DialogMember> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DialogMember> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DialogMember> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DialogMember> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DialogMember update(DialogMember dialogMember) {
		return getPersistence().update(dialogMember);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DialogMember update(DialogMember dialogMember,
		ServiceContext serviceContext) {
		return getPersistence().update(dialogMember, serviceContext);
	}

	/**
	* Returns all the dialog members where dialogId = &#63;.
	*
	* @param dialogId the dialog ID
	* @return the matching dialog members
	*/
	public static List<DialogMember> findByDialog(long dialogId) {
		return getPersistence().findByDialog(dialogId);
	}

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
	public static List<DialogMember> findByDialog(long dialogId, int start,
		int end) {
		return getPersistence().findByDialog(dialogId, start, end);
	}

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
	public static List<DialogMember> findByDialog(long dialogId, int start,
		int end, OrderByComparator<DialogMember> orderByComparator) {
		return getPersistence()
				   .findByDialog(dialogId, start, end, orderByComparator);
	}

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
	public static List<DialogMember> findByDialog(long dialogId, int start,
		int end, OrderByComparator<DialogMember> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByDialog(dialogId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first dialog member in the ordered set where dialogId = &#63;.
	*
	* @param dialogId the dialog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dialog member
	* @throws NoSuchDialogMemberException if a matching dialog member could not be found
	*/
	public static DialogMember findByDialog_First(long dialogId,
		OrderByComparator<DialogMember> orderByComparator)
		throws evgn.dev.messaging.exception.NoSuchDialogMemberException {
		return getPersistence().findByDialog_First(dialogId, orderByComparator);
	}

	/**
	* Returns the first dialog member in the ordered set where dialogId = &#63;.
	*
	* @param dialogId the dialog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dialog member, or <code>null</code> if a matching dialog member could not be found
	*/
	public static DialogMember fetchByDialog_First(long dialogId,
		OrderByComparator<DialogMember> orderByComparator) {
		return getPersistence().fetchByDialog_First(dialogId, orderByComparator);
	}

	/**
	* Returns the last dialog member in the ordered set where dialogId = &#63;.
	*
	* @param dialogId the dialog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dialog member
	* @throws NoSuchDialogMemberException if a matching dialog member could not be found
	*/
	public static DialogMember findByDialog_Last(long dialogId,
		OrderByComparator<DialogMember> orderByComparator)
		throws evgn.dev.messaging.exception.NoSuchDialogMemberException {
		return getPersistence().findByDialog_Last(dialogId, orderByComparator);
	}

	/**
	* Returns the last dialog member in the ordered set where dialogId = &#63;.
	*
	* @param dialogId the dialog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dialog member, or <code>null</code> if a matching dialog member could not be found
	*/
	public static DialogMember fetchByDialog_Last(long dialogId,
		OrderByComparator<DialogMember> orderByComparator) {
		return getPersistence().fetchByDialog_Last(dialogId, orderByComparator);
	}

	/**
	* Returns the dialog members before and after the current dialog member in the ordered set where dialogId = &#63;.
	*
	* @param dialogMemberId the primary key of the current dialog member
	* @param dialogId the dialog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dialog member
	* @throws NoSuchDialogMemberException if a dialog member with the primary key could not be found
	*/
	public static DialogMember[] findByDialog_PrevAndNext(long dialogMemberId,
		long dialogId, OrderByComparator<DialogMember> orderByComparator)
		throws evgn.dev.messaging.exception.NoSuchDialogMemberException {
		return getPersistence()
				   .findByDialog_PrevAndNext(dialogMemberId, dialogId,
			orderByComparator);
	}

	/**
	* Removes all the dialog members where dialogId = &#63; from the database.
	*
	* @param dialogId the dialog ID
	*/
	public static void removeByDialog(long dialogId) {
		getPersistence().removeByDialog(dialogId);
	}

	/**
	* Returns the number of dialog members where dialogId = &#63;.
	*
	* @param dialogId the dialog ID
	* @return the number of matching dialog members
	*/
	public static int countByDialog(long dialogId) {
		return getPersistence().countByDialog(dialogId);
	}

	/**
	* Returns all the dialog members where memberId = &#63; and memberType = &#63;.
	*
	* @param memberId the member ID
	* @param memberType the member type
	* @return the matching dialog members
	*/
	public static List<DialogMember> findByMember(long memberId,
		java.lang.String memberType) {
		return getPersistence().findByMember(memberId, memberType);
	}

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
	public static List<DialogMember> findByMember(long memberId,
		java.lang.String memberType, int start, int end) {
		return getPersistence().findByMember(memberId, memberType, start, end);
	}

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
	public static List<DialogMember> findByMember(long memberId,
		java.lang.String memberType, int start, int end,
		OrderByComparator<DialogMember> orderByComparator) {
		return getPersistence()
				   .findByMember(memberId, memberType, start, end,
			orderByComparator);
	}

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
	public static List<DialogMember> findByMember(long memberId,
		java.lang.String memberType, int start, int end,
		OrderByComparator<DialogMember> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByMember(memberId, memberType, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first dialog member in the ordered set where memberId = &#63; and memberType = &#63;.
	*
	* @param memberId the member ID
	* @param memberType the member type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dialog member
	* @throws NoSuchDialogMemberException if a matching dialog member could not be found
	*/
	public static DialogMember findByMember_First(long memberId,
		java.lang.String memberType,
		OrderByComparator<DialogMember> orderByComparator)
		throws evgn.dev.messaging.exception.NoSuchDialogMemberException {
		return getPersistence()
				   .findByMember_First(memberId, memberType, orderByComparator);
	}

	/**
	* Returns the first dialog member in the ordered set where memberId = &#63; and memberType = &#63;.
	*
	* @param memberId the member ID
	* @param memberType the member type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dialog member, or <code>null</code> if a matching dialog member could not be found
	*/
	public static DialogMember fetchByMember_First(long memberId,
		java.lang.String memberType,
		OrderByComparator<DialogMember> orderByComparator) {
		return getPersistence()
				   .fetchByMember_First(memberId, memberType, orderByComparator);
	}

	/**
	* Returns the last dialog member in the ordered set where memberId = &#63; and memberType = &#63;.
	*
	* @param memberId the member ID
	* @param memberType the member type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dialog member
	* @throws NoSuchDialogMemberException if a matching dialog member could not be found
	*/
	public static DialogMember findByMember_Last(long memberId,
		java.lang.String memberType,
		OrderByComparator<DialogMember> orderByComparator)
		throws evgn.dev.messaging.exception.NoSuchDialogMemberException {
		return getPersistence()
				   .findByMember_Last(memberId, memberType, orderByComparator);
	}

	/**
	* Returns the last dialog member in the ordered set where memberId = &#63; and memberType = &#63;.
	*
	* @param memberId the member ID
	* @param memberType the member type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dialog member, or <code>null</code> if a matching dialog member could not be found
	*/
	public static DialogMember fetchByMember_Last(long memberId,
		java.lang.String memberType,
		OrderByComparator<DialogMember> orderByComparator) {
		return getPersistence()
				   .fetchByMember_Last(memberId, memberType, orderByComparator);
	}

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
	public static DialogMember[] findByMember_PrevAndNext(long dialogMemberId,
		long memberId, java.lang.String memberType,
		OrderByComparator<DialogMember> orderByComparator)
		throws evgn.dev.messaging.exception.NoSuchDialogMemberException {
		return getPersistence()
				   .findByMember_PrevAndNext(dialogMemberId, memberId,
			memberType, orderByComparator);
	}

	/**
	* Removes all the dialog members where memberId = &#63; and memberType = &#63; from the database.
	*
	* @param memberId the member ID
	* @param memberType the member type
	*/
	public static void removeByMember(long memberId, java.lang.String memberType) {
		getPersistence().removeByMember(memberId, memberType);
	}

	/**
	* Returns the number of dialog members where memberId = &#63; and memberType = &#63;.
	*
	* @param memberId the member ID
	* @param memberType the member type
	* @return the number of matching dialog members
	*/
	public static int countByMember(long memberId, java.lang.String memberType) {
		return getPersistence().countByMember(memberId, memberType);
	}

	/**
	* Returns the dialog member where dialogId = &#63; and memberId = &#63; and memberType = &#63; or throws a {@link NoSuchDialogMemberException} if it could not be found.
	*
	* @param dialogId the dialog ID
	* @param memberId the member ID
	* @param memberType the member type
	* @return the matching dialog member
	* @throws NoSuchDialogMemberException if a matching dialog member could not be found
	*/
	public static DialogMember findByDialogAndMember(long dialogId,
		long memberId, java.lang.String memberType)
		throws evgn.dev.messaging.exception.NoSuchDialogMemberException {
		return getPersistence()
				   .findByDialogAndMember(dialogId, memberId, memberType);
	}

	/**
	* Returns the dialog member where dialogId = &#63; and memberId = &#63; and memberType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param dialogId the dialog ID
	* @param memberId the member ID
	* @param memberType the member type
	* @return the matching dialog member, or <code>null</code> if a matching dialog member could not be found
	*/
	public static DialogMember fetchByDialogAndMember(long dialogId,
		long memberId, java.lang.String memberType) {
		return getPersistence()
				   .fetchByDialogAndMember(dialogId, memberId, memberType);
	}

	/**
	* Returns the dialog member where dialogId = &#63; and memberId = &#63; and memberType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param dialogId the dialog ID
	* @param memberId the member ID
	* @param memberType the member type
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching dialog member, or <code>null</code> if a matching dialog member could not be found
	*/
	public static DialogMember fetchByDialogAndMember(long dialogId,
		long memberId, java.lang.String memberType, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByDialogAndMember(dialogId, memberId, memberType,
			retrieveFromCache);
	}

	/**
	* Removes the dialog member where dialogId = &#63; and memberId = &#63; and memberType = &#63; from the database.
	*
	* @param dialogId the dialog ID
	* @param memberId the member ID
	* @param memberType the member type
	* @return the dialog member that was removed
	*/
	public static DialogMember removeByDialogAndMember(long dialogId,
		long memberId, java.lang.String memberType)
		throws evgn.dev.messaging.exception.NoSuchDialogMemberException {
		return getPersistence()
				   .removeByDialogAndMember(dialogId, memberId, memberType);
	}

	/**
	* Returns the number of dialog members where dialogId = &#63; and memberId = &#63; and memberType = &#63;.
	*
	* @param dialogId the dialog ID
	* @param memberId the member ID
	* @param memberType the member type
	* @return the number of matching dialog members
	*/
	public static int countByDialogAndMember(long dialogId, long memberId,
		java.lang.String memberType) {
		return getPersistence()
				   .countByDialogAndMember(dialogId, memberId, memberType);
	}

	/**
	* Caches the dialog member in the entity cache if it is enabled.
	*
	* @param dialogMember the dialog member
	*/
	public static void cacheResult(DialogMember dialogMember) {
		getPersistence().cacheResult(dialogMember);
	}

	/**
	* Caches the dialog members in the entity cache if it is enabled.
	*
	* @param dialogMembers the dialog members
	*/
	public static void cacheResult(List<DialogMember> dialogMembers) {
		getPersistence().cacheResult(dialogMembers);
	}

	/**
	* Creates a new dialog member with the primary key. Does not add the dialog member to the database.
	*
	* @param dialogMemberId the primary key for the new dialog member
	* @return the new dialog member
	*/
	public static DialogMember create(long dialogMemberId) {
		return getPersistence().create(dialogMemberId);
	}

	/**
	* Removes the dialog member with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dialogMemberId the primary key of the dialog member
	* @return the dialog member that was removed
	* @throws NoSuchDialogMemberException if a dialog member with the primary key could not be found
	*/
	public static DialogMember remove(long dialogMemberId)
		throws evgn.dev.messaging.exception.NoSuchDialogMemberException {
		return getPersistence().remove(dialogMemberId);
	}

	public static DialogMember updateImpl(DialogMember dialogMember) {
		return getPersistence().updateImpl(dialogMember);
	}

	/**
	* Returns the dialog member with the primary key or throws a {@link NoSuchDialogMemberException} if it could not be found.
	*
	* @param dialogMemberId the primary key of the dialog member
	* @return the dialog member
	* @throws NoSuchDialogMemberException if a dialog member with the primary key could not be found
	*/
	public static DialogMember findByPrimaryKey(long dialogMemberId)
		throws evgn.dev.messaging.exception.NoSuchDialogMemberException {
		return getPersistence().findByPrimaryKey(dialogMemberId);
	}

	/**
	* Returns the dialog member with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param dialogMemberId the primary key of the dialog member
	* @return the dialog member, or <code>null</code> if a dialog member with the primary key could not be found
	*/
	public static DialogMember fetchByPrimaryKey(long dialogMemberId) {
		return getPersistence().fetchByPrimaryKey(dialogMemberId);
	}

	public static java.util.Map<java.io.Serializable, DialogMember> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the dialog members.
	*
	* @return the dialog members
	*/
	public static List<DialogMember> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<DialogMember> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<DialogMember> findAll(int start, int end,
		OrderByComparator<DialogMember> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<DialogMember> findAll(int start, int end,
		OrderByComparator<DialogMember> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the dialog members from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of dialog members.
	*
	* @return the number of dialog members
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DialogMemberPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<DialogMemberPersistence, DialogMemberPersistence> _serviceTracker =
		ServiceTrackerFactory.open(DialogMemberPersistence.class);
}