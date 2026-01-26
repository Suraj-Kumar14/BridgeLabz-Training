package com.reflectionandannotations.annotations.serializationannotation;

import java.lang.reflect.Field;

public class Main {
	 public static void main(String[] args) throws Exception {
	        User user = new User("Suraj", 22);

	        String json = toJson(user);
	        System.out.println(json);
	    }

	    static String toJson(Object obj) throws Exception {
	        StringBuilder sb = new StringBuilder("{");

	        Field[] fields = obj.getClass().getDeclaredFields();

	        for (Field f : fields) {
	            if (f.isAnnotationPresent(JsonField.class)) {
	                f.setAccessible(true);
	                JsonField jf = f.getAnnotation(JsonField.class);

	                sb.append("\"")
	                  .append(jf.name())
	                  .append("\":\"")
	                  .append(f.get(obj))
	                  .append("\",");
	            }
	        }

	        sb.deleteCharAt(sb.length() - 1);
	        sb.append("}");

	        return sb.toString();
	    }
}
