package com.dio.springbootconfig.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import lombok.Getter;
import lombok.Setter;

@Configuration
@ConfigurationProperties("spring.datasource")
@Getter
@Setter
public class DBConfiguration {
	private String driverClassName;
	private String url;
	private String username;
	private String password;
	
	@Profile("dev")
	@Bean //para mostrar todo o conteudo mapeado logo na subida do sistema com o Tomcat
	public String testDataBaseConnection() {
		System.out.println("DB connection for DEV - H2");
		System.out.println(driverClassName);
		System.out.println(url);
		return "DB Connection to H2_TEST - Test instance";
	}
	
	@Profile("prod")
	@Bean //para mostrar todo o conteudo mapeado logo na subida do sistema com o Tomcat
	public String productionDataBaseConnection() {
		System.out.println("DB connection for PROD - MYSQL");
		System.out.println(driverClassName);
		System.out.println(url);
		return "DB Connection to MYSQL_PROD - Production instance";
	}
}
