package com.animal.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter(filterName="encodingSetter", urlPatterns="/*")
public class EncodingFilter implements Filter {
	@Override
	public void init(FilterConfig config) { }
	
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) 
					throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		chain.doFilter(req, resp);
	}
	
	
	@Override
	public void destroy() { }
}
