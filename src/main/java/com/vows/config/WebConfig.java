package com.vows.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @project:webasic
 * @description:用于替代项目的配置文件
 * @authur:nis36
 * 2017年1月24日-下午2:00:58
 * 2017  PD.Sp Center   -版权所有
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.vows")
public class WebConfig extends WebMvcConfigurerAdapter{
	@Bean // 配置视图解析器
	public ViewResolver viewResolver(){ 
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setPrefix("/WEB-INF/pages/");
		vr.setSuffix(".jsp");
		vr.setExposeContextBeansAsAttributes(true);
		return vr;
	}
}
