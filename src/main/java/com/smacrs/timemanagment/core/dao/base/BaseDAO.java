package com.smacrs.timemanagment.core.dao.base;

import java.util.List;
import java.util.Map;

import com.smacrs.timemanagment.core.entities.BaseEntity;

/*
 * @author Karim Sherif
 * karimsherif@karimsherif.com
 */
public interface BaseDAO {

	public <T extends BaseEntity> void addEntity(T entity);

	public <T extends BaseEntity> T updateEntity(T entity);

	public <T extends Object> List<T> getResultList(String namedQueryName, Map<String, Object> params);

	public <T extends Object> List<T> getResultList(String namedQueryName);

	public <T extends Object> T getSingleResultObject(String namedQueryName, Map<String, Object> params);

	public <T extends Object> T getSingleResultObject(String namedQueryName);

	public void flush();

	public void removeEntity(String namedQueryName, Map<String, Object> params);

	// public <T extends BaseEntity> List<T> getEntityList(Class<T> clazz,
	// String orderBy);
	//
	// public <T extends BaseEntity> List<T> getEntityList(Class<T> clazz, int
	// firstResult, int maxResults);
	//
	// public <T extends BaseEntity> T getEntity(Class<T> clazz, Integer id);
	//
	// public <T extends BaseEntity> T getEntityReference(Class<T> clazz,
	// Integer id);
	//
	// public <T extends BaseEntity> void refresh(T entity);
	//
	// public <T extends BaseEntity> T getEntity(Class<T> clazz, String
	// paramName, Object value);
	//
	// public <T extends BaseEntity> List<T> getEntityList(Class<T> clazz,
	// String paramName, Object value, String orderBy);
	//
	// public <T extends BaseEntity> Integer executeUpdate(String
	// namedQueryName, Map<String, Object> params);
	//
	// public <T extends Object> List<T> executeNativeQuery(String queryString,
	// Map<String, Object> params,
	// Class<T> clazz);
	//
	// public <T extends BaseEntity> void removeEntity(Class<T> clazz, Integer
	// entityId);
	//
	// /**
	// * This method used to build dynamic query parameters based on the
	// provided
	// * search criteria
	// *
	// * @param query
	// * The base native query with the required joins between tables
	// * @param searchCriteria
	// * The object that holds the query filter (search criteria
	// * parameters)
	// * @param entityClass
	// * The entity type of the returned result
	// * @return list of entities.
	// * @author ibrahim.ahmed (ibrahimahmed.fci@gmail.com) fell free to contact
	// * me for any improvements.
	// * @Example: StaffAffairsDao.getStaffMembers
	// */
	// // public <T extends BaseEntity> List<T> getResultList(StringBuilder
	// // queryString, SearchCriteria searchCriteria,
	// // Class entityClass);
	//
	// /**
	// * This method used to build dynamic query parameters based on the
	// provided
	// * search criteria
	// *
	// * @param query
	// * The base native query with the required joins between tables
	// * @param firstResult
	// * the number of the row that will start fetching from it
	// * @param maxResults
	// * count of maximum results will be returned by this method, if
	// * null will return all
	// * @param paramsFilter
	// * The query filter (search criteria parameters)
	// * @param entityClass
	// * The entity type of the returned result
	// * @return list of entities.
	// * @author ibrahim.ahmed (ibrahimahmed.fci@gmail.com) fell free to contact
	// * me for any improvements.
	// * @Example: StaffAffairsDao.getStaffMembers
	// */
	// public <T extends BaseEntity> List<T> getResultList(StringBuilder
	// queryString, Integer firstResult,
	// Integer maxResults, Map<String, Object> paramsFilter, Class entityClass);
	//
	// // public Integer getCountOfResults(StringBuilder queryString,
	// // SearchCriteria searchCriteria);
	//
	// public Integer getCountOfResults(StringBuilder queryString, Map<String,
	// Object> paramsFilter);
	//
	// public <T extends BaseEntity> void saveBatch(List<T> entities);
	//
	// public <T extends BaseEntity> void updateBatch(List<T> entities);
	//
	// public void flush();
	//
	// /**
	// * @param institutionId
	// * @param depId
	// * @return
	// */

}
