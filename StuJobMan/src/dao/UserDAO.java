package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean.User;
import util.DBConnection;

public class UserDAO {
	private Connection conn = null;
	private Statement st = null;
	
	public UserDAO() {
		conn = DBConnection.getConnection();
		try {
			st = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ����û�������
	 */
	public User check(String username, String cs) {
		String sql = "select * from user where username='" + username + "' and password='" + cs + "'";
		ResultSet rs;//����һ�������
		User user = null;//����һ��User����
		try {
			rs = st.executeQuery(sql);//�����ݿ���ִ��sql���
			if(rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setRole(rs.getString("role"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
}
