package com.cos.crud.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	//.addPathPatterns("/**");
	//.excludePathPatterns("/user/*")
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new SessionInterceptor())
				    .addPathPatterns("/board/**")	// /board로 오는 건 모두 관리함
					.excludePathPatterns("/board/list")
					.excludePathPatterns("/board/detail/**");
		
//		registry.addInterceptor(new AdminInterceptor())
//		            .addPathPatterns("/admin/**");
					
	}
}