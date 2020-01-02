package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javabean.Employee;
import javabean.User;
import utils.C3P0_Util;

public class UserDAO {
	
	//登陆
	public User find(String username,String password,int id){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = null;
		try {
			conn = C3P0_Util.getConnection();
			String sql = "select * from user where username=? and password=? and id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setInt(3, id);
			rs = pstmt.executeQuery();
			while(rs.next()){
				user = new User();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setId(rs.getInt("id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			C3P0_Util.release(conn, pstmt, rs);
		}
		return user;
	}
	//主管员工登陆
	public Employee find1(String username,String password,String job){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Employee employee = null;
		try {
			conn = C3P0_Util.getConnection();
			String sql = "select * from employee where name=? and password=? and job=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setString(3, job);
			rs = pstmt.executeQuery();
			while(rs.next()){
				employee = new Employee();
				employee.setName(rs.getString("name"));
				employee.setPassword(rs.getString("password"));
				employee.setJob(rs.getString("job"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			C3P0_Util.release(conn, pstmt, rs);
		}
		return employee;
	}	
}
	
	

