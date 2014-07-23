package com.skills421.filter.wrapper;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class PageNotFoundResponse extends HttpServletResponseWrapper
{

	public PageNotFoundResponse(HttpServletResponse response)
	{
		super(response);
	}

	@Override
	public void sendError(int sc,String msg) throws IOException
	{
		this.setStatus(sc);
	}
}
