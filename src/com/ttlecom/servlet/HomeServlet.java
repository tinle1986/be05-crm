package com.ttlecom.servlet;

import com.ttlecom.util.UrlConstant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "homeServlet", urlPatterns = {UrlConstant.HOME_URL, UrlConstant.DASHBOARD_URL})
public class HomeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String servletPath = req.getServletPath();

		// 0. check user whether logged in or not
		HttpSession userSession = req.getSession();

		if (userSession.getAttribute("LOGIN_USER") == null) {
			resp.sendRedirect(req.getContextPath() + "/login");
		} else {
			switch (servletPath) {
				case UrlConstant.HOME_URL:
					req.getRequestDispatcher("index.jsp").forward(req, resp);
					break;
				case UrlConstant.DASHBOARD_URL:
					req.getRequestDispatcher("index.jsp").forward(req, resp);
					break;
			}
		}
	}
}
