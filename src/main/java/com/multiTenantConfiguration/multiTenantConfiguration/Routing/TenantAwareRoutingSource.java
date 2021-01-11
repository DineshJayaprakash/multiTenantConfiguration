package com.multiTenantConfiguration.multiTenantConfiguration.Routing;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;


import com.multiTenantConfiguration.multiTenantConfiguration.Core.ThreadLocalStorage;

/**
 * class TenantAwareRoutingSource
 * 
 * @author dinesh
 * @description used to determining the tenant datasource at run time based on tenant name
 *
 */
public class TenantAwareRoutingSource extends AbstractRoutingDataSource{

	/**
	 * function determineCurrentLookupKey
	 * 
	 * @return threadLocalStorage Object
	 * @description returns the tenant name to identify the data source at run time
	 * 
	 */
	@Override
	protected Object determineCurrentLookupKey() {
		return ThreadLocalStorage.getTenantName();
	}
	
	

}
