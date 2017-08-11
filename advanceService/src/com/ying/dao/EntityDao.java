package com.ying.dao;

import java.sql.Clob;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.sql.DataSource;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springside.modules.orm.Page;
import org.springside.modules.orm.PropertyFilter;
import org.utils.SqlUtils;
import org.utils.StringUtils;

/**
 * entity dao
 * 
 * @author rjx
 */
@Repository
public class EntityDao {
	@Autowired
	private JdbcTemplate jt;

	private SimpleJdbcInsert inserActor;
	private static DataSource dataSource = null;

	public JdbcTemplate getJt() {
		return jt;
	}

	// 简化插入数据操作,返回id值
	public Long insert(Map<String, Object> parameters, String tableName) {
		dataSource = this.getJt().getDataSource();
		// Map<String, Object> parameters = new HashMap<String, Object>();
		// parameters.put("name", "郑州");
		Iterator iter = parameters.entrySet().iterator();
		String[] names = new String[parameters.size()];

		List<String> li = new ArrayList<String>();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			String key = (String) entry.getKey();
			li.add(key);
		}
		names = li.toArray(new String[li.size()]);
		this.inserActor = new SimpleJdbcInsert(dataSource)
				.withTableName(tableName).usingColumns(names)// 插入这些字段
				.usingGeneratedKeyColumns("id");// 带回生成的id
		long id=-1;
		try{
			id = inserActor.executeAndReturnKey(parameters).longValue();
			return id;
		}catch(Exception e){
			e.getStackTrace();
		}
		return id;
	}
	// 简化插入数据操作,返回指定id或其他字段值idName
		public Long insert(Map<String, Object> parameters, String tableName,String idName) {
			dataSource = this.getJt().getDataSource();
			Iterator iter = parameters.entrySet().iterator();
			String[] names = new String[parameters.size()];

			List<String> li = new ArrayList<String>();
			while (iter.hasNext()) {
				Map.Entry entry = (Map.Entry) iter.next();
				String key = (String) entry.getKey();
				li.add(key);
			}
			names = li.toArray(new String[li.size()]);
			this.inserActor = new SimpleJdbcInsert(dataSource)
					.withTableName(tableName).usingColumns(names)// 插入这些字段
					.usingGeneratedKeyColumns(idName);// 带回生成的id
			long id=-1;
			try{
				id = inserActor.executeAndReturnKey(parameters).longValue();
				return id;
			}catch(Exception e){
				e.getStackTrace();
			}
			return id;
		}
	public String getNextId() {
		return StringUtils.randomString(16);
	}
	public String getNextId2() {
		String sql="select nextval('massageSeq')";
		return getJt().queryForObject(sql, String.class);
	}

	public Integer getNextIdNum(){
		int[] array = {0,1,2,3,4,5,6,7,8,9};
		Random rand = new Random();
		for (int i = 10; i > 1; i--) {
		    int index = rand.nextInt(i);
		    int tmp = array[index];
		    array[index] = array[i - 1];
		    array[i - 1] = tmp;
		}
		int result = 0;
		for(int i = 0; i < 6; i++)
		    result = result * 10 + array[i];
		return result;
	}
	
	// public T getEntity(final Class<T> c, final String SQL, final Object[]
	// objs) throws DataAccessException {
	public <T> T getEntity(final Class<T> requiredType, final String SQL,
			final Object[] objs) throws DataAccessException {
		T entity = null;
		try {
			ParameterizedRowMapper<T> mapper = new ParameterizedRowMapper<T>() {
				public T mapRow(ResultSet rs, int rowNum) throws SQLException {
					T tmpEntity = getEntity(requiredType, rs);
					return tmpEntity;
				}
			};
			entity = getJt().queryForObject(SQL, objs, mapper);
		} catch (DataAccessException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}

	// public T getEntity(final Class<T> c, ResultSet rs) {
	public <T> T getEntity(final Class<T> requiredType, ResultSet rs) {
		Map<String, Object> map = new HashMap<String, Object>();
		T entity = null;
		try {
			extractColumns(map, rs);
			entity = requiredType.newInstance();
			try {
				BeanUtils.populate(entity, map);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return entity;
	}

	// public List<T> getEntityList(final Class<T> c, final String SQL, final
	// Object[] objs) throws DataAccessException {
	public <T> List<T> getEntityList(final Class<T> requiredType,
			final String SQL, final Object[] objs) throws DataAccessException {
		List<T> eList = new ArrayList<T>();
		try {
			ParameterizedRowMapper<T> mapper = new ParameterizedRowMapper<T>() {
				public T mapRow(ResultSet rs, int rowNum) throws SQLException {
				
					T m = getEntity(requiredType, rs);
					return m;
				}
			};
			eList = getJt().query(SQL, objs, mapper);
		} catch (DataAccessException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return eList;
	}

	// public Page<T> getPage(final Class<T> c, final String SQL, Page<T>
	// page,List<PropertyFilter> filters) throws DataAccessException {
	public <T> Page<T> getPage(final Class<T> requiredType, final String SQL,
			Page<T> page, List<PropertyFilter> filters)
			throws DataAccessException {
		try {
			String querySql = SqlUtils.getQuerySql(SQL, filters, page);
			String countSql = SqlUtils.getCountSql(querySql);
			Object[] values = SqlUtils.getMatchValues(filters);
			if (page.getTotalCount() <= 0) {
				page.setTotalCount(this.getJt().queryForLong(countSql, values));
			}
			if (page.getTotalCount() <= 0)
				return page;
			List<T> eList = getEntityList(requiredType,
					SqlUtils.toPageSql(querySql, page), values);
			page.setResult(eList);
			// 原来的 page.setResult(eList);

			// /** songshaobo 增加 2012-05-17 */
			// List<T> resultList = new ArrayList<T>();
			// for (int i = page.getPageSize() * (page.getPageNo() - 1); i <
			// page
			// .getPageSize() * page.getPageNo()
			// && i < page.getTotalCount(); i++) {
			// resultList.add(eList.get(i));
			// }
			// page.setResult(resultList);
		} catch (DataAccessException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return page;
	}

	/**
	 * 省内财务
	 */
	public <T> Page<T> getPage1(final Class<T> requiredType, final String SQL,
			Page<T> page, List<PropertyFilter> filters)
			throws DataAccessException {
		try {
			String querySql = SqlUtils.getQuerySql1(SQL, filters, page);
			String countSql = SqlUtils.getCountSql1(querySql);
			Object[] values = SqlUtils.getMatchValues(filters);
			if (page.getTotalCount() <= 0) {
				page.setTotalCount(this.getJt().queryForLong(countSql, values));
			}
			if (page.getTotalCount() <= 0)
				return page;
			List<T> eList = getEntityList(requiredType,
					SqlUtils.toPageSql(querySql, page), values);
			page.setResult(eList);
			// 原来的 page.setResult(eList);

			// /** songshaobo 增加 2012-05-17 */
			// List<T> resultList = new ArrayList<T>();
			// for (int i = page.getPageSize() * (page.getPageNo() - 1); i <
			// page
			// .getPageSize() * page.getPageNo()
			// && i < page.getTotalCount(); i++) {
			// resultList.add(eList.get(i));
			// }
			// page.setResult(resultList);
		} catch (DataAccessException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return page;
	}

	private Map<String, Object> extractColumns(
			final Map<String, Object> columns, final ResultSet rs) {
		try {
			Object value = null;
			ResultSetMetaData rmd = rs.getMetaData();
			for (int i = 1; i <= rmd.getColumnCount(); i++) {
				String fdname = rmd.getColumnName(i).toLowerCase();
				String fdtype = rmd.getColumnTypeName(i);
				value = null;
				if (fdtype.equals("CHAR") || fdtype.equals("VARCHAR2")
						|| fdtype.equals("VARCHAR")) {
					value = rs.getString(fdname);
				} else if (fdtype.equals("DATE") || fdtype.equals("DATETIME")) {
					try {
						Timestamp sqlDate = rs.getTimestamp(fdname);
						if (sqlDate != null) {
							value = new java.util.Date(sqlDate.getTime());
						} else {
							continue;
						}
					} catch (SQLException ex) {
						java.sql.Date sqlDate = rs.getDate(fdname);
						if (sqlDate != null) {
							value = new java.util.Date(sqlDate.getTime());
						} else {
							continue;
						}
					}
				} else if (fdtype.equals("NUMBER")
						|| fdtype.indexOf("BIGINT") >= 0
						|| fdtype.indexOf("TINYINT") >= 0) {
					if (rmd.getScale(i) == 0) {
						value = new Long(rs.getLong(fdname));
					} else {
						value = new Double(rs.getDouble(fdname));
					}
				} else if (fdtype.indexOf("SMALLINT") >= 0) {
					value = new Short(rs.getShort(fdname));
				} else if (fdtype.equals("CLOB")) {
					Clob clob = rs.getClob(fdname);
					if (null != clob) {
						value = clob.getSubString(1, (int) clob.length());
					}
				} else if(fdtype.equals("VARBINARY")){
					value = rs.getString(fdname);
				} else {
					value = rs.getObject(fdname);
				}
				columns.put(replaceName(fdname), value);

			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return columns;
	}

	public static String replaceName(String name) {
		int iIndex = -1;
		String tmpName = name;
		while ((iIndex = tmpName.indexOf("_")) >= 0
				&& iIndex != (tmpName.length() - 1)) {
			tmpName = tmpName.substring(0, iIndex)
					+ tmpName.substring(iIndex + 1, iIndex + 2).toUpperCase()
					+ tmpName.substring(iIndex + 2);
		}
		tmpName = tmpName.replaceAll("_", "");
		return tmpName;
	}

}
