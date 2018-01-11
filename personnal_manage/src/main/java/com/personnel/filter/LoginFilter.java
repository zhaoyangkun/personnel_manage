package com.personnel.filter;

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
import javax.servlet.http.HttpSession;

import com.personnel.entity.User;

/**
 * 登录过滤器
 */
@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {

    public LoginFilter() {
       
    }

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpServletResponse servletResponse = (HttpServletResponse) response;
		HttpSession session = servletRequest.getSession(true);
		User user = null;
		if(session != null) {
			user = (User) session.getAttribute("user");
		}
		String URL = servletRequest.getRequestURI();
		String path = servletRequest.getContextPath();  
		String contextPath = servletRequest.getContextPath();
        String basePath = request.getScheme()+"://"+servletRequest.getServerName()+":"+servletRequest.getServerPort()+path;
        System.out.println("URL: " + URL);
        System.out.println("contextPath: " +  contextPath);
        if(user != null) {
        	System.out.println("已经登录");
        	chain.doFilter(request, response);
        }else {
        	if(URL.equals(contextPath + "/") || URL.contains("/loginDisp") || URL.contains("/login") ||  URL.contains("/css") || URL.contains("/H-ui") || URL.contains("/img") || URL.contains("/js")) {
        		System.out.println("屏蔽路径");
    			chain.doFilter(request, response);
        	}else {
        		System.out.println("非法URL");
				servletResponse.sendRedirect(basePath + "/basic/loginDisp");
        	}
        }
	}


	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
