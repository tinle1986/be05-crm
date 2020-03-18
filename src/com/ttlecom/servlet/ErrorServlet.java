package com.ttlecom.servlet;

import com.ttlecom.util.UrlConstant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "errorServlet", urlPatterns = {UrlConstant.ERROR_URL})
public class ErrorServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String servletPath = req.getServletPath();
		switch (servletPath) {
			case UrlConstant.ERROR_URL:
				req.getRequestDispatcher("/WEB-INF/views/error/404.jsp").forward(req, resp);
				break;
		}
	}
}
