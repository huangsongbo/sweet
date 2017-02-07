package com.amu;

import javax.servlet.Filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.amu.filter.MyFilter;

@SpringBootApplication
public class SweetApplication {

	public static void main(String[] args) {
		SpringApplication.run(SweetApplication.class, args);
	}
	
	@Bean
	public Filter getMyFilter(){
		return new MyFilter();
	}
	
}
