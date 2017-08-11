package com.shzqoa.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shzqoa.dao.FollowMapper;
import com.shzqoa.model.Follow;
@Service
public class FollowService {
	@Resource
	private FollowMapper followMapper;
	
	@Transactional
	public int save(Follow info){
		if(info != null){
			return this.followMapper.save(info);
		}
		return 0;
	}

	@Transactional
	public int delete(Integer followId){
		if(followId!=null && followId > 0){
			return this.followMapper.deleteById(followId);
		}
		return 0;
	}
	
	@Transactional
	public int update(Follow info){
		if(info != null){
			return this.followMapper.update(info);
		}
		return 0;
	}

	public List<Follow> selcontact(Map<String,Object> map){
		return  followMapper.selFollow(map);
	}
	public Integer getFollowCount(Map<String,Object> map){
		return followMapper.getFollowCount(map);
	}
	public Follow getFollowById(Integer followId){
		return this.followMapper.getFollowById(followId);
	}
	public List<Object> selLastOperTime(){
		return followMapper.selLastOperTime();
	}
	
	
}
