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

package evgn.dev.messaging.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import evgn.dev.messaging.exception.NoSuchDialogMemberException;
import evgn.dev.messaging.model.DialogMember;
import evgn.dev.messaging.model.impl.DialogMemberImpl;
import evgn.dev.messaging.model.impl.DialogMemberModelImpl;
import evgn.dev.messaging.service.persistence.DialogMemberPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the dialog member service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DialogMemberPersistence
 * @see evgn.dev.messaging.service.persistence.DialogMemberUtil
 * @generated
 */
@ProviderType
public class DialogMemberPersistenceImpl extends BasePersistenceImpl<DialogMember>
	implements DialogMemberPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DialogMemberUtil} to access the dialog member persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DialogMemberImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DialogMemberModelImpl.ENTITY_CACHE_ENABLED,
			DialogMemberModelImpl.FINDER_CACHE_ENABLED, DialogMemberImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DialogMemberModelImpl.ENTITY_CACHE_ENABLED,
			DialogMemberModelImpl.FINDER_CACHE_ENABLED, DialogMemberImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DialogMemberModelImpl.ENTITY_CACHE_ENABLED,
			DialogMemberModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DIALOG = new FinderPath(DialogMemberModelImpl.ENTITY_CACHE_ENABLED,
			DialogMemberModelImpl.FINDER_CACHE_ENABLED, DialogMemberImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDialog",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DIALOG =
		new FinderPath(DialogMemberModelImpl.ENTITY_CACHE_ENABLED,
			DialogMemberModelImpl.FINDER_CACHE_ENABLED, DialogMemberImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDialog",
			new String[] { Long.class.getName() },
			DialogMemberModelImpl.DIALOGID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DIALOG = new FinderPath(DialogMemberModelImpl.ENTITY_CACHE_ENABLED,
			DialogMemberModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDialog",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the dialog members where dialogId = &#63;.
	 *
	 * @param dialogId the dialog ID
	 * @return the matching dialog members
	 */
	@Override
	public List<DialogMember> findByDialog(long dialogId) {
		return findByDialog(dialogId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<DialogMember> findByDialog(long dialogId, int start, int end) {
		return findByDialog(dialogId, start, end, null);
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
	@Override
	public List<DialogMember> findByDialog(long dialogId, int start, int end,
		OrderByComparator<DialogMember> orderByComparator) {
		return findByDialog(dialogId, start, end, orderByComparator, true);
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
	@Override
	public List<DialogMember> findByDialog(long dialogId, int start, int end,
		OrderByComparator<DialogMember> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DIALOG;
			finderArgs = new Object[] { dialogId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DIALOG;
			finderArgs = new Object[] { dialogId, start, end, orderByComparator };
		}

		List<DialogMember> list = null;

		if (retrieveFromCache) {
			list = (List<DialogMember>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DialogMember dialogMember : list) {
					if ((dialogId != dialogMember.getDialogId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_DIALOGMEMBER_WHERE);

			query.append(_FINDER_COLUMN_DIALOG_DIALOGID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DialogMemberModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dialogId);

				if (!pagination) {
					list = (List<DialogMember>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DialogMember>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first dialog member in the ordered set where dialogId = &#63;.
	 *
	 * @param dialogId the dialog ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dialog member
	 * @throws NoSuchDialogMemberException if a matching dialog member could not be found
	 */
	@Override
	public DialogMember findByDialog_First(long dialogId,
		OrderByComparator<DialogMember> orderByComparator)
		throws NoSuchDialogMemberException {
		DialogMember dialogMember = fetchByDialog_First(dialogId,
				orderByComparator);

		if (dialogMember != null) {
			return dialogMember;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dialogId=");
		msg.append(dialogId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDialogMemberException(msg.toString());
	}

	/**
	 * Returns the first dialog member in the ordered set where dialogId = &#63;.
	 *
	 * @param dialogId the dialog ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dialog member, or <code>null</code> if a matching dialog member could not be found
	 */
	@Override
	public DialogMember fetchByDialog_First(long dialogId,
		OrderByComparator<DialogMember> orderByComparator) {
		List<DialogMember> list = findByDialog(dialogId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dialog member in the ordered set where dialogId = &#63;.
	 *
	 * @param dialogId the dialog ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dialog member
	 * @throws NoSuchDialogMemberException if a matching dialog member could not be found
	 */
	@Override
	public DialogMember findByDialog_Last(long dialogId,
		OrderByComparator<DialogMember> orderByComparator)
		throws NoSuchDialogMemberException {
		DialogMember dialogMember = fetchByDialog_Last(dialogId,
				orderByComparator);

		if (dialogMember != null) {
			return dialogMember;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dialogId=");
		msg.append(dialogId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDialogMemberException(msg.toString());
	}

	/**
	 * Returns the last dialog member in the ordered set where dialogId = &#63;.
	 *
	 * @param dialogId the dialog ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dialog member, or <code>null</code> if a matching dialog member could not be found
	 */
	@Override
	public DialogMember fetchByDialog_Last(long dialogId,
		OrderByComparator<DialogMember> orderByComparator) {
		int count = countByDialog(dialogId);

		if (count == 0) {
			return null;
		}

		List<DialogMember> list = findByDialog(dialogId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public DialogMember[] findByDialog_PrevAndNext(long dialogMemberId,
		long dialogId, OrderByComparator<DialogMember> orderByComparator)
		throws NoSuchDialogMemberException {
		DialogMember dialogMember = findByPrimaryKey(dialogMemberId);

		Session session = null;

		try {
			session = openSession();

			DialogMember[] array = new DialogMemberImpl[3];

			array[0] = getByDialog_PrevAndNext(session, dialogMember, dialogId,
					orderByComparator, true);

			array[1] = dialogMember;

			array[2] = getByDialog_PrevAndNext(session, dialogMember, dialogId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DialogMember getByDialog_PrevAndNext(Session session,
		DialogMember dialogMember, long dialogId,
		OrderByComparator<DialogMember> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DIALOGMEMBER_WHERE);

		query.append(_FINDER_COLUMN_DIALOG_DIALOGID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(DialogMemberModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(dialogId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dialogMember);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DialogMember> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dialog members where dialogId = &#63; from the database.
	 *
	 * @param dialogId the dialog ID
	 */
	@Override
	public void removeByDialog(long dialogId) {
		for (DialogMember dialogMember : findByDialog(dialogId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(dialogMember);
		}
	}

	/**
	 * Returns the number of dialog members where dialogId = &#63;.
	 *
	 * @param dialogId the dialog ID
	 * @return the number of matching dialog members
	 */
	@Override
	public int countByDialog(long dialogId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DIALOG;

		Object[] finderArgs = new Object[] { dialogId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DIALOGMEMBER_WHERE);

			query.append(_FINDER_COLUMN_DIALOG_DIALOGID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dialogId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_DIALOG_DIALOGID_2 = "dialogMember.dialogId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MEMBER = new FinderPath(DialogMemberModelImpl.ENTITY_CACHE_ENABLED,
			DialogMemberModelImpl.FINDER_CACHE_ENABLED, DialogMemberImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByMember",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBER =
		new FinderPath(DialogMemberModelImpl.ENTITY_CACHE_ENABLED,
			DialogMemberModelImpl.FINDER_CACHE_ENABLED, DialogMemberImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByMember",
			new String[] { Long.class.getName(), String.class.getName() },
			DialogMemberModelImpl.MEMBERID_COLUMN_BITMASK |
			DialogMemberModelImpl.MEMBERTYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MEMBER = new FinderPath(DialogMemberModelImpl.ENTITY_CACHE_ENABLED,
			DialogMemberModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMember",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the dialog members where memberId = &#63; and memberType = &#63;.
	 *
	 * @param memberId the member ID
	 * @param memberType the member type
	 * @return the matching dialog members
	 */
	@Override
	public List<DialogMember> findByMember(long memberId, String memberType) {
		return findByMember(memberId, memberType, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<DialogMember> findByMember(long memberId, String memberType,
		int start, int end) {
		return findByMember(memberId, memberType, start, end, null);
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
	@Override
	public List<DialogMember> findByMember(long memberId, String memberType,
		int start, int end, OrderByComparator<DialogMember> orderByComparator) {
		return findByMember(memberId, memberType, start, end,
			orderByComparator, true);
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
	@Override
	public List<DialogMember> findByMember(long memberId, String memberType,
		int start, int end, OrderByComparator<DialogMember> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBER;
			finderArgs = new Object[] { memberId, memberType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MEMBER;
			finderArgs = new Object[] {
					memberId, memberType,
					
					start, end, orderByComparator
				};
		}

		List<DialogMember> list = null;

		if (retrieveFromCache) {
			list = (List<DialogMember>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DialogMember dialogMember : list) {
					if ((memberId != dialogMember.getMemberId()) ||
							!Objects.equals(memberType,
								dialogMember.getMemberType())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_DIALOGMEMBER_WHERE);

			query.append(_FINDER_COLUMN_MEMBER_MEMBERID_2);

			boolean bindMemberType = false;

			if (memberType == null) {
				query.append(_FINDER_COLUMN_MEMBER_MEMBERTYPE_1);
			}
			else if (memberType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MEMBER_MEMBERTYPE_3);
			}
			else {
				bindMemberType = true;

				query.append(_FINDER_COLUMN_MEMBER_MEMBERTYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DialogMemberModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(memberId);

				if (bindMemberType) {
					qPos.add(memberType);
				}

				if (!pagination) {
					list = (List<DialogMember>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DialogMember>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public DialogMember findByMember_First(long memberId, String memberType,
		OrderByComparator<DialogMember> orderByComparator)
		throws NoSuchDialogMemberException {
		DialogMember dialogMember = fetchByMember_First(memberId, memberType,
				orderByComparator);

		if (dialogMember != null) {
			return dialogMember;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("memberId=");
		msg.append(memberId);

		msg.append(", memberType=");
		msg.append(memberType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDialogMemberException(msg.toString());
	}

	/**
	 * Returns the first dialog member in the ordered set where memberId = &#63; and memberType = &#63;.
	 *
	 * @param memberId the member ID
	 * @param memberType the member type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dialog member, or <code>null</code> if a matching dialog member could not be found
	 */
	@Override
	public DialogMember fetchByMember_First(long memberId, String memberType,
		OrderByComparator<DialogMember> orderByComparator) {
		List<DialogMember> list = findByMember(memberId, memberType, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public DialogMember findByMember_Last(long memberId, String memberType,
		OrderByComparator<DialogMember> orderByComparator)
		throws NoSuchDialogMemberException {
		DialogMember dialogMember = fetchByMember_Last(memberId, memberType,
				orderByComparator);

		if (dialogMember != null) {
			return dialogMember;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("memberId=");
		msg.append(memberId);

		msg.append(", memberType=");
		msg.append(memberType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDialogMemberException(msg.toString());
	}

	/**
	 * Returns the last dialog member in the ordered set where memberId = &#63; and memberType = &#63;.
	 *
	 * @param memberId the member ID
	 * @param memberType the member type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dialog member, or <code>null</code> if a matching dialog member could not be found
	 */
	@Override
	public DialogMember fetchByMember_Last(long memberId, String memberType,
		OrderByComparator<DialogMember> orderByComparator) {
		int count = countByMember(memberId, memberType);

		if (count == 0) {
			return null;
		}

		List<DialogMember> list = findByMember(memberId, memberType, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public DialogMember[] findByMember_PrevAndNext(long dialogMemberId,
		long memberId, String memberType,
		OrderByComparator<DialogMember> orderByComparator)
		throws NoSuchDialogMemberException {
		DialogMember dialogMember = findByPrimaryKey(dialogMemberId);

		Session session = null;

		try {
			session = openSession();

			DialogMember[] array = new DialogMemberImpl[3];

			array[0] = getByMember_PrevAndNext(session, dialogMember, memberId,
					memberType, orderByComparator, true);

			array[1] = dialogMember;

			array[2] = getByMember_PrevAndNext(session, dialogMember, memberId,
					memberType, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DialogMember getByMember_PrevAndNext(Session session,
		DialogMember dialogMember, long memberId, String memberType,
		OrderByComparator<DialogMember> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_DIALOGMEMBER_WHERE);

		query.append(_FINDER_COLUMN_MEMBER_MEMBERID_2);

		boolean bindMemberType = false;

		if (memberType == null) {
			query.append(_FINDER_COLUMN_MEMBER_MEMBERTYPE_1);
		}
		else if (memberType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_MEMBER_MEMBERTYPE_3);
		}
		else {
			bindMemberType = true;

			query.append(_FINDER_COLUMN_MEMBER_MEMBERTYPE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(DialogMemberModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(memberId);

		if (bindMemberType) {
			qPos.add(memberType);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dialogMember);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DialogMember> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dialog members where memberId = &#63; and memberType = &#63; from the database.
	 *
	 * @param memberId the member ID
	 * @param memberType the member type
	 */
	@Override
	public void removeByMember(long memberId, String memberType) {
		for (DialogMember dialogMember : findByMember(memberId, memberType,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(dialogMember);
		}
	}

	/**
	 * Returns the number of dialog members where memberId = &#63; and memberType = &#63;.
	 *
	 * @param memberId the member ID
	 * @param memberType the member type
	 * @return the number of matching dialog members
	 */
	@Override
	public int countByMember(long memberId, String memberType) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MEMBER;

		Object[] finderArgs = new Object[] { memberId, memberType };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DIALOGMEMBER_WHERE);

			query.append(_FINDER_COLUMN_MEMBER_MEMBERID_2);

			boolean bindMemberType = false;

			if (memberType == null) {
				query.append(_FINDER_COLUMN_MEMBER_MEMBERTYPE_1);
			}
			else if (memberType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MEMBER_MEMBERTYPE_3);
			}
			else {
				bindMemberType = true;

				query.append(_FINDER_COLUMN_MEMBER_MEMBERTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(memberId);

				if (bindMemberType) {
					qPos.add(memberType);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_MEMBER_MEMBERID_2 = "dialogMember.memberId = ? AND ";
	private static final String _FINDER_COLUMN_MEMBER_MEMBERTYPE_1 = "dialogMember.memberType IS NULL";
	private static final String _FINDER_COLUMN_MEMBER_MEMBERTYPE_2 = "dialogMember.memberType = ?";
	private static final String _FINDER_COLUMN_MEMBER_MEMBERTYPE_3 = "(dialogMember.memberType IS NULL OR dialogMember.memberType = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_DIALOGANDMEMBER = new FinderPath(DialogMemberModelImpl.ENTITY_CACHE_ENABLED,
			DialogMemberModelImpl.FINDER_CACHE_ENABLED, DialogMemberImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByDialogAndMember",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			DialogMemberModelImpl.DIALOGID_COLUMN_BITMASK |
			DialogMemberModelImpl.MEMBERID_COLUMN_BITMASK |
			DialogMemberModelImpl.MEMBERTYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DIALOGANDMEMBER = new FinderPath(DialogMemberModelImpl.ENTITY_CACHE_ENABLED,
			DialogMemberModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDialogAndMember",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns the dialog member where dialogId = &#63; and memberId = &#63; and memberType = &#63; or throws a {@link NoSuchDialogMemberException} if it could not be found.
	 *
	 * @param dialogId the dialog ID
	 * @param memberId the member ID
	 * @param memberType the member type
	 * @return the matching dialog member
	 * @throws NoSuchDialogMemberException if a matching dialog member could not be found
	 */
	@Override
	public DialogMember findByDialogAndMember(long dialogId, long memberId,
		String memberType) throws NoSuchDialogMemberException {
		DialogMember dialogMember = fetchByDialogAndMember(dialogId, memberId,
				memberType);

		if (dialogMember == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("dialogId=");
			msg.append(dialogId);

			msg.append(", memberId=");
			msg.append(memberId);

			msg.append(", memberType=");
			msg.append(memberType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchDialogMemberException(msg.toString());
		}

		return dialogMember;
	}

	/**
	 * Returns the dialog member where dialogId = &#63; and memberId = &#63; and memberType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param dialogId the dialog ID
	 * @param memberId the member ID
	 * @param memberType the member type
	 * @return the matching dialog member, or <code>null</code> if a matching dialog member could not be found
	 */
	@Override
	public DialogMember fetchByDialogAndMember(long dialogId, long memberId,
		String memberType) {
		return fetchByDialogAndMember(dialogId, memberId, memberType, true);
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
	@Override
	public DialogMember fetchByDialogAndMember(long dialogId, long memberId,
		String memberType, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { dialogId, memberId, memberType };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_DIALOGANDMEMBER,
					finderArgs, this);
		}

		if (result instanceof DialogMember) {
			DialogMember dialogMember = (DialogMember)result;

			if ((dialogId != dialogMember.getDialogId()) ||
					(memberId != dialogMember.getMemberId()) ||
					!Objects.equals(memberType, dialogMember.getMemberType())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_DIALOGMEMBER_WHERE);

			query.append(_FINDER_COLUMN_DIALOGANDMEMBER_DIALOGID_2);

			query.append(_FINDER_COLUMN_DIALOGANDMEMBER_MEMBERID_2);

			boolean bindMemberType = false;

			if (memberType == null) {
				query.append(_FINDER_COLUMN_DIALOGANDMEMBER_MEMBERTYPE_1);
			}
			else if (memberType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DIALOGANDMEMBER_MEMBERTYPE_3);
			}
			else {
				bindMemberType = true;

				query.append(_FINDER_COLUMN_DIALOGANDMEMBER_MEMBERTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dialogId);

				qPos.add(memberId);

				if (bindMemberType) {
					qPos.add(memberType);
				}

				List<DialogMember> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_DIALOGANDMEMBER,
						finderArgs, list);
				}
				else {
					DialogMember dialogMember = list.get(0);

					result = dialogMember;

					cacheResult(dialogMember);

					if ((dialogMember.getDialogId() != dialogId) ||
							(dialogMember.getMemberId() != memberId) ||
							(dialogMember.getMemberType() == null) ||
							!dialogMember.getMemberType().equals(memberType)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_DIALOGANDMEMBER,
							finderArgs, dialogMember);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_DIALOGANDMEMBER,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (DialogMember)result;
		}
	}

	/**
	 * Removes the dialog member where dialogId = &#63; and memberId = &#63; and memberType = &#63; from the database.
	 *
	 * @param dialogId the dialog ID
	 * @param memberId the member ID
	 * @param memberType the member type
	 * @return the dialog member that was removed
	 */
	@Override
	public DialogMember removeByDialogAndMember(long dialogId, long memberId,
		String memberType) throws NoSuchDialogMemberException {
		DialogMember dialogMember = findByDialogAndMember(dialogId, memberId,
				memberType);

		return remove(dialogMember);
	}

	/**
	 * Returns the number of dialog members where dialogId = &#63; and memberId = &#63; and memberType = &#63;.
	 *
	 * @param dialogId the dialog ID
	 * @param memberId the member ID
	 * @param memberType the member type
	 * @return the number of matching dialog members
	 */
	@Override
	public int countByDialogAndMember(long dialogId, long memberId,
		String memberType) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DIALOGANDMEMBER;

		Object[] finderArgs = new Object[] { dialogId, memberId, memberType };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_DIALOGMEMBER_WHERE);

			query.append(_FINDER_COLUMN_DIALOGANDMEMBER_DIALOGID_2);

			query.append(_FINDER_COLUMN_DIALOGANDMEMBER_MEMBERID_2);

			boolean bindMemberType = false;

			if (memberType == null) {
				query.append(_FINDER_COLUMN_DIALOGANDMEMBER_MEMBERTYPE_1);
			}
			else if (memberType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DIALOGANDMEMBER_MEMBERTYPE_3);
			}
			else {
				bindMemberType = true;

				query.append(_FINDER_COLUMN_DIALOGANDMEMBER_MEMBERTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dialogId);

				qPos.add(memberId);

				if (bindMemberType) {
					qPos.add(memberType);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_DIALOGANDMEMBER_DIALOGID_2 = "dialogMember.dialogId = ? AND ";
	private static final String _FINDER_COLUMN_DIALOGANDMEMBER_MEMBERID_2 = "dialogMember.memberId = ? AND ";
	private static final String _FINDER_COLUMN_DIALOGANDMEMBER_MEMBERTYPE_1 = "dialogMember.memberType IS NULL";
	private static final String _FINDER_COLUMN_DIALOGANDMEMBER_MEMBERTYPE_2 = "dialogMember.memberType = ?";
	private static final String _FINDER_COLUMN_DIALOGANDMEMBER_MEMBERTYPE_3 = "(dialogMember.memberType IS NULL OR dialogMember.memberType = '')";

	public DialogMemberPersistenceImpl() {
		setModelClass(DialogMember.class);
	}

	/**
	 * Caches the dialog member in the entity cache if it is enabled.
	 *
	 * @param dialogMember the dialog member
	 */
	@Override
	public void cacheResult(DialogMember dialogMember) {
		entityCache.putResult(DialogMemberModelImpl.ENTITY_CACHE_ENABLED,
			DialogMemberImpl.class, dialogMember.getPrimaryKey(), dialogMember);

		finderCache.putResult(FINDER_PATH_FETCH_BY_DIALOGANDMEMBER,
			new Object[] {
				dialogMember.getDialogId(), dialogMember.getMemberId(),
				dialogMember.getMemberType()
			}, dialogMember);

		dialogMember.resetOriginalValues();
	}

	/**
	 * Caches the dialog members in the entity cache if it is enabled.
	 *
	 * @param dialogMembers the dialog members
	 */
	@Override
	public void cacheResult(List<DialogMember> dialogMembers) {
		for (DialogMember dialogMember : dialogMembers) {
			if (entityCache.getResult(
						DialogMemberModelImpl.ENTITY_CACHE_ENABLED,
						DialogMemberImpl.class, dialogMember.getPrimaryKey()) == null) {
				cacheResult(dialogMember);
			}
			else {
				dialogMember.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all dialog members.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DialogMemberImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the dialog member.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DialogMember dialogMember) {
		entityCache.removeResult(DialogMemberModelImpl.ENTITY_CACHE_ENABLED,
			DialogMemberImpl.class, dialogMember.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((DialogMemberModelImpl)dialogMember, true);
	}

	@Override
	public void clearCache(List<DialogMember> dialogMembers) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DialogMember dialogMember : dialogMembers) {
			entityCache.removeResult(DialogMemberModelImpl.ENTITY_CACHE_ENABLED,
				DialogMemberImpl.class, dialogMember.getPrimaryKey());

			clearUniqueFindersCache((DialogMemberModelImpl)dialogMember, true);
		}
	}

	protected void cacheUniqueFindersCache(
		DialogMemberModelImpl dialogMemberModelImpl) {
		Object[] args = new Object[] {
				dialogMemberModelImpl.getDialogId(),
				dialogMemberModelImpl.getMemberId(),
				dialogMemberModelImpl.getMemberType()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_DIALOGANDMEMBER, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_DIALOGANDMEMBER, args,
			dialogMemberModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		DialogMemberModelImpl dialogMemberModelImpl, boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					dialogMemberModelImpl.getDialogId(),
					dialogMemberModelImpl.getMemberId(),
					dialogMemberModelImpl.getMemberType()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_DIALOGANDMEMBER, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_DIALOGANDMEMBER, args);
		}

		if ((dialogMemberModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_DIALOGANDMEMBER.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					dialogMemberModelImpl.getOriginalDialogId(),
					dialogMemberModelImpl.getOriginalMemberId(),
					dialogMemberModelImpl.getOriginalMemberType()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_DIALOGANDMEMBER, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_DIALOGANDMEMBER, args);
		}
	}

	/**
	 * Creates a new dialog member with the primary key. Does not add the dialog member to the database.
	 *
	 * @param dialogMemberId the primary key for the new dialog member
	 * @return the new dialog member
	 */
	@Override
	public DialogMember create(long dialogMemberId) {
		DialogMember dialogMember = new DialogMemberImpl();

		dialogMember.setNew(true);
		dialogMember.setPrimaryKey(dialogMemberId);

		return dialogMember;
	}

	/**
	 * Removes the dialog member with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dialogMemberId the primary key of the dialog member
	 * @return the dialog member that was removed
	 * @throws NoSuchDialogMemberException if a dialog member with the primary key could not be found
	 */
	@Override
	public DialogMember remove(long dialogMemberId)
		throws NoSuchDialogMemberException {
		return remove((Serializable)dialogMemberId);
	}

	/**
	 * Removes the dialog member with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dialog member
	 * @return the dialog member that was removed
	 * @throws NoSuchDialogMemberException if a dialog member with the primary key could not be found
	 */
	@Override
	public DialogMember remove(Serializable primaryKey)
		throws NoSuchDialogMemberException {
		Session session = null;

		try {
			session = openSession();

			DialogMember dialogMember = (DialogMember)session.get(DialogMemberImpl.class,
					primaryKey);

			if (dialogMember == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDialogMemberException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(dialogMember);
		}
		catch (NoSuchDialogMemberException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected DialogMember removeImpl(DialogMember dialogMember) {
		dialogMember = toUnwrappedModel(dialogMember);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dialogMember)) {
				dialogMember = (DialogMember)session.get(DialogMemberImpl.class,
						dialogMember.getPrimaryKeyObj());
			}

			if (dialogMember != null) {
				session.delete(dialogMember);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (dialogMember != null) {
			clearCache(dialogMember);
		}

		return dialogMember;
	}

	@Override
	public DialogMember updateImpl(DialogMember dialogMember) {
		dialogMember = toUnwrappedModel(dialogMember);

		boolean isNew = dialogMember.isNew();

		DialogMemberModelImpl dialogMemberModelImpl = (DialogMemberModelImpl)dialogMember;

		Session session = null;

		try {
			session = openSession();

			if (dialogMember.isNew()) {
				session.save(dialogMember);

				dialogMember.setNew(false);
			}
			else {
				dialogMember = (DialogMember)session.merge(dialogMember);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DialogMemberModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((dialogMemberModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DIALOG.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						dialogMemberModelImpl.getOriginalDialogId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DIALOG, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DIALOG,
					args);

				args = new Object[] { dialogMemberModelImpl.getDialogId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DIALOG, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DIALOG,
					args);
			}

			if ((dialogMemberModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						dialogMemberModelImpl.getOriginalMemberId(),
						dialogMemberModelImpl.getOriginalMemberType()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_MEMBER, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBER,
					args);

				args = new Object[] {
						dialogMemberModelImpl.getMemberId(),
						dialogMemberModelImpl.getMemberType()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_MEMBER, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBER,
					args);
			}
		}

		entityCache.putResult(DialogMemberModelImpl.ENTITY_CACHE_ENABLED,
			DialogMemberImpl.class, dialogMember.getPrimaryKey(), dialogMember,
			false);

		clearUniqueFindersCache(dialogMemberModelImpl, false);
		cacheUniqueFindersCache(dialogMemberModelImpl);

		dialogMember.resetOriginalValues();

		return dialogMember;
	}

	protected DialogMember toUnwrappedModel(DialogMember dialogMember) {
		if (dialogMember instanceof DialogMemberImpl) {
			return dialogMember;
		}

		DialogMemberImpl dialogMemberImpl = new DialogMemberImpl();

		dialogMemberImpl.setNew(dialogMember.isNew());
		dialogMemberImpl.setPrimaryKey(dialogMember.getPrimaryKey());

		dialogMemberImpl.setDialogMemberId(dialogMember.getDialogMemberId());
		dialogMemberImpl.setDialogId(dialogMember.getDialogId());
		dialogMemberImpl.setMemberId(dialogMember.getMemberId());
		dialogMemberImpl.setMemberType(dialogMember.getMemberType());

		return dialogMemberImpl;
	}

	/**
	 * Returns the dialog member with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the dialog member
	 * @return the dialog member
	 * @throws NoSuchDialogMemberException if a dialog member with the primary key could not be found
	 */
	@Override
	public DialogMember findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDialogMemberException {
		DialogMember dialogMember = fetchByPrimaryKey(primaryKey);

		if (dialogMember == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDialogMemberException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return dialogMember;
	}

	/**
	 * Returns the dialog member with the primary key or throws a {@link NoSuchDialogMemberException} if it could not be found.
	 *
	 * @param dialogMemberId the primary key of the dialog member
	 * @return the dialog member
	 * @throws NoSuchDialogMemberException if a dialog member with the primary key could not be found
	 */
	@Override
	public DialogMember findByPrimaryKey(long dialogMemberId)
		throws NoSuchDialogMemberException {
		return findByPrimaryKey((Serializable)dialogMemberId);
	}

	/**
	 * Returns the dialog member with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dialog member
	 * @return the dialog member, or <code>null</code> if a dialog member with the primary key could not be found
	 */
	@Override
	public DialogMember fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(DialogMemberModelImpl.ENTITY_CACHE_ENABLED,
				DialogMemberImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		DialogMember dialogMember = (DialogMember)serializable;

		if (dialogMember == null) {
			Session session = null;

			try {
				session = openSession();

				dialogMember = (DialogMember)session.get(DialogMemberImpl.class,
						primaryKey);

				if (dialogMember != null) {
					cacheResult(dialogMember);
				}
				else {
					entityCache.putResult(DialogMemberModelImpl.ENTITY_CACHE_ENABLED,
						DialogMemberImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(DialogMemberModelImpl.ENTITY_CACHE_ENABLED,
					DialogMemberImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return dialogMember;
	}

	/**
	 * Returns the dialog member with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dialogMemberId the primary key of the dialog member
	 * @return the dialog member, or <code>null</code> if a dialog member with the primary key could not be found
	 */
	@Override
	public DialogMember fetchByPrimaryKey(long dialogMemberId) {
		return fetchByPrimaryKey((Serializable)dialogMemberId);
	}

	@Override
	public Map<Serializable, DialogMember> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, DialogMember> map = new HashMap<Serializable, DialogMember>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			DialogMember dialogMember = fetchByPrimaryKey(primaryKey);

			if (dialogMember != null) {
				map.put(primaryKey, dialogMember);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(DialogMemberModelImpl.ENTITY_CACHE_ENABLED,
					DialogMemberImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (DialogMember)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_DIALOGMEMBER_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(String.valueOf(primaryKey));

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (DialogMember dialogMember : (List<DialogMember>)q.list()) {
				map.put(dialogMember.getPrimaryKeyObj(), dialogMember);

				cacheResult(dialogMember);

				uncachedPrimaryKeys.remove(dialogMember.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(DialogMemberModelImpl.ENTITY_CACHE_ENABLED,
					DialogMemberImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the dialog members.
	 *
	 * @return the dialog members
	 */
	@Override
	public List<DialogMember> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<DialogMember> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<DialogMember> findAll(int start, int end,
		OrderByComparator<DialogMember> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<DialogMember> findAll(int start, int end,
		OrderByComparator<DialogMember> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<DialogMember> list = null;

		if (retrieveFromCache) {
			list = (List<DialogMember>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_DIALOGMEMBER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DIALOGMEMBER;

				if (pagination) {
					sql = sql.concat(DialogMemberModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<DialogMember>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DialogMember>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the dialog members from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DialogMember dialogMember : findAll()) {
			remove(dialogMember);
		}
	}

	/**
	 * Returns the number of dialog members.
	 *
	 * @return the number of dialog members
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DIALOGMEMBER);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DialogMemberModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the dialog member persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(DialogMemberImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_DIALOGMEMBER = "SELECT dialogMember FROM DialogMember dialogMember";
	private static final String _SQL_SELECT_DIALOGMEMBER_WHERE_PKS_IN = "SELECT dialogMember FROM DialogMember dialogMember WHERE dialogMemberId IN (";
	private static final String _SQL_SELECT_DIALOGMEMBER_WHERE = "SELECT dialogMember FROM DialogMember dialogMember WHERE ";
	private static final String _SQL_COUNT_DIALOGMEMBER = "SELECT COUNT(dialogMember) FROM DialogMember dialogMember";
	private static final String _SQL_COUNT_DIALOGMEMBER_WHERE = "SELECT COUNT(dialogMember) FROM DialogMember dialogMember WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "dialogMember.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DialogMember exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No DialogMember exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(DialogMemberPersistenceImpl.class);
}