package com.demo.config;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { AppConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { WebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/rest/*" };
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		super.onStartup(servletContext);

	}

	@Override
	protected Filter[] getServletFilters() {
		// Filter to set character encoding
		CharacterEncodingFilter charFilter = new CharacterEncodingFilter();
		charFilter.setEncoding("UTF-8");
		charFilter.setForceEncoding(true);

		// SecurityContextHolder used to keep track of logged in user and below
		// filter makes sure the logged in user survives the multiple request
		// (like session)

		return new Filter[] { new HiddenHttpMethodFilter(), charFilter };
	}

}