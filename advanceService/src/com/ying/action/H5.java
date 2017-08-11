package com.ying.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springside.modules.utils.web.struts2.Struts2Utils;

import com.opensymphony.xwork2.ActionContext;
/*import com.ying.entity.About;
import com.ying.entity.Product;*/
/*import com.ying.service.IComService;
import com.ying.service.IProductService;*/

@SuppressWarnings("serial")
public class H5 extends MiniActionSupport{
	@Autowired
	/*private IComService comservice;
	@Autowired
	private IProductService proservice;
	public String about(){
		About ab=comservice.queryAbout();
		ActionContext.getContext().put("ab", ab);
		return "about";
	}
	public String prodetail(){
		String id=Struts2Utils.getParameter("id");	
		Product pro=proservice.queryById(id);
		ActionContext.getContext().put("pro", pro);
		return "prodetail";
	}
	public String prosize(){
		String id=Struts2Utils.getParameter("id");
		Product pro=proservice.queryById(id);
		ActionContext.getContext().put("pro", pro);
		return "prosize";
	}*/
	@Override
	public String list() throws Exception {
		return null;
	}

}
