package com.ttlecom.dao;

import com.ttlecom.connection.JDBCConnection;
import com.ttlecom.model.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoleDao {
	public List<Role> getList() {
		List<Role> roles = new ArrayList<>();
		try {
			Connection conn = JDBCConnection.getInstance().getConnection();
			String query = "SELECT * FROM roles";

			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet res = statement.executeQuery();
			while (res.next()) {
				Role role = new Role();
				role.setId(res.getInt("id"));
				role.setName(res.getString("name"));
				role.setDescription(res.getString("description"));
				roles.add(role);
			}
			conn.close();
			return roles;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void getDelete(int id) {
		try {
			Connection conn = JDBCConnection.getInstance().getConnection();
			String query = "DELETE FROM roles WHERE id = ?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, id);
			statement.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Role getRoleById(int id) {
		try {
			Connection conn = JDBCConnection.getInstance().getConnection();
			String query = "SELECT * FROM roles WHERE id = ?";

			Role role = new Role();

			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet res = statement.executeQuery();
			while (res.next()) {
				role.setId(res.getInt("id"));
				role.setName(res.getString("name"));
				role.setDescription(res.getString("description"));
			}
			conn.close();
			return role;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public void update(Role role) {
		try {
			Connection conn = JDBCConnection.getInstance().getConnection();
			String query = "UPDATE roles SET name = ?, description = ? WHERE id = ?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, role.getName());
			statement.setString(2, role.getDescription());
			statement.setInt(3, role.getId());
			statement.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void add(Role role) {
		try {
			Connection conn = JDBCConnection.getInstance().getConnection();
			String query = "INSERT INTO roles(name, description) VALUES(?, ?)";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, role.getName());
			statement.setString(2, role.getDescription());
			statement.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
