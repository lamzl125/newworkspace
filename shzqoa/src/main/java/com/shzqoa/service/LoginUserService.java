package com.shzqoa.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shzqoa.dao.UserMapper;
import com.shzqoa.model.ParameterKind;
import com.shzqoa.model.ReturnDate;
import com.shzqoa.model.User;

@Service
public class LoginUserService {
	@Resource
	private UserMapper userMapper;
	
	public User getUserByCode(String usercode) {  
        return userMapper.getUserByCode(usercode);  
    } 
	
	/**
	 * 注册用户
	 * @param userId
	 * @param userName
	 * @param password
	 * @return
	 */
	public int insertUser(String userId,String userName,String password,String fullName){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("usercode", userId);
		map.put("realname", userName);
		map.put("userpassword", password);
		map.put("userstatus", 1);
		map.put("fullName", fullName);
		int i = userMapper.insertUser(map);
		return i;
	}
	public int update(String userId,String password){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("usercode", userId);
		map.put("userpassword", password);
		int i = userMapper.insertUser(map);
		return i;
	}
	/**
	 * 用户名是否被注册
	 * @param usercode
	 * @return
	 */
	public int isenroll(String usercode){
		int i = userMapper.isenroll(usercode);
		return i;
	}
	
	//根据code  模糊查询用户信息
	public List<User> gettUser(Map<String,Object> map){
		return userMapper.getUser(map);
	}
	
	
	public ReturnDate ispass(String usercode,String userpassword){
		ReturnDate rd =new ReturnDate();
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("usercode", usercode);
		map.put("userpassword", userpassword);
		int result=userMapper.ispass(map);
		if(result>0){
			rd.setData(0);
			rd.setMsg("密码正确");
			rd.setStatus(0);
		}else{
			rd.setData(1);
			rd.setMsg("请输入正确密码！");
			rd.setStatus(1);
		}
		return rd;
	}
	public int ispas(String usercode,String userpassword){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("usercode", usercode);
		map.put("userpassword", userpassword);
		int result=userMapper.ispass(map);
		return result;
	}
	/**
	 * 检测用户名密码  登录
	 * @param usercode
	 * @param userpassword
	 * @return
	 */
	public int checkuser(String usercode,String userpassword){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("usercode", usercode);
		map.put("userpassword", userpassword);
		int i = userMapper.checkuser(map);
		return i;
	}
	
	/**
	 * 用户信息
	 * @param usercode
	 * @return
	 */
	public User sltUser(String usercode){
		return userMapper.sltUser(usercode);
	}
	/**
	 * 修改密码
	 * @param userpassword
	 * @param usercode
	 * @return
	 */
	public ReturnDate updatePass(String userpassword,String usercode){
		
		ReturnDate rd=new ReturnDate();
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("userpassword", userpassword);
		map.put("usercode", usercode);
		int result=userMapper.updatePass(map);
		if(result==1){
			rd.setData(0);
			rd.setMsg("修改成功");
			rd.setStatus(0);
		}else{
			rd.setData(1);
			rd.setMsg("修改失败");
			rd.setStatus(1);
		}
		
		return rd;
	}
	/**
	 * 修改密码
	 * @param userpassword
	 * @param usercode
	 * @return
	 */
	public ReturnDate setPassword(String userpassword,String usercode){
		
		ReturnDate rd=new ReturnDate();
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("userpassword", userpassword);
		map.put("usercode", usercode);
		int result=userMapper.setPassword(map);
		if(result==1){
			rd.setData(0);
			rd.setMsg("重置成功！");
			rd.setStatus(0);
		}else{
			rd.setData(1);
			rd.setMsg("重置失败！");
			rd.setStatus(1);
		}
		
		return rd;
	}

}






