package com.ying.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springside.modules.orm.Page;
import org.springside.modules.orm.PropertyFilter;
import org.springside.modules.utils.web.struts2.Struts2Utils;
import org.utils.DateTimeUtil;
import org.utils.SysGlobals;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Struts2中典型Action的抽象基�?
 * 
 * @param <T>
 *            Action�?��理的对象类型.
 * 
 * @author
 */
public abstract class MiniActionSupport extends ActionSupport {

	private static final long serialVersionUID = -1653204626115064950L;

	/** 进行增删改操作后,以redirect方式重新打开action默认页的result�? */
	public static final String RELOAD = "reload";
	public static final String NOAUTH = "noauth";
	public static final String INDEX = "index";
	// public static final String RELOADANDPARAMS = "reload_and_params";

	private boolean isReload = false;
	public boolean isReload() {
		return isReload;
	}

	public void setReload(boolean isReload) {
		this.isReload = isReload;
	}

	/**
	 * Action函数, 默认的action函数, 默认调用list()函数.
	 */
	@Override
	public String execute() throws Exception {
		return list();
	}

	// -- CRUD Action函数 --//
	/**
	 * Action函数,显示Entity列表界面. 建议return SUCCESS.
	 */
	public abstract String list() throws Exception;

	public Map<String, String> getGlobals() {
		return SysGlobals.getInstance().getProperties();
	}

	/**
	 * 此缓存只有一份，想更新或从缓存中提取分页条件的话才调用该方法
	 * 
	 * @param cachePage
	 */
	public void getCachePage(Page cachePage) {
		List<PropertyFilter> cacheFilters = PropertyFilter
				.buildFromHttpRequest(Struts2Utils.getRequest());
		if (!isReload) {
			Page tmpPage = new Page();
			tmpPage.setPageNo(cachePage.getPageNo());
			if (cachePage.getOrder() != null) {
				tmpPage.setOrder(cachePage.getOrder());
			}
			if (cachePage.getOrderBy() != null) {
				tmpPage.setOrderBy(cachePage.getOrderBy());
			}
			Struts2Utils.getSession().setAttribute("cachePage", tmpPage);
			return;
		} else {
			try {
				Page tmpPage = (Page) Struts2Utils.getSession().getAttribute(
						"cachePage");
				cachePage.setPageNo(tmpPage.getPageNo());
				if (tmpPage.getOrder() != null) {
					cachePage.setOrder(tmpPage.getOrder());
				}
				if (tmpPage.getOrderBy() != null) {
					cachePage.setOrderBy(tmpPage.getOrderBy());
				}

			} catch (Exception e) {
			}
		}

	}
	/**
	 * 此缓存只有一份，想更新或从缓存中提取查询条件的话才调用该方法，若不需缓存请调用PropertyFilter.
	 * buildFromHttpRequest(Struts2Utils.getRequest());
	 * 
	 * @return
	 */
	public List<PropertyFilter> getCacheFilters() {
		List<PropertyFilter> cacheFilters = PropertyFilter
				.buildFromHttpRequest(Struts2Utils.getRequest());
		String strIsReload = Struts2Utils.getParameter("isReload");
		if (strIsReload != null) {
			if ("1".equals(strIsReload) || "true".equalsIgnoreCase(strIsReload)) {
				isReload = true;
			}
		}
		if (isReload) {
			cacheFilters = (List<PropertyFilter>) Struts2Utils.getSession()
					.getAttribute("cacheFilters");
		}
		if (cacheFilters == null) {
			cacheFilters = new ArrayList<PropertyFilter>();
		}
		setCacheFilters(cacheFilters);
		return cacheFilters;
	}

	public void setCacheFilters(final List<PropertyFilter> cacheFilters) {
		if (cacheFilters != null) {
			Struts2Utils.getSession()
					.setAttribute("cacheFilters", cacheFilters);
			for (PropertyFilter e : cacheFilters) {
				String[] pns = e.getPropertyNames();
				String tmpPns = pns[0];
				for (int i = 1; i < pns.length; i++) {
					String pn = pns[i];
					tmpPns += "_or_" + pn;
				}
				String filterName = "filter_" + e.getMatchType()
						+ getProtertyClassType(e) + "_" + tmpPns;
				String value = "";
				if (e.getMatchValue() instanceof Date) {
					value = DateTimeUtil.dateConvtoFmt(
							(Date) e.getMatchValue(), "yyyy-MM-dd");
				} else {
					value = e.getMatchValue().toString();
				}
				Struts2Utils.getRequest().setAttribute(filterName, value);
			}
		}		
	}
	
	private String getProtertyClassType(PropertyFilter e) {
		String pct = "S";
		String sn = e.getPropertyClass().getSimpleName();
		if ("String".equals(sn)) {
			pct = "S";
		} else if ("Integer".equals(sn)) {
			pct = "I";
		} else if ("Long".equals(sn)) {
			pct = "L";
		} else if ("Double".equals(sn)) {
			pct = "N";
		} else if ("Date".equals(sn)) {
			pct = "D";
		} else if ("Boolean".equals(sn)) {
			pct = "B";
		}
		return pct;
	}

	

}
