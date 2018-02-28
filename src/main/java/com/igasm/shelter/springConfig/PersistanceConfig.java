package com.igasm.shelter.springConfig;


import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource({"classpath:database.properties"})
@ComponentScan({"com.igasm.shelter.persistence"})
public class PersistanceConfig {

  @Autowired
  private Environment env;

  @Bean
  public LocalSessionFactoryBean sessionFactory(){
    LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
    sessionFactory.setDataSource(restDataSource());
    sessionFactory.setPackagesToScan(
        new String[] {"com.igasm.shelter.persistence.model"}
    );
    sessionFactory.setHibernateProperties(hibernateProperties());
    return sessionFactory;
  }

  @Bean
  public DataSource restDataSource() {
    BasicDataSource dataSource = new BasicDataSource();
    dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
    dataSource.setUrl(env.getProperty("jdbc.url"));
    dataSource.setUsername(env.getProperty("jdbc.username"));
    dataSource.setPassword(env.getProperty("jdbc.password"));
    return dataSource;
  }

  public Properties hibernateProperties() {
    return new Properties() {
      {
        setProperty("hibernate.hbm2ddl.auto",
            env.getProperty("hibernate.hbm2ddl.auto"));
        setProperty("hibernate.dialect",
            env.getProperty("hibernate.dialect"));
        setProperty("hibernate.globally_quoted_identifiers",
            "true");
      }
    };
  }


}
