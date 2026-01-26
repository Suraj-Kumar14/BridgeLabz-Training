package com.reflectionandannotations.reflection.generateJSON;

import java.lang.reflect.Field;

public class JsonUtil {
	 public static String toJson(Object obj) throws IllegalAccessException {
	        Class<?> clazz = obj.getClass();
	        StringBuilder json = new StringBuilder("{");

	        Field[] fields = clazz.getDeclaredFields();

	        for (int i = 0; i < fields.length; i++) {
	            fields[i].setAccessible(true);
	            json.append("\"")
	                .append(fields[i].getName())
	                .append("\": \"")
	                .append(fields[i].get(obj))
	                .append("\"");

	            if (i < fields.length - 1) json.append(", ");
	        }

	        json.append("}");
	        return json.toString();
	    }
}
