package com.andryanstgkr.parsamosir.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = { "com.andryanstgkr.parsamosir.api.service",
		"com.andryanstgkr.parsamosir.api.repository", "com.andryanstgkr.parsamosir.api.config", "com.andryanstgkr.parsamosir.api.security" })
@ComponentScan(basePackages = { "com.andryanstgkr.parsamosir.api.service", "com.andryanstgkr.parsamosir.api.repository",
		"com.andryanstgkr.parsamosir.api.controller", "com.andryanstgkr.parsamosir.api.config", "com.andryanstgkr.parsamosir.api.security" })
@EnableJpaRepositories(basePackages = { "com.andryanstgkr.parsamosir.api.repository" })
@EnableJpaAuditing
@EnableTransactionManagement
@EnableAspectJAutoProxy(proxyTargetClass = true)

public class ParsamosirApiApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ParsamosirApiApplication.class, args);
	}

}
