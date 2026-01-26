package com.reflectionandannotations.annotations.rolebasedaccess;

public class Main {

	static String currentUserRole="USER";
	
	public static void main(String[] args) {
		 try {
	            Class<AdminService> clazz = AdminService.class;

	            if (clazz.isAnnotationPresent(RoleAllowed.class)) {
	                RoleAllowed role = clazz.getAnnotation(RoleAllowed.class);

	                if (!role.value().equals(currentUserRole)) {
	                    System.out.println("Access Denied!");
	                    return;
	                }
	            }

	            AdminService service = new AdminService();
	            service.deleteUser();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }	

	}

}
