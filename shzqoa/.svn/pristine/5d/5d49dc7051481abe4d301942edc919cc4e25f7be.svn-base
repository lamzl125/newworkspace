package com.shzqoa.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import com.shzqoa.model.User;

public class AllotUtil {
	/* 
     * 随机分配 
     */  
    public static Map<String,List<Map<String,Object>>> allotOfRandom(List<User> users,List<Map<String,Object>> tasks,Map<String,List<Map<String,Object>>> allot){  
        if(allot==null){
        	allot=new ConcurrentHashMap<String,List<Map<String,Object>>>(); //保存分配的信息  
        }
        if(users!=null&&users.size()>0&&tasks!=null&&tasks.size()>0){  
            for(int i=0;i<tasks.size();i++){  
                    int r_user=new Random().nextInt(users.size());  
                    if(allot.containsKey(users.get(r_user).getUsercode())){
                        List<Map<String,Object>> list=allot.get(users.get(r_user).getUsercode());  
                        list.add(tasks.get(i));  
                        allot.put(users.get(r_user).getUsercode(), list);  
                    }else{  
                        List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();  
                        list.add(tasks.get(i));  
                        allot.put(users.get(r_user).getUsercode(), list);  
                    }  
            }  
        }  
        return allot;  
    }  
    /* 
     * 平均分配 
     */  
    public static Map<String,List<Map<String,Object>>> allotOfAverage(List<User> users,List<Map<String,Object>> tasks,Map<String,List<Map<String,Object>>> allot){  
    	//保存分配的信息  
    	if(allot==null){
        	allot=new ConcurrentHashMap<String,List<Map<String,Object>>>(); //保存分配的信息  
        } 
        if(users!=null&&users.size()>0&&tasks!=null&&tasks.size()>0){  
            for(int i=0;i<tasks.size();i++){  
                int j=i%users.size();  
                if(allot.containsKey(users.get(j))){  
                    List<Map<String,Object>> list=allot.get(users.get(j).getUsercode());  
                    list.add(tasks.get(i));  
                    allot.put(users.get(j).getUsercode(), list);  
                }else{  
                    List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();  
                    list.add(tasks.get(i));  
                    allot.put(users.get(j).getUsercode(), list);  
                }  
            }  
        }  
        return allot;  
    }  
    /* 
     * 权重分配 
     */  
    public static Map<String,List<String>> allotOfProportion(Map<String,String> users,List<String> tasks){  
            Map<String,List<String>> allot=new ConcurrentHashMap<String,List<String>>(); //保存分配的信息  
            if(users!=null&&users.size()>0&&tasks!=null&&tasks.size()>0){  
                int a=0;//总权重   
                for(Entry<String, String> entry:users.entrySet()){    
                   a+=Integer.parseInt(entry.getValue());    
                }  
                int start=0,end=0;//起始下标 ,结束下标   
                if(a>0){  
                    for(Entry<String, String> entry:users.entrySet()){    
                        List<String> allotTask=new ArrayList<String>();    
                        end+=Integer.parseInt(entry.getValue());//权重累计    
                        for(;start<tasks.size()*end/a;start++){    
                            allotTask.add(tasks.get(start));    
                        }    
                        allot.put(entry.getKey(),allotTask);    
                    }   
                }  
            }  
        return allot;  
    } 
    
    
    
    
}
