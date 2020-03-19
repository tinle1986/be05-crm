package com.ttlecom.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "loginFilter", urlPatterns = "/*")
public class loginFilter extends HttpFilter {

	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		// before filter
		request.setCharacterEncoding("UTF-8");
		System.out.println("Before Filter");
		HttpSession userSession = request.getSession();


//		if (userSession.getAttribute("LOGIN_USER") == null && !request.getServletPath().startsWith("/login")) {
//			response.sendRedirect(request.getContextPath() + "/login");
//		} else {
//			chain.doFilter(request, response);
//			response.setCharacterEncoding("UTF-8");
//		}

		if (userSession.getAttribute("LOGIN_USER") == null) {
			if (!request.getServletPath().startsWith("/login")) {
				response.sendRedirect(request.getContextPath() + "/login");
			} else {
				response.setCharacterEncoding("UTF-8");
				chain.doFilter(request, response);
			}
		} else {
			if ((Integer) userSession.getAttribute("ROLE_ID_USER") != 1) {
				if (request.getServletPath().startsWith("/role") || request.getServletPath().startsWith("/user")) {
					response.sendRedirect(request.getContextPath() + "/dashboard");
				} else {
					response.setCharacterEncoding("UTF-8");
					chain.doFilter(request, response);
				}
			} else {
				response.setCharacterEncoding("UTF-8");
				chain.doFilter(request, response);
			}
		}


		// after filter
		System.out.println("After Filter");
	}
}
