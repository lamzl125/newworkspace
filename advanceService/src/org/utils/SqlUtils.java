package org.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springside.modules.orm.Page;
import org.springside.modules.orm.PropertyFilter;
import org.springside.modules.orm.PropertyFilter.MatchType;

public class SqlUtils {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static String getQuerySql(String srcSql,
			final List<PropertyFilter> filters, Page<?> page) {
		/**
		 * wangjunshun 20120830
		 */
		String tmpSql = srcSql.toLowerCase();
		StringBuilder sb = new StringBuilder();
		if (StringUtils.indexOf(tmpSql, "where") < 0) {
			sb.append(tmpSql).append(" where ");
		} else {
			sb.append(tmpSql).append(" and ");
		}
		for (PropertyFilter filter : filters) {
			if (!filter.hasMultiProperties()) { // 只有一个属性需要比较的情况.
				sb.append(filter.getPropertyName())
						.append(getStrMatchType(filter.getMatchType()))
						.append(" and ");
			} else {// 包含多个属性需要比较的情况,进行or处理.
				StringBuilder sbTmp = new StringBuilder();
				sbTmp.append("(");
				for (String param : filter.getPropertyNames()) {
					sbTmp.append(" ")
							.append(param)
							.append(getStrMatchType(filter.getMatchType()))
							.append(" or");
				}
				sb.append(StringUtils.removeEndIgnoreCase(sbTmp.toString(),
						"or") + ") and ");
			}
		}
		String sql = StringUtils.removeEndIgnoreCase(
				StringUtils.removeEndIgnoreCase(sb.toString(), "where "),
				"and ");
		if (page.isOrderBySetted()) {
			sql += " order by "
					+ org.utils.StringUtils
							.uppercase2_(page.getOrderBy()) + " "
					+ page.getOrder();
		}
		return sql;
	}

	public static String getQuerySql1(String srcSql,
			final List<PropertyFilter> filters, Page<?> page) {
		/**
		 * wangjunshun 20120830
		 */
		String tmpSql = srcSql;
		StringBuilder sb = new StringBuilder();
		if (StringUtils.indexOf(tmpSql, "where") < 0) {
			sb.append(tmpSql).append(" where ");
		} else {
			sb.append(tmpSql).append(" and ");
		}
		for (PropertyFilter filter : filters) {
			if (!filter.hasMultiProperties()) { // 只有一个属性需要比较的情况.
				sb.append(
						org.utils.StringUtils.uppercase2_(filter
								.getPropertyName()))
						.append(getStrMatchType(filter.getMatchType()))
						.append(" and ");
			} else {// 包含多个属性需要比较的情况,进行or处理.
				StringBuilder sbTmp = new StringBuilder();
				sbTmp.append("(");
				for (String param : filter.getPropertyNames()) {
					sbTmp.append(" ")
							.append(org.utils.StringUtils
									.uppercase2_(param))
							.append(getStrMatchType(filter.getMatchType()))
							.append(" or");
				}
				sb.append(StringUtils.removeEndIgnoreCase(sbTmp.toString(),
						"or") + ") and ");
			}
		}
		String sql = StringUtils.removeEndIgnoreCase(
				StringUtils.removeEndIgnoreCase(sb.toString(), "where "),
				"and ");
		if (page.isOrderBySetted()) {
			sql += " order by "
					+ org.utils.StringUtils
							.uppercase2_(page.getOrderBy()) + " "
					+ page.getOrder();
		}
		return sql;
	}

	public static String getCountSql(String srcSql,
			final List<PropertyFilter> filters, Page<?> page) {
		String tmpSql = srcSql.toLowerCase();
		StringBuilder sb = new StringBuilder();
		if (tmpSql.indexOf("from") > 0) {
			tmpSql = "select count(*) "
					+ tmpSql.substring(tmpSql.indexOf("from"));
		}
		if (StringUtils.indexOf(tmpSql, "where") < 0) {
			sb.append(tmpSql).append(" where ");
		} else {
			sb.append(tmpSql).append(" and ");
		}
		for (PropertyFilter filter : filters) {
			if (!filter.hasMultiProperties()) { // 只有一个属性需要比较的情况.
				sb.append(
						org.utils.StringUtils.uppercase2_(filter
								.getPropertyName()))
						.append(getStrMatchType(filter.getMatchType()))
						.append(" and ");
			} else {// 包含多个属性需要比较的情况,进行or处理.
				StringBuilder sbTmp = new StringBuilder();
				sbTmp.append("(");
				for (String param : filter.getPropertyNames()) {
					sbTmp.append(" ")
							.append(org.utils.StringUtils
									.uppercase2_(param))
							.append(getStrMatchType(filter.getMatchType()))
							.append(" or");
				}
				sb.append(StringUtils.removeEndIgnoreCase(sbTmp.toString(),
						"or") + ") and ");
			}
		}
		String sql = StringUtils.removeEndIgnoreCase(
				StringUtils.removeEndIgnoreCase(sb.toString(), "where "),
				"and ");
		return sql;
	}

	/**
	 * 2012-06-19 add group by
	 * */
	public static String getCountSql(String srcSql) {
		String tmpSql = srcSql.toLowerCase();
		// String tmpSql = srcSql;
		if(tmpSql.indexOf("DISTINCT")>0 ||tmpSql.indexOf("distinct")>0){
			tmpSql="select count(*) from ("+tmpSql+") tempCount";
			return tmpSql;
		}
		if (tmpSql.indexOf("from") > 0) {
			tmpSql = "select count(*) "
					+ tmpSql.substring(tmpSql.indexOf("from"));
		}
		if (tmpSql.indexOf("order by") > 0) {
			tmpSql = tmpSql.substring(0, tmpSql.indexOf("order by"));
		}
		if (tmpSql.indexOf("group by") > 0) {
			tmpSql = "select count(*) from (" + tmpSql + ") sal";
		}
		return tmpSql;
	}

	public static String getCountSql1(String srcSql) {
		String tmpSql = srcSql;
		if (tmpSql.indexOf("from") > 0) {
			tmpSql = "select count(*) "
					+ tmpSql.substring(tmpSql.indexOf("from"));
		}
		if (tmpSql.indexOf("order by") > 0) {
			tmpSql = tmpSql.substring(0, tmpSql.indexOf("order by"));
		}
		if (tmpSql.indexOf("group by") > 0) {
			tmpSql = "select count(*) from (" + tmpSql + ")";
		}
		return tmpSql;
	}

	public static Object[] getMatchValues(final List<PropertyFilter> filters) {
		List<Object> values = new ArrayList<Object>();
		for (PropertyFilter filter : filters) {
			Object realValue = null;
			if (filter.getMatchType() == MatchType.LIKE) {
				realValue = "%" + filter.getMatchValue() + "%";
			} else {
				realValue = filter.getMatchValue();
			}
			if (!filter.hasMultiProperties()) { // 只有一个属性需要比较的情况.
				values.add(realValue);
			} else {
				for (int i = 0; i < filter.getPropertyNames().length; i++) {
					values.add(realValue);
				}
			}
		}
		return values.toArray();
	}

	/**
	 * 转换比较类型成字符串
	 * 
	 * @param mt
	 * @return
	 */
	private static String getStrMatchType(MatchType mt) {
		String strMT = " = ";
		try {
			switch (mt) {
			case EQ:
				strMT = " = ";
				break;
			case GE:
				strMT = " >= ";
				break;
			case GT:
				strMT = " > ";
				break;
			case LE:
				strMT = " <= ";
				break;
			case LIKE:
				strMT = " like ";
				break;
			case LT:
				strMT = " < ";
				break;
			}
			strMT += "? ";
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return strMT;
	}

	public static String toPageSql(String sql, Page page) {
		if (page.getPageNo() <= 0) {
			page.setPageNo(1);
		}
		int from = (page.getPageNo() - 1) * page.getPageSize();
		int to = page.getPageNo() * page.getPageSize();
		String newSql = "select * from ("+sql+" limit "+ from + "," + to+") tb limit "+page.getPageSize() ;
		return newSql;
	}

}
