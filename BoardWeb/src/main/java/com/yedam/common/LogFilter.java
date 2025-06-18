package com.yedam.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LogFilter implements Filter{

	public LogFilter() {
		System.out.println("필터객체 생성.");
	}
	
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) //filterchain 필터의 모든정보 담은 객체
			throws IOException, ServletException {
		System.out.println("서블릿 실행전");
		
		String host = req.getRemoteAddr();
		String port = "" + req.getRemotePort(); //port int타입이라서 "" +로 string화
		//System.out.println("접속 HOST : " + host + " PORT= " + port);
		
		HttpServletRequest request = (HttpServletRequest) req;   //req를 httpServlet으로 캐스팅
		String uri = request.getRequestURI();
		String context = request.getContextPath();
		String page = uri.substring(context.length());
		System.out.println("IP: "+ host + ", Page: "+page);
		//host.equals("192.168.0.14") && host.equals("192.168.0.1")
		
		if(!host.equals("0:0:0:0:0:0:0:1")) {
			return; 		// 17번 host가 접속시 doFilter가 적용안됨.
		}
		
		chain.doFilter(req, resp); 		//doFilter 후 서블릿 실행.
		
		
		System.out.println("서블릿 실행후.");
		
	}

}
