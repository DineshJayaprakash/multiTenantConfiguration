package com.multiTenantConfiguration.multiTenantConfiguration.Config;


import javax.sql.DataSource;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.multiTenantConfiguration.multiTenantConfiguration.Routing.TenantAwareRoutingSource;
import com.zaxxer.hikari.HikariDataSource;


/**
 * class Config
 * 
 * @author dinesh
 * @description used to create the singleton bean for application
 */

@Configuration
public class Config {

	/**
	 * function getmodelMapper
	 * 
	 * @return singleton bean of modelmapper
	 */
	@Bean
	public ModelMapper getmodelMapper() {
		return new ModelMapper();
	}

	private final DataSourceProperties dataSourceProperties;

	public Config(DataSourceProperties dataSourceProperties) {
		this.dataSourceProperties = dataSourceProperties;
	}
	
	//Postgre sql Default Data Source Set for warning in console
//	public DataSource DefaultTenant() {
//		HikariDataSource dataSource = new HikariDataSource();
//		dataSource.setInitializationFailTimeout(0);
//		dataSource.setMaximumPoolSize(5);
//		dataSource.setDriverClassName("org.postgresql.Driver");
//		dataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/patientdb4");
//		dataSource.addDataSourceProperty("user", "postgres");
//		dataSource.addDataSourceProperty("password", "Balaji@407");
//		dataSource.setSchema("tenant1");
//		return dataSource;
//	}
	
	public DataSource DefaultTenant() {
		HikariDataSource dataSource = new HikariDataSource();
		dataSource.setInitializationFailTimeout(0);
		dataSource.setMaximumPoolSize(5);
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/patientDb1?createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true&useSSL=false");
		dataSource.addDataSourceProperty("user", "root");
		dataSource.addDataSourceProperty("password", "Balaji@407");
		return dataSource;
	}


	@Bean
	public DataSource dataSource() {
		TenantAwareRoutingSource customDataSource = new TenantAwareRoutingSource();
		customDataSource.setTargetDataSources(dataSourceProperties.getDataSources());
		customDataSource.setDefaultTargetDataSource(DefaultTenant());
		return customDataSource;
	}
	

}
