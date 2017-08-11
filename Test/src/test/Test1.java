package test;

import java.text.SimpleDateFormat;
import java.util.Date;




public class Test1 {
	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String string =  simpleDateFormat.format(date);
		
		
		System.out.println("aString:"+string);
		
		
	}

}
