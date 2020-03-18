package com.ttlecom.servlet;

import com.ttlecom.dao.JobDao;
import com.ttlecom.model.Job;
import com.ttlecom.util.UrlConstant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "jobServlet", urlPatterns = {UrlConstant.JOB_URL, UrlConstant.JOB_ADD_URL, UrlConstant.JOB_DELETE_URL, UrlConstant.JOB_EDIT_URL, UrlConstant.JOB_VIEW_URL})
public class JobServlet extends HttpServlet {
	private JobDao jobDao;

	@Override
	public void init() throws ServletException {
		super.init();
		jobDao = new JobDao();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String servletPath = req.getServletPath();
		switch (servletPath) {
			case UrlConstant.JOB_URL:
				getList(req, resp);
				break;
			case UrlConstant.JOB_ADD_URL:
				getAdd(req, resp);
				break;
			case UrlConstant.JOB_DELETE_URL:
				getDelete(req, resp);
				break;
			case UrlConstant.JOB_EDIT_URL:
				getEdit(req, resp);
				break;
			case UrlConstant.JOB_VIEW_URL:
				getView(req, resp);
				break;
			default:
				break;
		}
	}

	public void getList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Job> jobs = jobDao.getList();
		req.setAttribute("jobs", jobs);
		req.getRequestDispatcher("/WEB-INF/views/job/job_table.jsp").forward(req, resp);
	}

	public void getAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/job/job_add.jsp").forward(req, resp);
	}

	public void getDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		jobDao.getDelete(id);
		resp.sendRedirect(req.getContextPath() + "/job");
	}

	public void getEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		Job job = jobDao.getJobById(id);
		req.setAttribute("job", job);
		req.getRequestDispatcher("/WEB-INF/views/job/job_edit.jsp").forward(req, resp);
	}

	public void getView(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		Job job = jobDao.getView(id);
		req.setAttribute("job", job);
		req.getRequestDispatcher("/WEB-INF/views/job/job_detail.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String servletPath = req.getServletPath();
		switch (servletPath) {
			case UrlConstant.JOB_ADD_URL:
				try {
					postAdd(req, resp);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				break;
			case UrlConstant.JOB_EDIT_URL:
				try {
					postEdit(req, resp);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				break;
			default:
				break;

		}
	}

	public void postAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ParseException {
		req.setCharacterEncoding("UTF-8");
		String name = req.getParameter("name");
		Date startTime = new SimpleDateFormat("dd/MM/yyyy").parse(req.getParameter("startTime"));
		Date endTime = new SimpleDateFormat("dd/MM/yyyy").parse(req.getParameter("endTime"));
		Job job = new Job(name, startTime, endTime);
		jobDao.add(job);
		resp.sendRedirect(req.getContextPath() + "/job");
	}

	public void postEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ParseException {
		req.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		Date startTime = new SimpleDateFormat("dd/MM/yyyy").parse(req.getParameter("startTime"));
		Date endTime = new SimpleDateFormat("dd/MM/yyyy").parse(req.getParameter("endTime"));
		Job job = new Job(id, name, startTime, endTime);
		jobDao.update(job);
		resp.sendRedirect(req.getContextPath() + "/job");
	}
}
