package com.ttlecom.servlet;

import com.ttlecom.dao.RoleDao;
import com.ttlecom.model.Role;
import com.ttlecom.util.UrlConstant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "roleServlet", urlPatterns = {UrlConstant.ROLE_URL, UrlConstant.ROLE_ADD_URL, UrlConstant.ROLE_DELETE_URL, UrlConstant.ROLE_EDIT_URL})
public class RoleServlet extends HttpServlet {
	private RoleDao roleDao;

	@Override
	public void init() throws ServletException {
		super.init();
		roleDao = new RoleDao();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String servletPath = req.getServletPath();
		switch (servletPath) {
			case UrlConstant.ROLE_URL:
				getList(req, resp);
				break;
			case UrlConstant.ROLE_ADD_URL:
				getAdd(req, resp);
				break;
			case UrlConstant.ROLE_EDIT_URL:
				getEdit(req, resp);
				break;
			case UrlConstant.ROLE_DELETE_URL:
				getDelete(req, resp);
				break;
			default:
				break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String servletPath = req.getServletPath();
		switch (servletPath) {
			case UrlConstant.ROLE_ADD_URL:
				postAdd(req, resp);
				break;
			case UrlConstant.ROLE_EDIT_URL:
				postEdit(req, resp);
				break;
			default:
				break;
		}
	}

	private void getList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Role> roles = roleDao.getList();
		req.setAttribute("roles", roles);
		req.getRequestDispatcher("/WEB-INF/views/role/role_table.jsp").forward(req, resp);
	}

	private void getAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/role/role_add.jsp").forward(req, resp);
	}

	private void getEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		Role role = roleDao.getRoleById(id);
		req.setAttribute("role", role);
		req.getRequestDispatcher("/WEB-INF/views/role/role_edit.jsp").forward(req, resp);
	}

	private void getDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		roleDao.getDelete(id);

		resp.sendRedirect(req.getContextPath() + "/role");
	}

	private void postAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String name = req.getParameter("name");
		String description = req.getParameter("description");
		Role role = new Role(name, description);

		roleDao.add(role);

		resp.sendRedirect(req.getContextPath() + "/role");
	}

	private void postEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String description = req.getParameter("description");

		Role role = new Role(id, name, description);
		roleDao.update(role);

		resp.sendRedirect(req.getContextPath() + "/role");
	}
}
