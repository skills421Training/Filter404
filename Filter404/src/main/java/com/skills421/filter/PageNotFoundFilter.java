package com.skills421.filter;

import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skills421.filter.wrapper.PageNotFoundResponse;

/**
 * Servlet Filter implementation class PageNotFoundFilter
 */
@WebFilter(filterName = "PageNotFoundFilter", urlPatterns = {"/*"})
public class PageNotFoundFilter implements Filter
{
	private void writeFile(String fullpath, String content) throws IOException
	{
		System.out.println(fullpath);
		
		FileWriter fw = new FileWriter(fullpath);
		fw.write(content);
		fw.flush();
		fw.close();
	}
	
	private String buildPageBody(int contentNo)
	{
		StringBuilder htmlContentSB = new StringBuilder();
		htmlContentSB
		.append("<h2>Content 0")
		.append(contentNo)
		.append("</h2>")
		.append("<p>")
		.append("This is the content for page ")
		.append(contentNo)
		.append("</p>")
		.append("<p>");
		
		if(contentNo>1)
		{
			htmlContentSB
			.append("<a href='content0")
			.append(contentNo-1)
			.append(".html'>");
		}
		
		htmlContentSB.append("previous");
		
		if(contentNo>1)
		{
			htmlContentSB.append("</a>");
		}
		
		htmlContentSB.append(" - ");
		
		if(contentNo<9)
		{
			htmlContentSB
			.append("<a href='content0")
			.append(contentNo+1)
			.append(".html'>");
		}
		
		htmlContentSB.append("next");
		
		if(contentNo<9)
		{
			htmlContentSB.append("</a>");
		}
		
		htmlContentSB
		.append("</p>");
		
		return htmlContentSB.toString();
	}

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
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
				
		String path = httpRequest.getServletPath();
		
		//
		// -- if we don't have page content01.html - content09.html
		// -- then process the page using the default mechanism
		//
		
		if(!path.matches("/content0[1-9].html"))
		{
			chain.doFilter(request, response);
			return;
		}
		
		//
		// -- we have a valid content page so we need to wrap the response
		// -- incase the page cannot be found and we need to modify the response
		// -- ourselves on the way back from the Server
		
		PageNotFoundResponse pageNotFoundResponse = new PageNotFoundResponse(httpResponse);
		
		//
		// -- pass the request up the chain
		//
		
		chain.doFilter(request, pageNotFoundResponse);
		
		//
		// -- now we are processing the response
		// -- coming back from the server
		//
		
		//
		// -- if the page has not been found we need to generate it
		//
				
		if (pageNotFoundResponse.getStatus() == HttpServletResponse.SC_NOT_FOUND)
		{
			
			//
			// -- determine the content number of the page (01 to 09)
			//
			
			int startIdx = path.indexOf("content")+"content".length();
			int endIdx = startIdx +2;
			
			int contentNo = Integer.parseInt(path.substring(startIdx,endIdx));
			
			//
			// -- build the content and write the page contentxx.html
			//
			
			StringBuilder htmlContentSB = new StringBuilder();
			htmlContentSB
			.append("<html><body>")
			.append(this.buildPageBody(contentNo))
			.append("</body> </html>");
			
			String pagename = String.format("/content0%d.html", contentNo);
			String fullpath = httpRequest.getServletContext().getRealPath(pagename);
						
			this.writeFile(fullpath, htmlContentSB.toString());
			
			//
			// -- return to the customer a slightly different content
			// -- to that we wrote to contentxx.html
			// -- this content tells the user the content is GENERATED CONTENT
			//
			
			htmlContentSB = new StringBuilder();
			htmlContentSB
			.append("<html><body>")
			.append(this.buildPageBody(contentNo))
			.append("<p><strong>GENERATED CONTENT</strong></p>")
			.append("</body> </html>");
			
			//
			// -- set the response content
			// -- set the page status from 404 (not found) to 200 (OK)
			//
			
			httpResponse.getWriter().write(htmlContentSB.toString());
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
