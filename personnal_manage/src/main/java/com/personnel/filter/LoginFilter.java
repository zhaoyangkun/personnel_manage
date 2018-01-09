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
		User user = (User) session.getAttribute("user");
		String URL = servletRequest.getRequestURI();
		String path = servletRequest.getContextPath();  
        String basePath = request.getScheme()+"://"+servletRequest.getServerName()+":"+servletRequest.getServerPort()+path;  
		if(URL.indexOf("/loginDisp") > -1) {
			chain.doFilter(request, response);
		}		
		if(user.getId() != null) {
			/*chain.doFilter(request, response);*/
		}
		else {
			servletResponse.sendRedirect(basePath + "/basic/loginDisp");
		}
	}


	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
