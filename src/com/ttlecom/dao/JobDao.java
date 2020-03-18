package com.ttlecom.dao;

import com.ttlecom.connection.JDBCConnection;
import com.ttlecom.model.Job;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class JobDao {
	public List<Job> getList() {
		List<Job> jobs = new ArrayList<>();
		try {
			Connection conn = JDBCConnection.getInstance().getConnection();
			String query = "SELECT * FROM jobs";
			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet res = statement.executeQuery();
			while (res.next()) {
				Job job = new Job();
				job.setId(res.getInt("id"));
				job.setName(res.getString("name"));
				job.setStartTime(res.getDate("start_date"));
				job.setEndTime(res.getDate("end_date"));
				jobs.add(job);
			}
			conn.close();
			return jobs;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void getDelete(int id) {
		try {
			Connection conn = JDBCConnection.getInstance().getConnection();
			String query = "DELETE FROM jobs WHERE id=?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, id);
			statement.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Job getJobById(int id) {
		Job job = new Job();
		try {
			Connection conn = JDBCConnection.getInstance().getConnection();
			String query = "SELECT * FROM jobs WHERE id= ?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet res = statement.executeQuery();
			while (res.next()) {
				job.setId(res.getInt("id"));
				job.setName(res.getString("name"));
				job.setStartTime(res.getDate("start_date"));
				job.setEndTime(res.getDate("end_date"));
			}
			conn.close();
			return job;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Job getView(int id) {
		Job job = new Job();
		try {
			Connection conn = JDBCConnection.getInstance().getConnection();
			String query = "SELECT * FROM jobs WHERE id = ?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet res = statement.executeQuery();
			while (res.next()) {
				job.setId(res.getInt("id"));
				job.setName(res.getString("name"));
				job.setStartTime(res.getDate("start_date"));
				job.setEndTime(res.getDate("end_date"));
			}
			conn.close();
			return job;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void add(Job job) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String startTimeStr = df.format(job.getStartTime());
		String endTimeStr = df.format(job.getEndTime());
		try {
			Connection conn = JDBCConnection.getInstance().getConnection();
			String query = "insert into jobs(name, start_date, end_date) values (?, ?, ?)";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, job.getName());
			statement.setString(2, startTimeStr);
			statement.setString(3, endTimeStr);
			statement.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(Job job) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String startTimeStr = df.format(job.getStartTime());
		String endTimeStr = df.format(job.getEndTime());
		try {
			Connection conn = JDBCConnection.getInstance().getConnection();
			String query = "UPDATE jobs SET name = ?, start_date = ?, end_date = ? WHERE id = ?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, job.getName());
			statement.setString(2, startTimeStr);
			statement.setString(3, endTimeStr);
			statement.setInt(4, job.getId());
			statement.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
