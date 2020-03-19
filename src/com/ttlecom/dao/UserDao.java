package com.ttlecom.dao;

import com.ttlecom.connection.JDBCConnection;
import com.ttlecom.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

	public User getUserByEmail(String email) {
		User user = new User();

		try {
			Connection conn = JDBCConnection.getInstance().getConnection();
			String query = "SELECT * FROM users WHERE email = ?";

			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, email);
			ResultSet res = statement.executeQuery();

			if (res.next()) {
				user.setId(res.getInt("id"));
				user.setFullname(res.getString("fullname"));
				user.setEmail(res.getString("email"));
				user.setRoleId(res.getInt("role_id"));
				user.setPassword(res.getString("password"));

				conn.close();
				return user;
			} else {
				conn.close();
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<User> getList() {
		List<User> users = new ArrayList<>();
		try {
			Connection conn = JDBCConnection.getInstance().getInstance().getConnection();
			String query = "SELECT * FROM users";

			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet res = statement.executeQuery();
			while (res.next()) {
				User user = new User();
				user.setId(res.getInt("id"));
				user.setFullname(res.getString("fullname"));
				user.setEmail(res.getString("email"));
				user.setRoleId(res.getInt("role_id"));
				users.add(user);
			}
			conn.close();
			return users;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public User getView(int id) {
		User user = new User();
		try {
			Connection conn = JDBCConnection.getInstance().getConnection();
			String query = "SELECT * FROM users WHERE id = ?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet res = statement.executeQuery();
			while (res.next()) {
				user.setId(id);
				user.setFullname(res.getString("fullname"));
				user.setEmail(res.getString("email"));
				user.setRoleId(res.getInt("role_id"));
			}
			conn.close();
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public User getUserById(int id) {
		User user = new User();
		try {
			Connection conn = JDBCConnection.getInstance().getConnection();
			String query = "SELECT * FROM users WHERE id = ?";

			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet res = statement.executeQuery();
			while (res.next()) {
				user.setId(id);
				user.setFullname(res.getString("fullname"));
				user.setEmail(res.getString("email"));
				user.setRoleId(res.getInt("role_id"));
			}
			conn.close();
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void getDelete(int id) {
		try {
			Connection conn = JDBCConnection.getInstance().getConnection();
			String query = "DELETE FROM users WHERE id = ?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, id);
			statement.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void add(User user) {
		try {
			Connection conn = JDBCConnection.getInstance().getConnection();
			String query = "INSERT INTO users(email, password, fullname, role_id) VALUES(?, ?, ?, ?)";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, user.getEmail());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getFullname());
			statement.setInt(4, user.getRoleId());
			statement.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(User user) {
		try {
			Connection conn = JDBCConnection.getInstance().getConnection();
			String query = "UPDATE users SET fullname = ?, email = ?, password = ?, role_id = ? WHERE id = ?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, user.getFullname());
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getPassword());
			statement.setInt(4, user.getRoleId());
			statement.setInt(5, user.getId());
			statement.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
