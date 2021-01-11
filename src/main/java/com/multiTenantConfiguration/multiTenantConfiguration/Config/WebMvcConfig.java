package com.multiTenantConfiguration.multiTenantConfiguration.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.multiTenantConfiguration.multiTenantConfiguration.Web.TenantNameInterceptor;

/**
 * class WebMvcConfig
 * 
 * @author dinesh
 * @created date 04/01
 * @description used to register the interceptor
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	   
	   private final TenantNameInterceptor tenantNameInterceptor;
	   
	   @Autowired
	   public WebMvcConfig(TenantNameInterceptor tenantNameInterceptor) {
		   this.tenantNameInterceptor = tenantNameInterceptor;
	   }
	   
	   /**
	    * function addInterceptors
	    * 
	    * @description add interceptors used to register the interceptor in registry file
	    */
	   @Override
	   public void addInterceptors(InterceptorRegistry registry) {
	        registry.addWebRequestInterceptor(tenantNameInterceptor);
	    }
}
