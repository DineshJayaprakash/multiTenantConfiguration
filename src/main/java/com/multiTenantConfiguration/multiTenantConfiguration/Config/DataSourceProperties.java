package com.multiTenantConfiguration.multiTenantConfiguration.Config;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import com.zaxxer.hikari.HikariDataSource;

@ConfigurationProperties(prefix = "tenants")
@Component
public class DataSourceProperties {
	
	private Map<Object, Object> dataSources = new LinkedHashMap<Object, Object>();
	
	
    public Map<Object, Object> getDataSources() {
        return dataSources;
    }
 
    public void setDataSources(Map<String, Map<String, String>> datasources) {
    	System.out.println(datasources);
        datasources.forEach((key, value) -> {this.dataSources.put(key, convert(value));});
    }
 
    public DataSource convert(Map<String, String> source) {
    	
    	HikariDataSource dataSource = new HikariDataSource();
    	dataSource.setInitializationFailTimeout(0);
		dataSource.setMaximumPoolSize(5);
		dataSource.setDriverClassName(source.get("driverClassName"));
		dataSource.setJdbcUrl(source.get("jdbcUrl"));
        dataSource.addDataSourceProperty("user", source.get("username"));
        dataSource.addDataSourceProperty("password", source.get("password"));
        dataSource.setSchema(source.get("schema"));
        return dataSource;
//        return DataSourceBuilder.create()
//                .url(source.get("jdbcUrl"))
//                .driverClassName(source.get("driverClassName"))
//                .username(source.get("username"))
//                .password(source.get("password"))
//                .build();
    }
    

    
}