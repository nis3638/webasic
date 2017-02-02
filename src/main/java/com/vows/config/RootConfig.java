package com.vows.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @project:webasic
 * @description:applicationContext.xml
 * @authur:nis36
 * 2017年1月26日-上午11:34:55
 * 2017  PD.Sp Center   -版权所有
 */
@Configuration
@ComponentScan(basePackages={"com.vows"},excludeFilters={@Filter(type=FilterType.ANNOTATION,value=EnableWebMvc.class)})
public class RootConfig {

}
