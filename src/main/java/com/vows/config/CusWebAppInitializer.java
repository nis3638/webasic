package com.vows.config;

import javax.servlet.Filter;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @project:webasic
 * @description:代替web.xml中的 springContextListener 和  dispatcherServlet的配置
 * @authur:nis36
 * 2017年1月24日-下午4:58:20
 * 2017  PD.Sp Center   -版权所有
 */
public class CusWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[]{RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[]{WebConfig.class};// mvc 配置
	}

	@Override   
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[]{"/"};
	}
	
	@Override  //过滤器
	protected Filter[] getServletFilters() { 
		return new Filter[]{new org.springframework.web.filter.CharacterEncodingFilter("UTF-8")};
	}

}
