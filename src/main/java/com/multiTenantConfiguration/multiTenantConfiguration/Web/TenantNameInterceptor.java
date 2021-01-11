package com.multiTenantConfiguration.multiTenantConfiguration.Web;


import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;
import com.multiTenantConfiguration.multiTenantConfiguration.Core.ThreadLocalStorage;

/**
 * class TenantNameInterceptor
 * 
 * @author dinesh
 * @created date 04/21
 *
 */
@Component
public class TenantNameInterceptor implements WebRequestInterceptor {

	private static final String TENANT_HEADER = "X-Tenant";

	@Override
	public void preHandle(WebRequest request) throws Exception {
	
			ThreadLocalStorage.setTenantName(request.getHeader(TENANT_HEADER));
	}

	@Override
	public void postHandle(WebRequest request, ModelMap model) throws Exception {
		ThreadLocalStorage.clear();
	}

	@Override
	public void afterCompletion(WebRequest request, Exception ex) throws Exception {
		
	}
	    
	
}
