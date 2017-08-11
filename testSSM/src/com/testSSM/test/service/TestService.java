package com.testSSM.test.service;

import java.util.List;

import com.testSSM.test.model.User;

public interface TestService {
	public List<User> queryAllUser();
	public User queryByID(User user);
	public boolean add(User user);
	public boolean deleteByID(int id);
	public boolean update(User user);
	public boolean isExist(User user);
}
