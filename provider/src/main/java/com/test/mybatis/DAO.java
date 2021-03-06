package com.test.mybatis;

import java.util.List;
import java.util.Map;

/**
 * The central class for working with SQL Maps.
 * 
 * @version 1.0,2013-07-08
 */
public interface DAO {

	/**
	 * Executes a mapped SQL INSERT statement. Insert is a bit different from
	 * other update methods, as it provides facilities for returning the primary
	 * key of the newly inserted row (rather than the effected rows). This
	 * functionality is of course optional.
	 * <p/>
	 * The parameter object is generally used to supply the input data for the
	 * INSERT values.
	 * 
	 * @param id
	 *            The name of the statement to execute.
	 * @param parameterObject
	 *            The parameter object (e.g. JavaBean, Map, XML etc.).
	 * @return The primary key of the newly inserted row. This might be
	 *         automatically generated by the RDBMS, or selected from a sequence
	 *         table or other source.
	 * @throws Exception
	 *             If an error occurs.
	 */
	public Object insert(String statement, Object parameterObject)
			throws Exception;

	/**
	 * Executes a mapped SQL INSERT statement. Insert is a bit different from
	 * other update methods, as it provides facilities for returning the primary
	 * key of the newly inserted row (rather than the effected rows). This
	 * functionality is of course optional.
	 * <p/>
	 * This overload assumes no parameter is needed.
	 * 
	 * @param id
	 *            The name of the statement to execute.
	 * @return The primary key of the newly inserted row. This might be
	 *         automatically generated by the RDBMS, or selected from a sequence
	 *         table or other source.
	 * @throws Exception
	 *             If an error occurs.
	 */
	public Object insert(String statement) throws Exception;

	/**
	 * Executes a mapped SQL UPDATE statement. Update can also be used for any
	 * other update statement type, such as inserts and deletes. Update returns
	 * the number of rows effected.
	 * <p/>
	 * The parameter object is generally used to supply the input data for the
	 * UPDATE values as well as the WHERE clause parameter(s).
	 * 
	 * @param id
	 *            The name of the statement to execute.
	 * @param parameterObject
	 *            The parameter object (e.g. JavaBean, Map, XML etc.).
	 * @return The number of rows effected.
	 * @throws Exception
	 *             If an error occurs.
	 */
	public int update(String statement, Object parameterObject)
			throws Exception;

	/**
	 * Executes a mapped SQL UPDATE statement. Update can also be used for any
	 * other update statement type, such as inserts and deletes. Update returns
	 * the number of rows effected.
	 * <p/>
	 * This overload assumes no parameter is needed.
	 * 
	 * @param id
	 *            The name of the statement to execute.
	 * @return The number of rows effected.
	 * @throws Exception
	 *             If an error occurs.
	 */
	public int update(String statement) throws Exception;

	/**
	 * Executes a mapped SQL DELETE statement. Delete returns the number of rows
	 * effected.
	 * <p/>
	 * The parameter object is generally used to supply the input data for the
	 * WHERE clause parameter(s) of the DELETE statement.
	 * 
	 * @param id
	 *            The name of the statement to execute.
	 * @param parameterObject
	 *            The parameter object (e.g. JavaBean, Map, XML etc.).
	 * @return The number of rows effected.
	 * @throws Exception
	 *             If an error occurs.
	 */
	public int delete(String statement, Object parameterObject)
			throws Exception;

	/**
	 * Executes a mapped SQL DELETE statement. Delete returns the number of rows
	 * effected.
	 * <p/>
	 * This overload assumes no parameter is needed.
	 * 
	 * @param id
	 *            The name of the statement to execute.
	 * @return The number of rows effected.
	 * @throws Exception
	 *             If an error occurs.
	 */
	public int delete(String statement) throws Exception;

	/**
	 * Executes a mapped SQL SELECT statement that returns data to populate a
	 * single object instance.
	 * <p/>
	 * This overload assumes no parameter is needed.
	 * 
	 * @param id
	 *            The name of the statement to execute.
	 * @return The single result object populated with the result set data, or
	 *         null if no result was found
	 * @throws Exception
	 *             If more than one result was found, or if any other error
	 *             occurs.
	 */
	public Object queryForObject(String statement) throws Exception;

	/**
	 * Executes a mapped SQL SELECT statement that returns data to populate the
	 * supplied result object.
	 * <p/>
	 * The parameter object is generally used to supply the input data for the
	 * WHERE clause parameter(s) of the SELECT statement.
	 * 
	 * @param id
	 *            The name of the statement to execute.
	 * @param parameterObject
	 *            The parameter object (e.g. JavaBean, Map, XML etc.).
	 * @param resultObject
	 *            The result object instance that should be populated with
	 *            result data.
	 * @return The single result object as supplied by the resultObject
	 *         parameter, populated with the result set data, or null if no
	 *         result was found
	 * @throws Exception
	 *             If more than one result was found, or if any other error
	 *             occurs.
	 */
	public Object queryForObject(String statement, Object parameterObject)
			throws Exception;

	/**
	 * Executes a mapped SQL SELECT statement that returns data to populate a
	 * number of result objects.
	 * <p/>
	 * The parameter object is generally used to supply the input data for the
	 * WHERE clause parameter(s) of the SELECT statement.
	 * 
	 * @param id
	 *            The name of the statement to execute.
	 * @param parameterObject
	 *            The parameter object (e.g. JavaBean, Map, XML etc.).
	 * @return A List of result objects.
	 * @throws Exception
	 *             If an error occurs.
	 */
	public List<?> queryForList(String statement, Object parameterObject,
			int offset, int limit) throws Exception;

	/**
	 * Executes a mapped SQL SELECT statement that returns data to populate a
	 * number of result objects.
	 * <p/>
	 * The parameter object is generally used to supply the input data for the
	 * WHERE clause parameter(s) of the SELECT statement.
	 * 
	 * @param id
	 *            The name of the statement to execute.
	 * @param parameterObject
	 *            The parameter object (e.g. JavaBean, Map, XML etc.).
	 * @return A List of result objects.
	 * @throws Exception
	 *             If an error occurs.
	 */
	public List<?> queryForList(String statement, Object parameterObject)
			throws Exception;

	/**
	 * Retrieves the number,types and properties of this ResultSet object's
	 * column
	 * 
	 * @param sql
	 * @return
	 */
	public List<Map<String, Object>> getMetaDataLimits(String tableName)
			throws Exception;

}
