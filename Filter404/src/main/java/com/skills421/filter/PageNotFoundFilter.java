package com.skills421.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

import com.skills421.filter.wrapper.PageNotFoundResponse;

/**
 * Servlet Filter implementation class PageNotFoundFilter
 */
@WebFilter(filterName = "PageNotFoundFilter", urlPatterns = {"/*"})
public class PageNotFoundFilter implements Filter
{

	/**
	 * Default constructor.
	 */
	public PageNotFoundFilter()
	{
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy()
	{
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
	{
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		PageNotFoundResponse pageNotFoundResponse = new PageNotFoundResponse(httpResponse);
		
		chain.doFilter(request, pageNotFoundResponse);
				
		if (pageNotFoundResponse.getStatus() == HttpServletResponse.SC_NOT_FOUND)
		{
			httpResponse.getWriter().write("404 Error Successfully Intercepted");
			httpResponse.setStatus(HttpServletResponse.SC_OK);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException
	{
	}

}
