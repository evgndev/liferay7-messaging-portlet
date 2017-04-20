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
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import evgn.dev.messaging.exception.NoSuchDialogException;
import evgn.dev.messaging.model.Dialog;
import evgn.dev.messaging.model.impl.DialogImpl;
import evgn.dev.messaging.model.impl.DialogModelImpl;
import evgn.dev.messaging.service.persistence.DialogPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the dialog service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DialogPersistence
 * @see evgn.dev.messaging.service.persistence.DialogUtil
 * @generated
 */
@ProviderType
public class DialogPersistenceImpl extends BasePersistenceImpl<Dialog>
	implements DialogPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DialogUtil} to access the dialog persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DialogImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DialogModelImpl.ENTITY_CACHE_ENABLED,
			DialogModelImpl.FINDER_CACHE_ENABLED, DialogImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DialogModelImpl.ENTITY_CACHE_ENABLED,
			DialogModelImpl.FINDER_CACHE_ENABLED, DialogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DialogModelImpl.ENTITY_CACHE_ENABLED,
			DialogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public DialogPersistenceImpl() {
		setModelClass(Dialog.class);
	}

	/**
	 * Caches the dialog in the entity cache if it is enabled.
	 *
	 * @param dialog the dialog
	 */
	@Override
	public void cacheResult(Dialog dialog) {
		entityCache.putResult(DialogModelImpl.ENTITY_CACHE_ENABLED,
			DialogImpl.class, dialog.getPrimaryKey(), dialog);

		dialog.resetOriginalValues();
	}

	/**
	 * Caches the dialogs in the entity cache if it is enabled.
	 *
	 * @param dialogs the dialogs
	 */
	@Override
	public void cacheResult(List<Dialog> dialogs) {
		for (Dialog dialog : dialogs) {
			if (entityCache.getResult(DialogModelImpl.ENTITY_CACHE_ENABLED,
						DialogImpl.class, dialog.getPrimaryKey()) == null) {
				cacheResult(dialog);
			}
			else {
				dialog.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all dialogs.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DialogImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the dialog.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Dialog dialog) {
		entityCache.removeResult(DialogModelImpl.ENTITY_CACHE_ENABLED,
			DialogImpl.class, dialog.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Dialog> dialogs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Dialog dialog : dialogs) {
			entityCache.removeResult(DialogModelImpl.ENTITY_CACHE_ENABLED,
				DialogImpl.class, dialog.getPrimaryKey());
		}
	}

	/**
	 * Creates a new dialog with the primary key. Does not add the dialog to the database.
	 *
	 * @param dialogId the primary key for the new dialog
	 * @return the new dialog
	 */
	@Override
	public Dialog create(long dialogId) {
		Dialog dialog = new DialogImpl();

		dialog.setNew(true);
		dialog.setPrimaryKey(dialogId);

		return dialog;
	}

	/**
	 * Removes the dialog with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dialogId the primary key of the dialog
	 * @return the dialog that was removed
	 * @throws NoSuchDialogException if a dialog with the primary key could not be found
	 */
	@Override
	public Dialog remove(long dialogId) throws NoSuchDialogException {
		return remove((Serializable)dialogId);
	}

	/**
	 * Removes the dialog with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dialog
	 * @return the dialog that was removed
	 * @throws NoSuchDialogException if a dialog with the primary key could not be found
	 */
	@Override
	public Dialog remove(Serializable primaryKey) throws NoSuchDialogException {
		Session session = null;

		try {
			session = openSession();

			Dialog dialog = (Dialog)session.get(DialogImpl.class, primaryKey);

			if (dialog == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDialogException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(dialog);
		}
		catch (NoSuchDialogException nsee) {
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
	protected Dialog removeImpl(Dialog dialog) {
		dialog = toUnwrappedModel(dialog);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dialog)) {
				dialog = (Dialog)session.get(DialogImpl.class,
						dialog.getPrimaryKeyObj());
			}

			if (dialog != null) {
				session.delete(dialog);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (dialog != null) {
			clearCache(dialog);
		}

		return dialog;
	}

	@Override
	public Dialog updateImpl(Dialog dialog) {
		dialog = toUnwrappedModel(dialog);

		boolean isNew = dialog.isNew();

		Session session = null;

		try {
			session = openSession();

			if (dialog.isNew()) {
				session.save(dialog);

				dialog.setNew(false);
			}
			else {
				dialog = (Dialog)session.merge(dialog);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		entityCache.putResult(DialogModelImpl.ENTITY_CACHE_ENABLED,
			DialogImpl.class, dialog.getPrimaryKey(), dialog, false);

		dialog.resetOriginalValues();

		return dialog;
	}

	protected Dialog toUnwrappedModel(Dialog dialog) {
		if (dialog instanceof DialogImpl) {
			return dialog;
		}

		DialogImpl dialogImpl = new DialogImpl();

		dialogImpl.setNew(dialog.isNew());
		dialogImpl.setPrimaryKey(dialog.getPrimaryKey());

		dialogImpl.setDialogId(dialog.getDialogId());
		dialogImpl.setTopic(dialog.getTopic());
		dialogImpl.setCreatorMemberId(dialog.getCreatorMemberId());
		dialogImpl.setLastMessageDate(dialog.getLastMessageDate());
		dialogImpl.setLastMessageId(dialog.getLastMessageId());
		dialogImpl.setCreateDate(dialog.getCreateDate());
		dialogImpl.setCreatorUserId(dialog.getCreatorUserId());

		return dialogImpl;
	}

	/**
	 * Returns the dialog with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the dialog
	 * @return the dialog
	 * @throws NoSuchDialogException if a dialog with the primary key could not be found
	 */
	@Override
	public Dialog findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDialogException {
		Dialog dialog = fetchByPrimaryKey(primaryKey);

		if (dialog == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDialogException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return dialog;
	}

	/**
	 * Returns the dialog with the primary key or throws a {@link NoSuchDialogException} if it could not be found.
	 *
	 * @param dialogId the primary key of the dialog
	 * @return the dialog
	 * @throws NoSuchDialogException if a dialog with the primary key could not be found
	 */
	@Override
	public Dialog findByPrimaryKey(long dialogId) throws NoSuchDialogException {
		return findByPrimaryKey((Serializable)dialogId);
	}

	/**
	 * Returns the dialog with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dialog
	 * @return the dialog, or <code>null</code> if a dialog with the primary key could not be found
	 */
	@Override
	public Dialog fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(DialogModelImpl.ENTITY_CACHE_ENABLED,
				DialogImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Dialog dialog = (Dialog)serializable;

		if (dialog == null) {
			Session session = null;

			try {
				session = openSession();

				dialog = (Dialog)session.get(DialogImpl.class, primaryKey);

				if (dialog != null) {
					cacheResult(dialog);
				}
				else {
					entityCache.putResult(DialogModelImpl.ENTITY_CACHE_ENABLED,
						DialogImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(DialogModelImpl.ENTITY_CACHE_ENABLED,
					DialogImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return dialog;
	}

	/**
	 * Returns the dialog with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dialogId the primary key of the dialog
	 * @return the dialog, or <code>null</code> if a dialog with the primary key could not be found
	 */
	@Override
	public Dialog fetchByPrimaryKey(long dialogId) {
		return fetchByPrimaryKey((Serializable)dialogId);
	}

	@Override
	public Map<Serializable, Dialog> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Dialog> map = new HashMap<Serializable, Dialog>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Dialog dialog = fetchByPrimaryKey(primaryKey);

			if (dialog != null) {
				map.put(primaryKey, dialog);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(DialogModelImpl.ENTITY_CACHE_ENABLED,
					DialogImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Dialog)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_DIALOG_WHERE_PKS_IN);

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

			for (Dialog dialog : (List<Dialog>)q.list()) {
				map.put(dialog.getPrimaryKeyObj(), dialog);

				cacheResult(dialog);

				uncachedPrimaryKeys.remove(dialog.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(DialogModelImpl.ENTITY_CACHE_ENABLED,
					DialogImpl.class, primaryKey, nullModel);
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
	 * Returns all the dialogs.
	 *
	 * @return the dialogs
	 */
	@Override
	public List<Dialog> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Dialog> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Dialog> findAll(int start, int end,
		OrderByComparator<Dialog> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Dialog> findAll(int start, int end,
		OrderByComparator<Dialog> orderByComparator, boolean retrieveFromCache) {
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

		List<Dialog> list = null;

		if (retrieveFromCache) {
			list = (List<Dialog>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_DIALOG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DIALOG;

				if (pagination) {
					sql = sql.concat(DialogModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Dialog>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Dialog>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the dialogs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Dialog dialog : findAll()) {
			remove(dialog);
		}
	}

	/**
	 * Returns the number of dialogs.
	 *
	 * @return the number of dialogs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DIALOG);

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
		return DialogModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the dialog persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(DialogImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_DIALOG = "SELECT dialog FROM Dialog dialog";
	private static final String _SQL_SELECT_DIALOG_WHERE_PKS_IN = "SELECT dialog FROM Dialog dialog WHERE dialogId IN (";
	private static final String _SQL_COUNT_DIALOG = "SELECT COUNT(dialog) FROM Dialog dialog";
	private static final String _ORDER_BY_ENTITY_ALIAS = "dialog.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Dialog exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(DialogPersistenceImpl.class);
}