package com.ttlecom.servlet;

import com.ttlecom.dao.UserDao;
import com.ttlecom.model.User;
import com.ttlecom.util.UrlConstant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "loginServlet", urlPatterns = {UrlConstant.LOGIN_URL})
public class LoginServlet extends HttpServlet {

	private UserDao userDao;

	@Override
	public void init() throws ServletException {
		super.init();
		userDao = new UserDao();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String servletPath = req.getServletPath();

		// 0. check user whether logged in or not
		HttpSession userSession = req.getSession();

		if (userSession.getAttribute("LOGIN_USER") != null) {
			resp.sendRedirect(req.getContextPath() + "/dashboard");
		} else {
			switch (servletPath) {
				case UrlConstant.LOGIN_URL:
					req.getRequestDispatcher("/WEB-INF/views/login/login.jsp").forward(req, resp);
					break;
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String contextPath = req.getContextPath();

		// 1. get username & password from client interface
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		// 2. get username & password from database
		User userGetFromDb = userDao.getUserByEmail(email);

		// 3. check if username and password match from database and client site
		if (userGetFromDb == null) {
			req.setAttribute("message", "Email doesn't exist in the system!");
			req.setAttribute("email", email);
			req.getRequestDispatcher("/WEB-INF/views/login/login.jsp").forward(req, resp);
			System.out.println("Email is not existed!");
		} else if (userGetFromDb.getPassword().equals(password)) {
			HttpSession session = req.getSession();
			session.setAttribute("LOGIN_USER", userGetFromDb.getEmail());
			session.setAttribute("ROLE_ID_USER", userGetFromDb.getRoleId());
			session.setAttribute("FULLNAME_USER", userGetFromDb.getFullname());
			session.setMaxInactiveInterval(60*60);
			resp.sendRedirect(contextPath + "/dashboard");
		} else {
			req.setAttribute("incorrect", "Password is incorrect!");
			req.setAttribute("email", email);
			req.getRequestDispatcher("/WEB-INF/views/login/login.jsp").forward(req, resp);
		}

		// 3.1 if correct: redirect -> dashboard page

		// 3.2 if incorrect: forward user -> login page again

		/*System.out.println(email);
		System.out.println(password);


		if (email.equals("admin") && password.equals("admin")) {
//			req.getRequestDispatcher("index.jsp").forward(req, resp);
			resp.sendRedirect(contextPath);
		} else {
			req.getRequestDispatcher("/WEB-INF/views/login/login.jsp").forward(req, resp);
		}*/
	}
}
