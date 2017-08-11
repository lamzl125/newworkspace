package com.testSSM.test.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.testSSM.test.model.User;
import com.testSSM.test.service.TestService;
import net.sf.json.JSONObject;


@Controller
@RequestMapping("/test")
public class TestController {

	@Resource
	private TestService testService;
	
	private Gson gson = new GsonBuilder().setPrettyPrinting().setDateFormat("yyyy-MM-dd HH:mm:ss:SSS").create();
	
	//--------------------添加新用户信息 Start-----------------------
	
	

	//处理来自客户端的请求，并将json格式的数据处理结果返回。
	//用户注册
	@RequestMapping("/addUser.json")
	public void addUserFromClient(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam("userName") String userName,@RequestParam("password") String password){
/*		String userName=request.getParameter("userName");
		String password=request.getParameter("password");*/
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		
		response.setContentType("application/json");
		PrintWriter out = null;
		JSONObject json = new JSONObject();
		
		try{
			out = response.getWriter();
			
			if(testService.add(user)==true){
				json.put("status", 1);
				out.write(json.toString());
			}else{
				json.put("status", 0);
				out.write(json.toString());
			}
		} catch(Exception e){
			e.printStackTrace();
			json.put("status", -1);
			out.write(json.toString());
		}finally{
			out.flush();
			out.close();
		}
		
	}
	//--------------------添加新用户信息 End-----------------------
	

	//处理客户端单个用户信息请求，返回json格式请求查询数据
	@RequestMapping("/getInfo.json")
	public void getInfoFromClient(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam("id") int id) {
		//int userId = Integer.parseInt(request.getParameter("id"));
		
		User user = new User();
		user.setId(id);

		response.setContentType("application/json");
		PrintWriter out = null;
		JSONObject json = new JSONObject();
		
		try {	
			out = response.getWriter();
			
			user = testService.queryByID(user);
			if (user != null) {
				// user = testService.queryByID(user);
				//String empJson = gson.toJson(user);
				//model.addAttribute("result", empJson);
				json.put("status", 1);
				json.put("user", user);
				out.write(json.toString());
				// out.print(empJson);

			} else {
				//model.addAttribute("result", "null");				
				json.put("status", 0);
				json.put("user", null);
				out.write(json.toString());
				// out.print(empJson);

			}
		} catch (Exception e) {
			e.toString();
			json.put("status", -1);
			json.put("user", null);
			out.write(json.toString());
		} finally{
			out.flush();
			out.close();
		}

		//return "queryResult";
	}	
	//--------------------查询单个用户信息 End-----------------------

	
	
	//--------------------删除某个用户信息 Start-----------------------
	//访问delete页面
	@RequestMapping("/deletePage.do")
	public String deletePage(){
		return "delete";
	}
	//处理来自浏览器的删除请求，具体逻辑在前台页面的js函数中实现
	@RequestMapping("/delete.do")
	public void deleteFromJspPage(@RequestParam("id") int id,HttpServletRequest request,HttpServletResponse response, Model model){
		
		String result = "{\"result\":\"error\"}";
		
		try {	
			if(testService.deleteByID(id)){
				result = "{\"result\":\"success\"}";
				System.out.println( "删除成功！\n");
				//return "success";
			}else{
				result = "{\"result\":\"failure\"}";
				System.out.println( "删除失败！\n");
				//return "failure";
			}
			
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.write(result);

		} catch (Exception e) {
			e.printStackTrace();
			result = "{\"result\":\"failure\"}";
			System.out.println( "删除失败！\n");
			//return "failure";
		} 
	}	
	//处理来自客户端的删除请求，并返回json格式的删除结果（1：成功；0：失败；-1：异常）
	@RequestMapping("/delete.json")
	public void deleteFromClient(@RequestParam("id") int id,HttpServletRequest request,HttpServletResponse response, Model model){
		
		response.setContentType("application/json");
		PrintWriter out = null;
		JSONObject json = new JSONObject();
		
		try {	
			out = response.getWriter();
			
			if(testService.deleteByID(id)){
				json.put("status", 1);
				out.write(json.toString());
			}else{
				json.put("status", 0);
				out.write(json.toString());
			}

		} catch (Exception e) {
			e.printStackTrace();
			json.put("status", -1);
			out.write(json.toString());
		} finally{
			out.flush();
			out.close();
		}
	}
	//--------------------删除某个用户信息 End-----------------------
	
	
	//--------------------获取所有用户信息 Start-----------------------
	//处理来自浏览器的请求，切换页面到所有用户信息列表
	@RequestMapping("/userlistPage.do")
	public String getAllUserFromJspPage(HttpServletRequest request, Model model){
		try{
			List<User> userList = testService.queryAllUser();		
			model.addAttribute("userList", userList);
		}catch (Exception e){
			e.toString();
			model.addAttribute("userList", null);
		}

		return "showAllUser";
	}
	//处理来自客户端的请求，并将json格式的结果返回。
	@RequestMapping("/userListPage.json")
	public void getAllUserFromClient(HttpServletResponse response){
		
		response.setContentType("application/json");
		PrintWriter out = null;
		JSONObject json = new JSONObject();
		
		try {	
			out = response.getWriter();
			List<User> userList = testService.queryAllUser();
			
			if(userList !=null){
				json.put("status", 1);
				json.put("userList", userList);
				out.write(json.toString());
			}else{
				json.put("status", 0);
				json.put("userList", null);
				out.write(json.toString());
			}

		} catch (Exception e) {
			e.printStackTrace();
			json.put("status", -1);
			json.put("userList", null);
			out.write(json.toString());
		} finally{
			out.flush();
			out.close();
		}	
	}
	//--------------------获取所有用户信息 End-----------------------
}
