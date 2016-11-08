package com.spark.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Spark on 1/24/16.
 */
@Configuration
@ComponentScan("com.spark")
@EnableTransactionManagement
public class ApplicationContextConfig {

}
