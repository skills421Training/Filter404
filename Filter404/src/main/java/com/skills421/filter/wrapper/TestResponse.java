package com.skills421.filter.wrapper;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class TestResponse extends HttpServletResponseWrapper
{
	@Override
	public void addCookie(Cookie cookie)
	{
		System.out.println("TestResponse.addCookie");

		super.addCookie(cookie);
	}

	@Override
	public boolean containsHeader(String name)
	{
		System.out.println("TestResponse.containsHeader");

		return super.containsHeader(name);
	}

	@Override
	public String encodeURL(String url)
	{
		System.out.println("TestResponse.encodeURL");

		return super.encodeURL(url);
	}

	@Override
	public String encodeRedirectURL(String url)
	{
		System.out.println("TestResponse.encodeRedirectURL");

		return super.encodeRedirectURL(url);
	}

	@Override
	public String encodeUrl(String url)
	{
		System.out.println("TestResponse.encodeUrl");

		return super.encodeUrl(url);
	}

	@Override
	public String encodeRedirectUrl(String url)
	{
		System.out.println("TestResponse.encodeRedirectUrl");

		return super.encodeRedirectUrl(url);
	}

	@Override
	public void sendError(int sc, String msg) throws IOException
	{
		System.out.println("TestResponse.sendError");

		super.sendError(sc, msg);
	}

	@Override
	public void sendError(int sc) throws IOException
	{
		System.out.println("TestResponse.sendError");

		super.sendError(sc);
	}

	@Override
	public void sendRedirect(String location) throws IOException
	{
		System.out.println("TestResponse.sendRedirect");

		super.sendRedirect(location);
	}

	@Override
	public void setDateHeader(String name, long date)
	{
		System.out.println("TestResponse.setDateHeader");

		super.setDateHeader(name, date);
	}

	@Override
	public void addDateHeader(String name, long date)
	{
		System.out.println("TestResponse.addDateHeader");

		super.addDateHeader(name, date);
	}

	@Override
	public void setHeader(String name, String value)
	{
		System.out.println("TestResponse.setHeader");

		super.setHeader(name, value);
	}

	@Override
	public void addHeader(String name, String value)
	{
		System.out.println("TestResponse.addHeader");

		super.addHeader(name, value);
	}

	@Override
	public void setIntHeader(String name, int value)
	{
		System.out.println("TestResponse.setIntHeader");

		super.setIntHeader(name, value);
	}

	@Override
	public void addIntHeader(String name, int value)
	{
		System.out.println("TestResponse.addIntHeader");

		super.addIntHeader(name, value);
	}

	@Override
	public void setStatus(int sc)
	{
		System.out.println("TestResponse.setStatus");

		super.setStatus(sc);
	}

	@Override
	public void setStatus(int sc, String sm)
	{
		System.out.println("TestResponse.setStatus");

		super.setStatus(sc, sm);
	}

	@Override
	public int getStatus()
	{
		System.out.println("TestResponse.getStatus");

		return super.getStatus();
	}

	@Override
	public String getHeader(String name)
	{
		System.out.println("TestResponse.getHeader");

		return super.getHeader(name);
	}

	@Override
	public Collection<String> getHeaders(String name)
	{
		System.out.println("TestResponse.getHeaders");

		return super.getHeaders(name);
	}

	@Override
	public Collection<String> getHeaderNames()
	{
		System.out.println("TestResponse.getHeaderNames");

		return super.getHeaderNames();
	}

	@Override
	public ServletResponse getResponse()
	{
		System.out.println("TestResponse.getResponse");

		return super.getResponse();
	}

	@Override
	public void setResponse(ServletResponse response)
	{
		System.out.println("TestResponse.setResponse");

		super.setResponse(response);
	}

	@Override
	public void setCharacterEncoding(String charset)
	{
		System.out.println("TestResponse.setCharacterEncoding");

		super.setCharacterEncoding(charset);
	}

	@Override
	public String getCharacterEncoding()
	{
		System.out.println("TestResponse.getCharacterEncoding");

		return super.getCharacterEncoding();
	}

	@Override
	public ServletOutputStream getOutputStream() throws IOException
	{
		System.out.println("TestResponse.getOutputStream");

		return super.getOutputStream();
	}

	@Override
	public PrintWriter getWriter() throws IOException
	{
		System.out.println("TestResponse.getWriter");

		return super.getWriter();
	}

	@Override
	public void setContentLength(int len)
	{
		System.out.println("TestResponse.setContentLength");

		super.setContentLength(len);
	}

	@Override
	public void setContentLengthLong(long len)
	{
		System.out.println("TestResponse.setContentLengthLong");

		super.setContentLengthLong(len);
	}

	@Override
	public void setContentType(String type)
	{
		System.out.println("TestResponse.setContentType");

		super.setContentType(type);
	}

	@Override
	public String getContentType()
	{
		System.out.println("TestResponse.getContentType");

		return super.getContentType();
	}

	@Override
	public void setBufferSize(int size)
	{
		System.out.println("TestResponse.setBufferSize");

		super.setBufferSize(size);
	}

	@Override
	public int getBufferSize()
	{
		System.out.println("TestResponse.getBufferSize");

		return super.getBufferSize();
	}

	@Override
	public void flushBuffer() throws IOException
	{
		System.out.println("TestResponse.flushBuffer");

		super.flushBuffer();
	}

	@Override
	public boolean isCommitted()
	{
		System.out.println("TestResponse.isCommitted");

		return super.isCommitted();
	}

	@Override
	public void reset()
	{
		System.out.println("TestResponse.reset");

		super.reset();
	}

	@Override
	public void resetBuffer()
	{
		System.out.println("TestResponse.resetBuffer");

		super.resetBuffer();
	}

	@Override
	public void setLocale(Locale loc)
	{
		System.out.println("TestResponse.setLocale");

		super.setLocale(loc);
	}

	@Override
	public Locale getLocale()
	{
		System.out.println("TestResponse.getLocale");

		return super.getLocale();
	}

	@Override
	public boolean isWrapperFor(ServletResponse wrapped)
	{
		System.out.println("TestResponse.isWrapperFor");

		return super.isWrapperFor(wrapped);
	}

	@Override
	public boolean isWrapperFor(Class<?> wrappedType)
	{
		System.out.println("TestResponse.isWrapperFor");

		return super.isWrapperFor(wrappedType);
	}

	public TestResponse(HttpServletResponse response)
	{
		super(response);
		
		System.out.println("TestResponse()");

	}

	
}
