package com.shzqoa.util;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.apache.commons.lang.math.RandomUtils;

public class RandomUtil {
	private static Random random;
	 
    //双重校验锁获取一个Random单例
    public static Random getRandom() {
        if(random==null){
            synchronized (RandomUtils.class) {
                if(random==null){
                    random =new Random();
                }
            }
        }
         
        return random;
    }
 
    /**
     * 获得一个[0,max)之间的整数。
     * @param max
     * @return
     */
    public static int getRandomInt(int max) {
        return Math.abs(getRandom().nextInt())%max;
    }
     
    /**
     * 获得一个[0,max)之间的整数。
     * @param max
     * @return
     */
    public static long getRandomLong(long max) {
        return Math.abs(getRandom().nextInt())%max;
    }
     
    /**
     * 从list中随机取得一个元素
     * @param list
     * @return
     */
    public static <E> E getRandomElement(List<E> list){
        return list.get(getRandomInt(list.size()));
    }
     
    /**
     * 从set中随机取得一个元素
     * @param set
     * @return
     */
    public static <E> E getRandomElement(Set<E> set){
        int rn = getRandomInt(set.size());
        int i = 0;
        for (E e : set) {
            if(i==rn){
                return e;
            }
            i++;
        }
        return null;
    }
     
    /**
     * 从map中随机取得一个key
     * @param map
     * @return
     */
    public static <K, V> K getRandomKeyFromMap(Map<K, V> map) {  
        int rn = getRandomInt(map.size());  
        int i = 0;  
        for (K key : map.keySet()) {  
            if(i==rn){  
                return key;  
            }  
            i++;  
        }  
        return null;  
    }  
     
    /**
     * 从map中随机取得一个value
     * @param map
     * @return
     */
    public static <K, V> V getRandomValueFromMap(Map<K, V> map) {  
        int rn = getRandomInt(map.size());  
        int i = 0;  
        for (V value : map.values()) {  
            if(i==rn){  
                return value;  
            }  
            i++;  
        }  
        return null;  
    }  
     
    
    /** 
     * 生成一个n位的随机数，用于验证码等 
     * @param n 
     * @return 
     */  
    public static String getRandNumber(int n) {  
        String rn = "";  
        if (n > 0 && n < 10) {  
            //Random r = new Random();  
            StringBuffer str = new StringBuffer();  
            for (int i = 0; i < n; i++) {  
                str.append('9');  
            }  
            int num = Integer.parseInt(str.toString());  
            while (rn.length() < n) {  
                rn = String.valueOf(random.nextInt(num));  
            }  
        } else {  
            rn = "0";  
        }  
        return rn;  
    }  
    
}