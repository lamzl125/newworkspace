package com.shzqoa.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shzqoa.dao.NoticeMapper;
import com.shzqoa.model.Notice;

@Service
public class NoticeService {
	@Resource
	private NoticeMapper noticeMapper;
	
	public List<Map<String,Object>> getAllUnSeenNotice(Integer start,Integer pageSize){
		Map<String,Object> map = new HashMap<String,Object>();
		if(start != null && pageSize != null && start>=0 && pageSize>0){
			map.put("start", start);
			map.put("pageSize", pageSize);
		}
		return noticeMapper.getAllUnSeenNotice(map);
	}
	public int updateNotice(Notice  info){
		return noticeMapper.update(info);
	}
	
	public Notice getNoticeById(String noticeId){
		return noticeMapper.getNoticeById(noticeId);
	}
}
