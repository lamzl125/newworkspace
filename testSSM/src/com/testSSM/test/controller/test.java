package com.testSSM.test.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class test {

	public static void main(String[] args) {
		 Map<String, String> map=new HashMap<String, String>();  
	        map.put("a","1");  
	        map.put("b","2");  
	        map.put("c","3");  
	        System.out.println(map);  
	        Iterator<String> iterator=map.keySet().iterator();  
	        while(iterator.hasNext()){  
	            Object key=iterator.next();  
	            System.out.println(map.get(key));  
	        }  
	}
}
