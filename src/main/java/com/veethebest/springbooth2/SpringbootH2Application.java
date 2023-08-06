package com.veethebest.springbooth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan({"com.veethebest.springbooth2.controller","com.veethebest.springbooth2.service"})
@EntityScan("com.veethebest.springbooth2.entity")
@EnableJpaRepositories("com.veethebest.springbooth2.repository")
@SpringBootApplication
public class SpringbootH2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootH2Application.class, args);
	}

}
