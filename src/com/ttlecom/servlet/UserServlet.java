package com.ttlecom.servlet;

import com.ttlecom.dao.UserDao;
import com.ttlecom.model.User;
import com.ttlecom.util.UrlConstant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "userServlet", urlPatterns = {UrlConstant.USER_URL, UrlConstant.USER_ADD_URL, UrlConstant.USER_EDIT_URL, UrlConstant.USER_DELETE_URL, UrlConstant.USER_VIEW_URL})
public class UserServlet extends HttpServlet {
	private UserDao userDao;

	@Override
	public void init() throws ServletException {
		super.init();
		userDao = new UserDao();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String servletPath = req.getServletPath();
		switch (servletPath) {
			case UrlConstant.USER_URL:
				getList(req, resp);
				break;
			case UrlConstant.USER_ADD_URL:
				getAdd(req, resp);
				break;
			case UrlConstant.USER_EDIT_URL:
				getEdit(req, resp);
				break;
			case UrlConstant.USER_DELETE_URL:
				getDelete(req, resp);
				break;
			case UrlConstant.USER_VIEW_URL:
				getView(req, resp);
				break;
			default:
				break;
		}
	}

	private void getList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<User> users = userDao.getList();
		req.setAttribute("users", users);
		req.getRequestDispatcher("/WEB-INF/views/user/user_table.jsp").forward(req, resp);
	}

	private void getAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/user/user_add.jsp").forward(req, resp);
	}

	private void getView(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		User user = userDao.getView(id);
		req.setAttribute("user", user);
		req.getRequestDispatcher("/WEB-INF/views/user/user_detail.jsp").forward(req, resp);
	}

	private void getEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		User user = userDao.getUserById(id);
		req.setAttribute("user", user);
		req.getRequestDispatcher("/WEB-INF/views/user/user_edit.jsp").forward(req, resp);
	}

	private void getDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		userDao.getDelete(id);
		resp.sendRedirect(req.getContextPath() + "/user");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String servletPath = req.getServletPath();
		switch (servletPath) {
			case UrlConstant.USER_ADD_URL:
				postAdd(req, resp);
				break;
			case UrlConstant.USER_EDIT_URL:
				postEdit(req, resp);
				break;
			default:
				break;
		}
	}

	private void postAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String email = req.getParameter("email");
		String fullname = req.getParameter("fullname");
		String password = req.getParameter("password");
		int roleId = Integer.parseInt(req.getParameter("roleId"));
		User user = new User(email, password, fullname, roleId);
		userDao.add(user);
		resp.sendRedirect(req.getContextPath() + "/user");
	}

	private void postEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(req.getParameter("id"));
		String fullname = req.getParameter("fullname");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		int roleId = Integer.parseInt(req.getParameter("roleId"));
		User user = new User(id, email, password, fullname, roleId);
		userDao.update(user);
		resp.sendRedirect(req.getContextPath() + "/user");
	}
}
