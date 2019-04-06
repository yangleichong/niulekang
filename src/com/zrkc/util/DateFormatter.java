package com.zrkc.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.format.Formatter;

public class DateFormatter implements Formatter<Date> {  

    @Override  
    public String print(Date object, Locale locale) {  
        return null;  
    }  

    @Override  
    public Date parse(String text, Locale locale) throws ParseException { 
    	Date date = null;  
        if(text!=null && !"".equals(text)){
        	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
            try {  
                date = format.parse(text);  
            } catch (Exception e) {  
                format = new SimpleDateFormat("yyyy-MM-dd");  
                date = format.parse(text);  
            } 
        }
        return date;  
    }  
}  
