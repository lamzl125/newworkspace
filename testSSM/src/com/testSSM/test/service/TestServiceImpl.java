package com.testSSM.test.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.testSSM.test.dao.TestMapper;
import com.testSSM.test.model.User;

@Service("testService")
public class TestServiceImpl implements TestService{

	@Resource
	private TestMapper testMapper;
//	
//	public TestMapper getTestMapper() {
//		return testMapper;
//	}
//
//	public void setTestMapper(TestMapper testMapper) {
//		this.testMapper = testMapper;
//	}

	@Override
	public List<User> queryAllUser() {
		return testMapper.queryAllUser();
	}

	@Override
	public User queryByID(User user) {
		
		return testMapper.queryByID(user);
	}

	@Override
	public boolean add(User user) {
		return testMapper.add(user);
	}

	@Override
	public boolean deleteByID(int id) {
		return testMapper.deleteByID(id);
	}

	@Override
	public boolean update(User user) {
		return testMapper.update(user);
	}

	@Override
	public boolean isExist(User user) {
		if(testMapper.queryByID(user) ==null)
			return false;
		else
			return true;
	}

}
