package edu.osu.cse5234.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"edu.osu.cse5234.controller"})
public class MyWebConfig extends WebMvcConfigurerAdapter{
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		super.configureViewResolvers(registry);
		registry.jsp("/WEB-INF/jsp/", ".jsp");
	}
	
}
