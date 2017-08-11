package com.shzqoa.service;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.shzqoa.dao.CorpMapper;
import com.shzqoa.model.Corp;

@Service
public class CorpService {
	@Resource
	private CorpMapper corpMapper;
	
	public List<Corp> getAllCorp(Map<String,Object> map){
		return corpMapper.getAllCorp(map);
	}
	public Integer getAllCoropsCount(Map<String,Object> map){
		return corpMapper.getAllCoropsCount(map);
	}
	public int insertCorp(Corp  info){
		return corpMapper.insertCorp(info);
	}
	
	public Corp getCorpById(String areaid){
		return corpMapper.getCorpById(areaid);
	}
	
    public List<Corp> getCorpList(){
    	return corpMapper.getCorpList();
    }
    
    /**
     * 过期合作公司提示
     * @return
     */
    public List<Map<String,Object>> overdueCue(){
    	return corpMapper.overdueCue();
    }
    
    
    public int closeCorp(Corp  info){
		return corpMapper.closeCorp(info);
	}
}





