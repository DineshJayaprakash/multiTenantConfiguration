package com.multiTenantConfiguration.multiTenantConfiguration.Core;

/**
 * class ThreadLocalStorage
 * 
 * @author dinesh
 * @created date 04/01
 * @decription used to store and process the tenant name
 *
 */
public class ThreadLocalStorage {
	
	/**
	 * tenant variable to store the tenant details
	 */
    private static ThreadLocal<String> tenant = new ThreadLocal<>();

    /**
     * function setTenantName
     * 
     * @param tenantName
     * @description setter function to set the tenant name
     */
    public static void setTenantName(String tenantName) {
        tenant.set(tenantName);
    }

    /**
     * function getTenantName
     * 
     * @return return the tenant name
     */
    public static String getTenantName() {
        return tenant.get();
    }
    
    /**
     * function clear
     * 
     * @description used to clear the tenant details
     */
    public static void clear() {
    	tenant.remove();
    }

}
