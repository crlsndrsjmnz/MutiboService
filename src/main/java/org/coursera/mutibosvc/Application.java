/* 
 **
 ** Copyright 2014, 
 ** Carlos Andres Jimenez
 ** apps@carlosandresjimenez.co
 ** 
 */
package org.coursera.mutibosvc;

import org.coursera.mutibosvc.controller.SecurityInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan
@EnableWebMvc
public class Application extends WebMvcConfigurerAdapter {

	// We do not have the typical main method because we need
	// the Maven AppEngine plugin to launch / configure the
	// development server. However, we are still using this
	// class to define configuration information.

	@Bean
	public SecurityInterceptor securityInterceptor() {
		return new SecurityInterceptor();
	}

	@Override
	public void addInterceptors(final InterceptorRegistry registry) {
		registry.addInterceptor(securityInterceptor())
				.addPathPatterns("/**")
				.excludePathPatterns("/oauth/**");
	}

}
