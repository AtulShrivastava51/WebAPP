package com.demo.login;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan
public class AppConfig {
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setUrl("jdbc:mysql://localhost:3306/USERS");
		ds.setUsername("root");
		ds.setPassword("Pranjali1999");
		return ds;
	}
}
