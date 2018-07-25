package com.bridgelabz.note.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bridgelabz.note.interceptors.ValidationInterceptor;
import com.bridgelabz.note.utility.NoteHelper;
import com.bridgelabz.note.utility.ResponseHelper;
import com.bridgelabz.note.utility.TokenHelper;

@Configuration
public class ApplicationConfig {

	@Bean
	public ResponseHelper responseHelper() {

		return new ResponseHelper();
	}
	
	@Bean
	public NoteHelper noteHelper() {

		return new NoteHelper();
	}
	
	@Bean
	public ModelMapper modelMapper() {

		return new ModelMapper();
	}
	
	@Bean
	public TokenHelper tokenHelper() {

		return new TokenHelper();
	}
	
	@Bean
	public ValidationInterceptor validationInterceptor() {

		return new ValidationInterceptor();
	}
	
}