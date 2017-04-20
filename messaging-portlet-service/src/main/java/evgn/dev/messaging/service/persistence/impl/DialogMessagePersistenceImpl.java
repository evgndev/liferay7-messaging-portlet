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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import evgn.dev.messaging.exception.NoSuchDialogMessageException;
import evgn.dev.messaging.model.DialogMessage;
import evgn.dev.messaging.model.impl.DialogMessageImpl;
import evgn.dev.messaging.model.impl.DialogMessageModelImpl;
import evgn.dev.messaging.service.persistence.DialogMessagePersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the dialog message service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DialogMessagePersistence
 * @see evgn.dev.messaging.service.persistence.DialogMessageUtil
 * @generated
 */
@ProviderType
public class DialogMessagePersistenceImpl extends BasePersistenceImpl<DialogMessage>
	implements DialogMessagePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DialogMessageUtil} to access the dialog message persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DialogMessageImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DialogMessageModelImpl.ENTITY_CACHE_ENABLED,
			DialogMessageModelImpl.FINDER_CACHE_ENABLED,
			DialogMessageImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DialogMessageModelImpl.ENTITY_CACHE_ENABLED,
			DialogMessageModelImpl.FINDER_CACHE_ENABLED,
			DialogMessageImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DialogMessageModelImpl.ENTITY_CACHE_ENABLED,
			DialogMessageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DIALOG = new FinderPath(DialogMessageModelImpl.ENTITY_CACHE_ENABLED,
			DialogMessageModelImpl.FINDER_CACHE_ENABLED,
			DialogMessageImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByDialog",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DIALOG =
		new FinderPath(DialogMessageModelImpl.ENTITY_CACHE_ENABLED,
			DialogMessageModelImpl.FINDER_CACHE_ENABLED,
			DialogMessageImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByDialog", new String[] { Long.class.getName() },
			DialogMessageModelImpl.DIALOGID_COLUMN_BITMASK |
			DialogMessageModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DIALOG = new FinderPath(DialogMessageModelImpl.ENTITY_CACHE_ENABLED,
			DialogMessageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDialog",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the dialog messages where dialogId = &#63;.
	 *
	 * @param dialogId the dialog ID
	 * @return the matching dialog messages
	 */
	@Override
	public List<DialogMessage> findByDialog(long dialogId) {
		return findByDialog(dialogId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<DialogMessage> findByDialog(long dialogId, int start, int end) {
		return findByDialog(dialogId, start, end, null);
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
	@Override
	public List<DialogMessage> findByDialog(long dialogId, int start, int end,
		OrderByComparator<DialogMessage> orderByComparator) {
		return findByDialog(dialogId, start, end, orderByComparator, true);
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
	@Override
	public List<DialogMessage> findByDialog(long dialogId, int start, int end,
		OrderByComparator<DialogMessage> orderByComparator,
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

		List<DialogMessage> list = null;

		if (retrieveFromCache) {
			list = (List<DialogMessage>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DialogMessage dialogMessage : list) {
					if ((dialogId != dialogMessage.getDialogId())) {
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

			query.append(_SQL_SELECT_DIALOGMESSAGE_WHERE);

			query.append(_FINDER_COLUMN_DIALOG_DIALOGID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DialogMessageModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dialogId);

				if (!pagination) {
					list = (List<DialogMessage>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DialogMessage>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first dialog message in the ordered set where dialogId = &#63;.
	 *
	 * @param dialogId the dialog ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dialog message
	 * @throws NoSuchDialogMessageException if a matching dialog message could not be found
	 */
	@Override
	public DialogMessage findByDialog_First(long dialogId,
		OrderByComparator<DialogMessage> orderByComparator)
		throws NoSuchDialogMessageException {
		DialogMessage dialogMessage = fetchByDialog_First(dialogId,
				orderByComparator);

		if (dialogMessage != null) {
			return dialogMessage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dialogId=");
		msg.append(dialogId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDialogMessageException(msg.toString());
	}

	/**
	 * Returns the first dialog message in the ordered set where dialogId = &#63;.
	 *
	 * @param dialogId the dialog ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dialog message, or <code>null</code> if a matching dialog message could not be found
	 */
	@Override
	public DialogMessage fetchByDialog_First(long dialogId,
		OrderByComparator<DialogMessage> orderByComparator) {
		List<DialogMessage> list = findByDialog(dialogId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dialog message in the ordered set where dialogId = &#63;.
	 *
	 * @param dialogId the dialog ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dialog message
	 * @throws NoSuchDialogMessageException if a matching dialog message could not be found
	 */
	@Override
	public DialogMessage findByDialog_Last(long dialogId,
		OrderByComparator<DialogMessage> orderByComparator)
		throws NoSuchDialogMessageException {
		DialogMessage dialogMessage = fetchByDialog_Last(dialogId,
				orderByComparator);

		if (dialogMessage != null) {
			return dialogMessage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dialogId=");
		msg.append(dialogId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDialogMessageException(msg.toString());
	}

	/**
	 * Returns the last dialog message in the ordered set where dialogId = &#63;.
	 *
	 * @param dialogId the dialog ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dialog message, or <code>null</code> if a matching dialog message could not be found
	 */
	@Override
	public DialogMessage fetchByDialog_Last(long dialogId,
		OrderByComparator<DialogMessage> orderByComparator) {
		int count = countByDialog(dialogId);

		if (count == 0) {
			return null;
		}

		List<DialogMessage> list = findByDialog(dialogId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public DialogMessage[] findByDialog_PrevAndNext(long messageId,
		long dialogId, OrderByComparator<DialogMessage> orderByComparator)
		throws NoSuchDialogMessageException {
		DialogMessage dialogMessage = findByPrimaryKey(messageId);

		Session session = null;

		try {
			session = openSession();

			DialogMessage[] array = new DialogMessageImpl[3];

			array[0] = getByDialog_PrevAndNext(session, dialogMessage,
					dialogId, orderByComparator, true);

			array[1] = dialogMessage;

			array[2] = getByDialog_PrevAndNext(session, dialogMessage,
					dialogId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DialogMessage getByDialog_PrevAndNext(Session session,
		DialogMessage dialogMessage, long dialogId,
		OrderByComparator<DialogMessage> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DIALOGMESSAGE_WHERE);

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
			query.append(DialogMessageModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(dialogId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dialogMessage);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DialogMessage> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dialog messages where dialogId = &#63; from the database.
	 *
	 * @param dialogId the dialog ID
	 */
	@Override
	public void removeByDialog(long dialogId) {
		for (DialogMessage dialogMessage : findByDialog(dialogId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(dialogMessage);
		}
	}

	/**
	 * Returns the number of dialog messages where dialogId = &#63;.
	 *
	 * @param dialogId the dialog ID
	 * @return the number of matching dialog messages
	 */
	@Override
	public int countByDialog(long dialogId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DIALOG;

		Object[] finderArgs = new Object[] { dialogId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DIALOGMESSAGE_WHERE);

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

	private static final String _FINDER_COLUMN_DIALOG_DIALOGID_2 = "dialogMessage.dialogId = ?";

	public DialogMessagePersistenceImpl() {
		setModelClass(DialogMessage.class);
	}

	/**
	 * Caches the dialog message in the entity cache if it is enabled.
	 *
	 * @param dialogMessage the dialog message
	 */
	@Override
	public void cacheResult(DialogMessage dialogMessage) {
		entityCache.putResult(DialogMessageModelImpl.ENTITY_CACHE_ENABLED,
			DialogMessageImpl.class, dialogMessage.getPrimaryKey(),
			dialogMessage);

		dialogMessage.resetOriginalValues();
	}

	/**
	 * Caches the dialog messages in the entity cache if it is enabled.
	 *
	 * @param dialogMessages the dialog messages
	 */
	@Override
	public void cacheResult(List<DialogMessage> dialogMessages) {
		for (DialogMessage dialogMessage : dialogMessages) {
			if (entityCache.getResult(
						DialogMessageModelImpl.ENTITY_CACHE_ENABLED,
						DialogMessageImpl.class, dialogMessage.getPrimaryKey()) == null) {
				cacheResult(dialogMessage);
			}
			else {
				dialogMessage.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all dialog messages.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DialogMessageImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the dialog message.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DialogMessage dialogMessage) {
		entityCache.removeResult(DialogMessageModelImpl.ENTITY_CACHE_ENABLED,
			DialogMessageImpl.class, dialogMessage.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<DialogMessage> dialogMessages) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DialogMessage dialogMessage : dialogMessages) {
			entityCache.removeResult(DialogMessageModelImpl.ENTITY_CACHE_ENABLED,
				DialogMessageImpl.class, dialogMessage.getPrimaryKey());
		}
	}

	/**
	 * Creates a new dialog message with the primary key. Does not add the dialog message to the database.
	 *
	 * @param messageId the primary key for the new dialog message
	 * @return the new dialog message
	 */
	@Override
	public DialogMessage create(long messageId) {
		DialogMessage dialogMessage = new DialogMessageImpl();

		dialogMessage.setNew(true);
		dialogMessage.setPrimaryKey(messageId);

		return dialogMessage;
	}

	/**
	 * Removes the dialog message with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param messageId the primary key of the dialog message
	 * @return the dialog message that was removed
	 * @throws NoSuchDialogMessageException if a dialog message with the primary key could not be found
	 */
	@Override
	public DialogMessage remove(long messageId)
		throws NoSuchDialogMessageException {
		return remove((Serializable)messageId);
	}

	/**
	 * Removes the dialog message with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dialog message
	 * @return the dialog message that was removed
	 * @throws NoSuchDialogMessageException if a dialog message with the primary key could not be found
	 */
	@Override
	public DialogMessage remove(Serializable primaryKey)
		throws NoSuchDialogMessageException {
		Session session = null;

		try {
			session = openSession();

			DialogMessage dialogMessage = (DialogMessage)session.get(DialogMessageImpl.class,
					primaryKey);

			if (dialogMessage == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDialogMessageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(dialogMessage);
		}
		catch (NoSuchDialogMessageException nsee) {
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
	protected DialogMessage removeImpl(DialogMessage dialogMessage) {
		dialogMessage = toUnwrappedModel(dialogMessage);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dialogMessage)) {
				dialogMessage = (DialogMessage)session.get(DialogMessageImpl.class,
						dialogMessage.getPrimaryKeyObj());
			}

			if (dialogMessage != null) {
				session.delete(dialogMessage);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (dialogMessage != null) {
			clearCache(dialogMessage);
		}

		return dialogMessage;
	}

	@Override
	public DialogMessage updateImpl(DialogMessage dialogMessage) {
		dialogMessage = toUnwrappedModel(dialogMessage);

		boolean isNew = dialogMessage.isNew();

		DialogMessageModelImpl dialogMessageModelImpl = (DialogMessageModelImpl)dialogMessage;

		Session session = null;

		try {
			session = openSession();

			if (dialogMessage.isNew()) {
				session.save(dialogMessage);

				dialogMessage.setNew(false);
			}
			else {
				dialogMessage = (DialogMessage)session.merge(dialogMessage);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DialogMessageModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((dialogMessageModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DIALOG.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						dialogMessageModelImpl.getOriginalDialogId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DIALOG, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DIALOG,
					args);

				args = new Object[] { dialogMessageModelImpl.getDialogId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DIALOG, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DIALOG,
					args);
			}
		}

		entityCache.putResult(DialogMessageModelImpl.ENTITY_CACHE_ENABLED,
			DialogMessageImpl.class, dialogMessage.getPrimaryKey(),
			dialogMessage, false);

		dialogMessage.resetOriginalValues();

		return dialogMessage;
	}

	protected DialogMessage toUnwrappedModel(DialogMessage dialogMessage) {
		if (dialogMessage instanceof DialogMessageImpl) {
			return dialogMessage;
		}

		DialogMessageImpl dialogMessageImpl = new DialogMessageImpl();

		dialogMessageImpl.setNew(dialogMessage.isNew());
		dialogMessageImpl.setPrimaryKey(dialogMessage.getPrimaryKey());

		dialogMessageImpl.setMessageId(dialogMessage.getMessageId());
		dialogMessageImpl.setDialogId(dialogMessage.getDialogId());
		dialogMessageImpl.setText(dialogMessage.getText());
		dialogMessageImpl.setDialogMemberId(dialogMessage.getDialogMemberId());
		dialogMessageImpl.setUserId(dialogMessage.getUserId());
		dialogMessageImpl.setCreateDate(dialogMessage.getCreateDate());

		return dialogMessageImpl;
	}

	/**
	 * Returns the dialog message with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the dialog message
	 * @return the dialog message
	 * @throws NoSuchDialogMessageException if a dialog message with the primary key could not be found
	 */
	@Override
	public DialogMessage findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDialogMessageException {
		DialogMessage dialogMessage = fetchByPrimaryKey(primaryKey);

		if (dialogMessage == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDialogMessageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return dialogMessage;
	}

	/**
	 * Returns the dialog message with the primary key or throws a {@link NoSuchDialogMessageException} if it could not be found.
	 *
	 * @param messageId the primary key of the dialog message
	 * @return the dialog message
	 * @throws NoSuchDialogMessageException if a dialog message with the primary key could not be found
	 */
	@Override
	public DialogMessage findByPrimaryKey(long messageId)
		throws NoSuchDialogMessageException {
		return findByPrimaryKey((Serializable)messageId);
	}

	/**
	 * Returns the dialog message with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dialog message
	 * @return the dialog message, or <code>null</code> if a dialog message with the primary key could not be found
	 */
	@Override
	public DialogMessage fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(DialogMessageModelImpl.ENTITY_CACHE_ENABLED,
				DialogMessageImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		DialogMessage dialogMessage = (DialogMessage)serializable;

		if (dialogMessage == null) {
			Session session = null;

			try {
				session = openSession();

				dialogMessage = (DialogMessage)session.get(DialogMessageImpl.class,
						primaryKey);

				if (dialogMessage != null) {
					cacheResult(dialogMessage);
				}
				else {
					entityCache.putResult(DialogMessageModelImpl.ENTITY_CACHE_ENABLED,
						DialogMessageImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(DialogMessageModelImpl.ENTITY_CACHE_ENABLED,
					DialogMessageImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return dialogMessage;
	}

	/**
	 * Returns the dialog message with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param messageId the primary key of the dialog message
	 * @return the dialog message, or <code>null</code> if a dialog message with the primary key could not be found
	 */
	@Override
	public DialogMessage fetchByPrimaryKey(long messageId) {
		return fetchByPrimaryKey((Serializable)messageId);
	}

	@Override
	public Map<Serializable, DialogMessage> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, DialogMessage> map = new HashMap<Serializable, DialogMessage>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			DialogMessage dialogMessage = fetchByPrimaryKey(primaryKey);

			if (dialogMessage != null) {
				map.put(primaryKey, dialogMessage);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(DialogMessageModelImpl.ENTITY_CACHE_ENABLED,
					DialogMessageImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (DialogMessage)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_DIALOGMESSAGE_WHERE_PKS_IN);

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

			for (DialogMessage dialogMessage : (List<DialogMessage>)q.list()) {
				map.put(dialogMessage.getPrimaryKeyObj(), dialogMessage);

				cacheResult(dialogMessage);

				uncachedPrimaryKeys.remove(dialogMessage.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(DialogMessageModelImpl.ENTITY_CACHE_ENABLED,
					DialogMessageImpl.class, primaryKey, nullModel);
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
	 * Returns all the dialog messages.
	 *
	 * @return the dialog messages
	 */
	@Override
	public List<DialogMessage> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<DialogMessage> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<DialogMessage> findAll(int start, int end,
		OrderByComparator<DialogMessage> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<DialogMessage> findAll(int start, int end,
		OrderByComparator<DialogMessage> orderByComparator,
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

		List<DialogMessage> list = null;

		if (retrieveFromCache) {
			list = (List<DialogMessage>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_DIALOGMESSAGE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DIALOGMESSAGE;

				if (pagination) {
					sql = sql.concat(DialogMessageModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<DialogMessage>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DialogMessage>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the dialog messages from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DialogMessage dialogMessage : findAll()) {
			remove(dialogMessage);
		}
	}

	/**
	 * Returns the number of dialog messages.
	 *
	 * @return the number of dialog messages
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DIALOGMESSAGE);

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
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DialogMessageModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the dialog message persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(DialogMessageImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_DIALOGMESSAGE = "SELECT dialogMessage FROM DialogMessage dialogMessage";
	private static final String _SQL_SELECT_DIALOGMESSAGE_WHERE_PKS_IN = "SELECT dialogMessage FROM DialogMessage dialogMessage WHERE messageId IN (";
	private static final String _SQL_SELECT_DIALOGMESSAGE_WHERE = "SELECT dialogMessage FROM DialogMessage dialogMessage WHERE ";
	private static final String _SQL_COUNT_DIALOGMESSAGE = "SELECT COUNT(dialogMessage) FROM DialogMessage dialogMessage";
	private static final String _SQL_COUNT_DIALOGMESSAGE_WHERE = "SELECT COUNT(dialogMessage) FROM DialogMessage dialogMessage WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "dialogMessage.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DialogMessage exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No DialogMessage exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(DialogMessagePersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"text"
			});
}