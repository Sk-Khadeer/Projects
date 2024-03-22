package com.example.modal;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
 entityManagerFactoryRef = "productEntityManagerFactory",
 transactionManagerRef = "productTransactionManager",
 basePackages = {
  "com.example.product.repo"
 }
)
public class ProductConfig {
	@Bean(name = "productDataSource")
	 @ConfigurationProperties(prefix = "db2.datasource")
	 public DataSource dataSource() {
	  return DataSourceBuilder.create().build();
	 }

	 @Bean(name = "productEntityManagerFactory")
	 public LocalContainerEntityManagerFactoryBean
	 barEntityManagerFactory(
	  EntityManagerFactoryBuilder builder,
	  @Qualifier("productDataSource") DataSource dataSource
	 ) {
//		 Map<String,Object> properties=new HashMap<>();
//			properties.put("hibernate.hbm2ddl.auto","update");
//			properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
			
	  return
	  builder
	   .dataSource(dataSource)
	   .packages("com.example.modal")
	   .persistenceUnit("testdb")
	   .build();
	 }

	 @Bean(name = "productTransactionManager")
	 public PlatformTransactionManager productTransactionManager(
	  @Qualifier("productEntityManagerFactory") EntityManagerFactory productEntityManagerFactory
	 ) {
	  return new JpaTransactionManager(productEntityManagerFactory);
	 }
}
