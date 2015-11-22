package com.rp.ventas.configuracion;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource({"classpath:configuracion.properties"})
public class HibernateConfiguration {
	
	@Autowired
	private Environment environment;
	
	@Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource());
        emf.setPackagesToScan(new String[]{"com.rp.ventas.dao.models"});
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        emf.setJpaVendorAdapter(vendorAdapter);
        emf.setJpaProperties(additionalProperties());
        return emf;
    }


	@Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty("database.connection.driver"));
        dataSource.setUrl(environment.getProperty("database.connection.url"));
        dataSource.setUsername(environment.getProperty("database.connection.user"));
        dataSource.setPassword(environment.getProperty("database.connection.password"));
        return dataSource;
    }
	
	@Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }
	
	
	 @SuppressWarnings("serial")
	Properties additionalProperties() {
        return new Properties() {
            {  // Hibernate Specific:
                setProperty("hibernate.hbm2ddl.auto", environment.getProperty("database.hibernate.schema_update"));
                setProperty("hibernate.dialect", environment.getProperty("database.hibernate.dialect"));
                setProperty("hibernate.show_sql", environment.getProperty("database.hibernate.show_sql"));
                setProperty("hibernate.format_sql", environment.getProperty("database.hibernate.format_sql"));
                setProperty("hibernate.use_sql_comments", environment.getProperty("database.hibernate.use_sql_comments"));
                setProperty("hibernate.enable_lazy_load_no_trans", "true");
            }
        };
    }
}
