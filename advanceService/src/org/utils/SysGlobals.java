package org.utils;

import java.util.Map;


public class SysGlobals {
	private static SysGlobals instance = null;
	
	private Map<String,String> properties = null;
    public void setProperties(Map<String, String> properties) {
		this.properties = properties;
	}
    
	private synchronized static void doSync(){
		if(instance == null){
			instance = new SysGlobals();
		}
	}
    
    private SysGlobals(){
    }
    
    public static SysGlobals getInstance(){
		if(instance == null){
			doSync();
		}
		return instance;
    }
    
	public String getProperty(String name) {
		if(properties.containsKey(name))
			return properties.get(name);
		return null;
    }
	
	public Map<String, String> getProperties() {
		return properties;
	}
	
	
}
