package com.ying.action;


import org.utils.PageContainer;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * Struts2中典型CRUD Action的抽象基�?
 * 
 * @param <T>
 *            CRUDAction�?��理的对象类型.
 * 
 * @author
 */
public abstract class CrudActionSupport<T> extends MiniActionSupport implements
		ModelDriven<T>,
		Preparable {

	/**
	 * Action函数,显示新增或修改Entity界面. 建议return INPUT.
	 */
	@Override
	public abstract String input() throws Exception;

	/**
	 * Action函数,新增或修改Entity. 建议return RELOAD.
	 */
	public abstract String save() throws Exception;

	/**
	 * Action函数,删除Entity. 建议return RELOAD.
	 */
	public abstract String delete() throws Exception;

	
	// -- Preparable函数 --//
	/**
	 * 实现空的prepare()函数,屏蔽了所有Action函数都会执行的公共的二次绑定.
	 */
	public void prepare() throws Exception {
	}

	/**
	 * 定义在input()前执行二次绑�?
	 */
	public void prepareInput() throws Exception {
		prepareModel();
	}

	/**
	 * 定义在save()前执行二次绑�?
	 */
	public void prepareSave() throws Exception {
		prepareModel();
	}

	/**
	 * 等同于prepare()的内部函�?供prepardMethodName()函数调用.
	 */
	protected abstract void prepareModel() throws Exception;

	/**
	 * 分页显示
	 * 
	 * @return
	 */
	public abstract PageContainer getPageContainer();

}
