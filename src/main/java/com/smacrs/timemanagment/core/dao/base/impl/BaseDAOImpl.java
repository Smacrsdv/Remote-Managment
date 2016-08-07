package com.smacrs.timemanagment.core.dao.base.impl;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.TypedQuery;

import org.hibernate.HibernateException;

import com.smacrs.timemanagment.core.dao.base.BaseDAO;
import com.smacrs.timemanagment.core.entities.BaseEntity;

/*
 * @author Karim Sherif
 * karimsherif@karimsherif.com
 */
//@Repository("BaseDAO")
@SuppressWarnings("all")
public class BaseDAOImpl implements BaseDAO, Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext
	public EntityManager em;

	@Override
	public <T extends BaseEntity> void addEntity(T entity) {
		try {
			em.persist(entity);
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new HibernateException(e);
		}
	}

	@Override
	public <T extends BaseEntity> T updateEntity(T entity) {
		try {
			return em.merge(entity);
		} catch (Exception e) {
			e.printStackTrace();
			throw new HibernateException(e);
		}
	}

	@Override
	public void removeEntity(String namedQueryName, Map<String, Object> params) {
		try {
			Query query = em.createNamedQuery(namedQueryName);
			if (params != null) {
				addPrametersToQuery(query, params);
			}
			query.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new HibernateException(e);
		}
	}

	@Override
	public <T extends Object> List<T> getResultList(String namedQueryName) {
		try {
			return getResultList(namedQueryName, null);
		} catch (Exception e) {
			e.printStackTrace();
			throw new HibernateException(e);
		}
	}

	@Override
	public <T extends Object> List<T> getResultList(String namedQueryName, Map<String, Object> params) {
		List<T> results = null;
		try {
			results = (List<T>) executeNamedQuery(namedQueryName, params);
		} catch (Exception e) {
			e.printStackTrace();
			throw new HibernateException(e);
		}
		return results;
	}

	@Override
	public <T extends Object> T getSingleResultObject(String namedQueryName, Map<String, Object> params) {
		T result = null;
		try {
			result = (T) executeNamedQueryWithSingleResult(namedQueryName, params);
		} catch (Exception e) {
			e.printStackTrace();
			// return null;
			throw new HibernateException(e);
		}
		return result;
	}

	public <T extends Object> T getSingleResultObject(String namedQueryName) {
		try {
			return getSingleResultObject(namedQueryName, null);
		} catch (Exception e) {
			e.printStackTrace();
			throw new HibernateException(e);
		}
	}

	// private static final String ALIAS = "x";

	// @Value("${hibernate.jdbc.batch_size}")
	// private int batchSize = 20;

	public <T> List<T> executeJPQL(String jpqlStmt, Map<Integer, Object> map, Class<T> c) {
		TypedQuery<T> q = em.createQuery(jpqlStmt, c);
		if (map != null)
			for (Integer key : map.keySet())
				q.setParameter(key, map.get(key));
		return q.getResultList();
	}

	public <T> List<T> executeJPQLString(String jpqlStmt, Map<String, Object> map, Class<T> c) {
		TypedQuery<T> q = em.createQuery(jpqlStmt, c);
		if (map != null)
			for (String key : map.keySet())
				q.setParameter(key, map.get(key));
		return q.getResultList();
	}

	public <T> List<T> executeJPQLString(String jpqlStmt, Map<String, Object> map, Class<T> c, int startPosition,
			int maxResult) {
		TypedQuery<T> q = em.createQuery(jpqlStmt, c);
		if (map != null)
			for (String key : map.keySet())
				q.setParameter(key, map.get(key));

		q.setFirstResult(startPosition);
		q.setMaxResults(maxResult);
		return q.getResultList();
	}

	public <T> T executeJPQLWithSingleResult(String jpqlStmt, Map<Integer, Object> map, Class<T> c) {
		TypedQuery<T> q = em.createQuery(jpqlStmt, c);
		if (map != null)
			for (Integer key : map.keySet())
				q.setParameter(key, map.get(key));
		return q.getSingleResult();
	}

	public <T extends BaseEntity> List<T> getEntityList(Class<T> clazz, String orderBy) {
		try {
			StringBuffer queryString = new StringBuffer("select o from ").append(clazz.getSimpleName()).append(" o ");
			if (orderBy != null && !orderBy.trim().equals("")) {
				queryString.append(" order by o.").append(orderBy);
			}
			// System.out.println("getEntityList : " + clazz);
			// System.out.println(em);
			Query query = em.createQuery(queryString.toString());
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public <T extends BaseEntity> List<Long> getEntityRecidList(Class<T> clazz) {
		try {
			StringBuffer queryString = new StringBuffer("select o.id from ").append(clazz.getSimpleName())
					.append(" o ");
			Query query = em.createQuery(queryString.toString());
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public <T extends BaseEntity> List<T> getEntityList(Class<T> clazz, int firstResult, int maxResults) {
		try {
			Query query = em.createQuery("select o from " + clazz.getSimpleName() + " o ");
			query.setFirstResult(firstResult);
			query.setMaxResults(maxResults);
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// public <T extends Object> List<T> getResultList(CriteriaQuery<T>
	// criteriaQuery) {
	// List<T> results = null;
	// try {
	// results = em.createQuery(criteriaQuery).getResultList();
	// } catch (Exception e) {
	// e.printStackTrace();
	// return null;
	// }
	// return results;
	// }

	// public CriteriaBuilder getCriteriaBuilder() {
	// try {
	// return em.getCriteriaBuilder();
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return null;
	// }

	public <T extends BaseEntity> T getEntity(Class<T> clazz, Integer id) {
		try {
			return (T) em.find(clazz, id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public <T extends BaseEntity> T getEntityReference(Class<T> clazz, Integer id) {
		try {
			return (T) em.getReference(clazz, id);
		} catch (Exception e) {
			return null;
		}
	}

	public <T extends BaseEntity> void refresh(T entity) {
		try {
			em.refresh(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public <T extends BaseEntity> List<T> getEntityList(Class<T> clazz, String paramName, Object value,
			String orderBy) {
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("paramName", value);
			StringBuffer queryString = new StringBuffer("select o from ").append(clazz.getSimpleName())
					.append(" o where o.").append(paramName).append("=:").append("paramName");
			if (orderBy != null && !orderBy.trim().equals("")) {
				queryString.append(" order by o.").append(orderBy);
			}
			return this.executeQuery(queryString.toString(), params);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public <T extends BaseEntity> T getEntity(Class<T> clazz, String paramName, Object value) {
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("paramName", value);
			return (T) this.executeQueryWithSingleResult(
					new StringBuffer("select o from ").append(clazz.getSimpleName()).append(" o where o.")
							.append(paramName).append("=:").append("paramName").toString(),
					params);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public <T extends BaseEntity> T getEntity(Class<T> clazz, Map<String, Object> params) {
		try {
			// Map<String, Object> params = new HashMap<String, Object>();
			// params.put("paramName", value);
			return (T) this.executeQueryWithSingleResult(
					new StringBuffer("select o from o").append(clazz.getSimpleName()).append(" o ").toString(), params);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public <T extends BaseEntity> void removeEntity(Class<T> clazz, Integer entityId) {
		try {

			this.executeUpdateQuery(new StringBuffer("delete from ").append(clazz.getSimpleName())
					.append(" o where o.id=").append(entityId).toString(), null);
		} catch (Exception e) {

		}
	}

	public <T extends BaseEntity> void removeEntity(Class<T> clazz, String paramName, Object value) {

		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("paramName", value);

			this.executeUpdateQuery(new StringBuffer("delete from ").append(clazz.getSimpleName()).append(" o where o.")
					.append(paramName).append("=:").append("paramName").toString(), params);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public <T extends BaseEntity> Integer executeUpdate(String namedQueryName, Map<String, Object> params) {
		Integer result = null;
		try {
			// namedQueryFootPrint(namedQueryName, params);
			Query query = em.createNamedQuery(namedQueryName);
			if (params != null) {
				addPrametersToQuery(query, params);
			}
			result = query.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return result;
	}

	private <T extends BaseEntity> Integer executeUpdateQuery(String queryString, Map<String, Object> params) {
		Integer result = null;
		try {
			Query query = em.createQuery(queryString);
			if (params != null) {
				addPrametersToQuery(query, params);
			}
			result = query.executeUpdate();
			// namedQueryFootPrint(queryString, params);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return result;
	}

	public <T extends Object> List<T> executeNativeQuery(String queryString, Map<String, Object> params,
			Class<T> clazz) {
		List<T> result = null;
		try {
			Query query = null;
			if (clazz != null) {
				query = em.createNativeQuery(queryString, clazz);
			} else {
				query = em.createNativeQuery(queryString);
			}
			if (params != null) {
				addPrametersToQuery(query, params);
			}
			result = (List<T>) query.getResultList();
		} catch (NoResultException e) {
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return result;
	}

	private <T extends Object> List<T> executeQuery(String queryString, Map<String, Object> queryParams) {
		List<T> results = null;
		try {
			Query query = em.createQuery(queryString);
			if (queryParams != null) {
				addPrametersToQuery(query, queryParams);
			}
			results = query.getResultList();
		} catch (NoResultException e) {
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return results;
	}

	private <T extends Object> T executeQueryWithSingleResult(String queryString, Map<String, Object> queryParams) {
		T result = null;
		try {
			Query query = em.createQuery(queryString);
			if (queryParams != null) {
				addPrametersToQuery(query, queryParams);
			}
			result = (T) query.getSingleResult();
		} catch (NoResultException e) {
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return result;
	}

	private <T extends Object> List<T> executeNamedQuery(String namedQueryName, Map<String, Object> queryParams) {
		List<T> results = null;
		try {
			Query query = em.createNamedQuery(namedQueryName);
			if (queryParams != null) {
				addPrametersToQuery(query, queryParams);
			}
			results = query.getResultList();
		} catch (NoResultException e) {
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return results;
	}

	private <T extends Object> T executeNamedQueryWithSingleResult(String namedQueryName,
			Map<String, Object> queryParams) {
		T result = null;
		try {
			Query query = em.createNamedQuery(namedQueryName);
			if (queryParams != null) {
				addPrametersToQuery(query, queryParams);
			}
			result = (T) query.getSingleResult();
		} catch (NoResultException e) {
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return result;
	}

	private Query addPrametersToQuery(Query query, Map<String, Object> queryParams) {
		if (queryParams != null) {
			Set<String> keys = queryParams.keySet();
			Iterator<String> keysIterator = keys.iterator();
			String key = null;
			while (keysIterator.hasNext()) {
				key = keysIterator.next();
				query.setParameter(key, queryParams.get(key));
			}
		}
		return query;
	}

	// public <T extends Object> T getSingleResultObject(CriteriaQuery<T>
	// criteriaQuery) {
	// T result = null;
	// try {
	// Query query = this.createQuery(criteriaQuery);
	// result = (T) query.getSingleResult();
	// } catch (NoResultException e) {
	// } catch (Exception e) {
	// e.printStackTrace();
	// return null;
	// }
	// return result;
	// }

	// public <T extends Object> Query createQuery(CriteriaQuery<T>
	// criteriaQuery) {
	// return em.createQuery(criteriaQuery);
	// }

	private Boolean hasTransientAnnotation(Field field) {
		Transient trans = field.getAnnotation(Transient.class);
		if (trans != null)
			return true;

		return false;
	}

	private <T extends BaseEntity> Method getMethod(T entity, String methodName)
			throws SecurityException, NoSuchMethodException {

		Method method = null;
		Class entityClass = entity.getClass();

		method = entity.getClass().getMethod(methodName, null);

		return method;
	}

	private String getExpectedMethodName(Field field) {

		String fieldName = field.getName();
		char ch = fieldName.charAt(0);
		char[] nameAsChar = fieldName.toCharArray();

		String methodPrefix = "get";
		nameAsChar[0] = Character.toUpperCase(ch);
		fieldName = new String(nameAsChar);

		String name = field.getType().getSimpleName();
		// System.out.println(name);
		if (field.getType().getSimpleName().equals("boolean"))
			methodPrefix = "is";

		String methodName = methodPrefix + fieldName;

		return methodName;
	}

	// private <T extends BaseEntity> String getMethodVal(Field field, T entity)
	// {
	//
	// String val = null;
	// String methodName = getExpectedMethodName(field);
	// try {
	// // Method method = getMethod(entity, methodName);
	// field.setAccessible(true);
	// Object result = field.get(entity); // method.invoke(entity, null);
	// if (result instanceof BaseEntity) {
	// result = ((BaseEntity) result);
	// if (result != null && !isLazy(field))
	// val = ((BaseEntity) result).getId().toString();
	// } else if (result instanceof Date) {
	// Date tempDate = (Date) result;
	// val = tempDate.getDay() + "-" + tempDate.getMonth() + "-" +
	// tempDate.getYear();
	// } else if (result != null) {
	// val = result.toString();
	// }
	// } catch (Exception ex) {
	// ex.printStackTrace();
	// }
	// if (val == null)
	// return "";
	// else
	// return val;
	// }

	private Boolean isLazy(Field field) {
		ManyToOne manyToOne = field.getAnnotation(ManyToOne.class);
		if (manyToOne != null && manyToOne.fetch() == FetchType.LAZY)
			return true;

		return false;
	}

	private String getColumnName(Field field) {
		Column col = field.getAnnotation(Column.class);
		if (col != null && col.name() != null && !col.name().isEmpty())
			return col.name();

		return field.getName();
	}

	private String getTableName(Class entityClass) {
		Table table = (Table) entityClass.getAnnotation(Table.class);
		return table.name();
	}

	/**
	 * This method used to parsing hql statement to get fields from it and
	 * parameterId for each field
	 * 
	 * @param baseEntity
	 *            base entity to get field from it
	 * @param updateFields
	 *            String that parsing it and must has syntax like(SET
	 *            alias.entityfield=:val)
	 * @return map
	 * @throws Exception
	 *             if any run time Exception occur
	 */
	private Map<Field, String> getNamedQueryFields(BaseEntity baseEntity, String updateFields) throws Exception {

		Map<Field, String> map = new HashMap<Field, String>();
		String[] fields = updateFields.split(",");
		String fieldName = null;
		Field field = null;
		String parameterName;
		for (String s : fields) {
			fieldName = s.split("=")[0];
			int len = fieldName.split("\\.").length;
			fieldName = len <= 1 ? fieldName.split("\\.")[0] : fieldName.split("\\.")[1];
			try {
				field = baseEntity.getClass().getDeclaredField(fieldName);
				parameterName = fieldName = s.split("=")[1];
				parameterName = parameterName.replace(":", "");
				map.put(field, parameterName);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return map;
	}

	/**
	 * This Method used to get entity simpleName from given query
	 * 
	 * @param query
	 *            query to get entity from it query syntax(Update entity r )
	 * @return empty String if not found or entity name
	 */
	private String entityName(String query) {
		String[] splitString = query.split(" ");
		int flag = 0;
		int cond = 0;
		if (isDeleteHql(query))
			cond = 2;
		if (isUpdateHql(query))
			cond = 1;

		for (String s : splitString) {
			if (!s.isEmpty() && flag == cond)
				return s;
			else if (!s.isEmpty())
				flag++;
		}
		return "";
	}

	// private String getUpdatedFieldVal(String keyName, Map<String, Object>
	// params) {
	// Object value = params.get(keyName);
	// if (value instanceof BaseEntity)
	// return ((BaseEntity) value).getId().toString();
	// else if (value != null)
	// return value.toString();
	// else
	// return keyName;
	// }

	private <T extends BaseEntity> List<T> getEntities(String query, T entity, Map<String, Object> params) {
		List<T> list = null;
		StringBuilder sb = new StringBuilder();
		String condition = null;
		String[] str = null;
		String updateQuery = null;
		String aliasName = null;
		str = query.split(" WHERE ");
		updateQuery = str[0];
		updateQuery = updateQuery.split(" SET ")[0];
		if (str.length > 1)
			condition = str[1];

		str = updateQuery.split(" * ");
		if (isDeleteHql(query))
			aliasName = str[3];
		else
			aliasName = str[2];

		updateQuery = updateQuery.replaceFirst("UPDATE ", " ");
		sb.append("select ").append(aliasName).append(" from ").append(entity.getClass().getSimpleName()).append("  ")
				.append(aliasName);
		if (condition != null)
			sb.append(" WHERE ").append(condition);

		list = executeQuery(sb.toString(), getRequiredParameter(params, sb.toString()));

		return list;
	}

	/**
	 * This method used to check if hql is updated hql or not
	 * 
	 * @param hql
	 * @return true it's updated hql false if otherwise
	 */
	private Boolean isUpdateHql(String hql) {
		if (hql.contains("UPDATE "))
			return true;

		return false;
	}

	/**
	 * This method used to check if hql is delete hql or not
	 * 
	 * @param hql
	 * @return true it's delete hql false if otherwise
	 */
	private Boolean isDeleteHql(String hql) {
		if (hql.contains("delete "))
			return true;

		return false;
	}

	/**
	 * This method used to get required paramter for select statement from
	 * original param map
	 * 
	 * @param oldParams
	 * @param query
	 * @return
	 */
	private Map<String, Object> getRequiredParameter(Map<String, Object> oldParams, String query) {

		Map<String, Object> result = new HashMap<String, Object>();
		String key = null;
		Set<String> keys = oldParams.keySet();
		Iterator<String> keysIterator = keys.iterator();

		while (keysIterator.hasNext()) {
			key = keysIterator.next();
			if (query.contains(":" + key))
				result.put(key, oldParams.get(key));

		}
		return result;
	}

	// /////////////////// --------- /////////
	public static <T> List<T> map(Class<T> type, List<Object[]> records) {
		List<T> result = new LinkedList<T>();
		for (Object[] record : records) {
			result.add(map(type, record));
		}
		return result;
	}

	public static <T> T map(Class<T> type, Object[] tuple) {
		// Object[] tuple2 = new Object[tuple.length];
		List<Class<?>> tupleTypes = new ArrayList<Class<?>>();

		// for (Object field : tuple) {
		for (int i = 0; i < tuple.length; i++) {
			// if (tuple[i]==null){
			// tupleTypes.add(
			// }
			if (tuple[i].getClass().equals(java.math.BigInteger.class)
					|| tuple[i].getClass().equals(java.lang.Integer.class)) {
				tuple[i] = Long.parseLong(tuple[i] + "");
				// tuple2[i] = Long.parseLong(tuple[i] + "");
				tupleTypes.add(Long.class);
			} else {
				// tuple2[i] = tuple[i];
				tupleTypes.add(tuple[i].getClass());
			}
		}
		try {
			Constructor<T> ctor = type.getConstructor(tupleTypes.toArray(new Class<?>[tuple.length]));
			return ctor.newInstance(tuple);
			// return ctor.newInstance(tuple2);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// ///////////////////////////////////////////////////////////////////////

	/**
	 * This method used to build dynamic query parameters based on the provided
	 * search criteria
	 * 
	 * @param query
	 *            The base native query with the required joins between tables
	 * @param searchCriteria
	 *            The object that holds the query filter (search criteria
	 *            parameters)
	 * @param entityClass
	 *            The entity type of the returned result
	 * @return list of entities.
	 * @author ibrahim.ahmed (ibrahimahmed.fci@gmail.com) fell free to contact
	 *         me for any improvements.
	 * @Example: StaffAffairsDao.getStaffMembers
	 */
	// @Override
	// public <T extends BaseEntity> List<T> getResultList(
	// StringBuilder queryString, SearchCriteria searchCriteria,
	// Class entityClass) {
	//
	// Map<String, Object> searchParams = searchCriteria.getSearchParams();
	// Query query = buildQuery(queryString, searchParams, entityClass);
	//
	// if (null != searchCriteria.getFirstResult()
	// && searchCriteria.getFirstResult() > 0) {
	// query.setFirstResult(searchCriteria.getFirstResult());
	// }
	//
	// if (null != searchCriteria.getMaxResults()
	// && searchCriteria.getMaxResults() > 0)
	// query.setMaxResults(searchCriteria.getMaxResults());
	//
	// return query.getResultList();
	// }

	/**
	 * This method used to build dynamic query parameters based on the provided
	 * search criteria
	 * 
	 * @param query
	 *            The base native query with the required joins between tables
	 * @param searchCriteria
	 *            The object that holds the query filter (search criteria
	 *            parameters)
	 * @param entityClass
	 *            The entity type of the returned result
	 * @return list of entities.
	 * @author ibrahim.ahmed (ibrahimahmed.fci@gmail.com) fell free to contact
	 *         me for any improvements.
	 * @Example: StaffAffairsDao.getStaffMembers
	 */
	// @Override
	// public <T extends BaseEntity> List<T> getResultList(
	// StringBuilder queryString, Integer firstResult, Integer maxResults,
	// Map<String, Object> paramsFilter, Class entityClass) {
	//
	// Query query = buildQuery(queryString, paramsFilter, entityClass);
	//
	// if (null != firstResult && firstResult > 0) {
	// query.setFirstResult(firstResult);
	// }
	//
	// if (null != maxResults && maxResults > 0)
	// query.setMaxResults(maxResults);
	//
	// return query.getResultList();
	// }

	// private Query buildQuery(StringBuilder queryString, Map<String, Object>
	// paramsFilter, Class entityClass) {
	// Set<String> keys = paramsFilter.keySet();
	// for (String param : keys) {
	// if (null != paramsFilter.get(param)) {
	// if (null == ColumnMapping.columnMap.get(param))
	// throw new DBException();
	// queryString.append(" and ").append(ColumnMapping.columnMap.get(param));
	// if (paramsFilter.get(param) instanceof String &&
	// paramsFilter.get(param).toString().contains("%"))
	// queryString.append(" like :");
	// else
	// queryString.append(" = :");
	//
	// queryString.append(param);
	// }
	// }
	//
	// Query query = em.createNativeQuery(queryString.toString(), entityClass);
	//
	// for (String param : keys) {
	// if (null != paramsFilter.get(param)) {
	// query.setParameter(param, paramsFilter.get(param));
	// }
	// }
	//
	// return query;
	// }

	// private Query buildQuery(StringBuilder queryString, Map<String, Object>
	// paramsFilter) {
	// Set<String> keys = paramsFilter.keySet();
	// for (String param : keys) {
	// if (null != paramsFilter.get(param)) {
	// if (null == ColumnMapping.columnMap.get(param))
	// throw new DBException();
	// queryString.append(" and ").append(ColumnMapping.columnMap.get(param));
	// if (paramsFilter.get(param) instanceof String &&
	// paramsFilter.get(param).toString().contains("%"))
	// queryString.append(" like :");
	// else
	// queryString.append(" = :");
	//
	// queryString.append(param);
	// }
	// }
	//
	// Query query = em.createNativeQuery(queryString.toString());
	//
	// for (String param : keys) {
	// if (null != paramsFilter.get(param)) {
	// query.setParameter(param, paramsFilter.get(param));
	// }
	// }
	//
	// return query;
	// }

	// @Override
	// public Integer getCountOfResults(StringBuilder queryString,
	// SearchCriteria searchCriteria) {
	// Query query = buildQuery(queryString, searchCriteria.getSearchParams());
	// java.math.BigInteger count = (java.math.BigInteger)
	// query.getSingleResult();
	// return count.intValue();
	// }
	//
	// @Override
	// public Integer getCountOfResults(StringBuilder queryString, Map<String,
	// Object> paramsFilter) {
	// Query query = buildQuery(queryString, paramsFilter);
	// java.math.BigInteger count = (java.math.BigInteger)
	// query.getSingleResult();
	// return count.intValue();
	// }
	//
	// @Override
	// public <T extends BaseEntity> void saveBatch(List<T> entities) {
	//
	// for (int i = 0; i < entities.size(); i++) {
	// em.persist(entities.get(i));
	// if ((i % batchSize) == 0) {
	// em.flush();
	// em.clear();
	// }
	// }
	// }
	//
	// @Override
	// public <T extends BaseEntity> void updateBatch(List<T> entities) {
	//
	// for (int i = 0; i < entities.size(); i++) {
	// em.merge(entities.get(i));
	// if ((i % batchSize) == 0) {
	// em.flush();
	// em.clear();
	// }
	// }
	// }

	// public CriteriaBuilder getCriteriaBuilder() {
	// try {
	// return em.getCriteriaBuilder();
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return null;
	// }
	//
	// public <T extends Object> Query createQuery(CriteriaQuery<T>
	// criteriaQuery) {
	// return em.createQuery(criteriaQuery);
	// }

	@Override
	public void flush() {
		em.flush();
	}

	/**
	 * add Or Update added by Mahmoud orcl
	 * 
	 * @param selectedExam
	 * @return
	 * @return
	 */
	public <T extends BaseEntity> T merge(T entity) {
		try {
			return em.merge(entity);
		} catch (HibernateException e) {

			throw new HibernateException(e);
		}
	}

	// public Query prepareLazyFetchingQuery(Class clz, boolean isCount, String
	// sortField, boolean assending,
	// Map<String, Object> filters) {
	// StringBuilder stringBuilder = new StringBuilder();
	//
	// StringBuilder queryBuilder = new StringBuilder();
	// if (isCount) {
	// stringBuilder.append(String.format("select count( o ) from %s o where 1=1
	// ", clz.getCanonicalName()));
	// } else {
	// stringBuilder.append(String.format("select o from %s o where 1=1 ",
	// clz.getCanonicalName()));
	// }
	// int counter = 1;
	// Map<String, Object> queryParams = new LinkedHashMap<String, Object>();
	//
	// for (String field : filters.keySet()) {
	// Object filterValue = filters.get(field);
	// Class fieldClass = Utils.getFilterClass(field, clz);
	// String alias = null;
	// alias = Utils.dublicate(ALIAS, counter++);
	//
	// if ((filterValue instanceof QueryConditionHolder) == false) {
	// if (fieldClass == String.class) {
	// stringBuilder.append(
	// String.format("and lower( o.%s ) like lower( CONCAT( :%s ,'%s') ) ",
	// field, alias, "%"));
	//
	// queryParams.put(alias, ((String) filterValue).trim());
	//
	// } else if (Utils.isPrimitiveDataType(fieldClass)) {
	// if (Utils.isAString(filterValue)) {
	// Object object = Utils.initiatePrimitiveObject(fieldClass, (String)
	// filterValue);
	// stringBuilder.append(String.format(" and o.%s =:%s ", field, alias));
	// queryParams.put(alias, object);
	// }
	// } else if (fieldClass == Date.class) {
	// String secondAlias = Utils.dublicate(alias, ++counter);
	// stringBuilder.append(
	// String.format(" and o.%s >= :%s and o.%s <= :%s ", field, alias, field,
	// secondAlias));
	// Date startDate = Utils.getStartOfDay((Date) filterValue);
	// Date endDate = Utils.getEndOfDay((Date) filterValue);
	// queryParams.put(alias, startDate);
	// queryParams.put(secondAlias, endDate);
	// } else {
	// stringBuilder.append(String.format(" and o.%s =:%s ", field, alias));
	// queryParams.put(alias, filters.get(field));
	// }
	// } else {
	// String condition = ((QueryConditionHolder) (filterValue)).getCondition();
	// stringBuilder.append(String.format(" and o.%s %s ", field, condition));
	//
	// }
	// }
	//
	// if (Utils.isNotEmpty(sortField)) {
	// stringBuilder.append(String.format(" order by %s %s", sortField,
	// assending == false ? "desc " : ""));
	// }
	// Query query = em.createQuery(stringBuilder.toString());
	//
	// for (String alia : queryParams.keySet()) {
	//
	// query.setParameter(alia, queryParams.get(alia));
	//
	// }
	// return query;
	//
	// }

	// public Integer getCountOfQueryResults(Class clz, Map<String, Object>
	// filters) {
	//
	// Query query = prepareLazyFetchingQuery(clz, true, null, false, filters);
	// Object result = query.getResultList().get(0);
	// if (Utils.isNotEmpty(result)) {
	// return new Integer(String.valueOf(result));
	// } else {
	// return 0;
	// }
	// }
	//
	// public List loadQueryResult(Class clz, int first, int pageSize, String
	// sortField, boolean accending,
	// Map<String, Object> filters) {
	// Query query = prepareLazyFetchingQuery(clz, false, sortField, accending,
	// filters);
	// return query.getResultList();
	// }

}
