package com.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.demo.service", "com.demo.dao","com.demo.controller" })
@Import(DataSourceConfiguration.class)
public class AppConfig {


	
}