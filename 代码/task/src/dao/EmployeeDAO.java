package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javabean.Employee;

import utils.C3P0_Util;

public class EmployeeDAO {
	//查看全部员工信息
	public List<Employee> findAll(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Employee> list = new ArrayList<Employee>();
		try {
			conn = C3P0_Util.getConnection();
			String sql = "select * from employee ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Employee em = new Employee();
				em.setId(rs.getInt("id"));
				em.setPassword(rs.getString("password"));
				em.setName(rs.getString("name"));
				em.setSex(rs.getString("sex"));
				em.setBirthday(rs.getDate("birthday"));
				em.setJob(rs.getString("job"));
				em.setSchool(rs.getString("school"));
				em.setTime(rs.getDate("time"));
				em.setTitle(rs.getString("title"));
				list.add(em);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			C3P0_Util.release(conn, pstmt, rs);
		}
		return list;
	}
	//查看员工具体信息
	public Employee check(int id){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = C3P0_Util.getConnection();
			String sql = "select * from employee where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()){
			  Employee em = new Employee();
		      em.setId(rs.getInt("id"));
		      em.setPassword(rs.getString("password"));
		      em.setName(rs.getString("name"));
			  em.setSex(rs.getString("sex"));
			  em.setBirthday(rs.getDate("birthday"));
			  em.setJob(rs.getString("job"));
			  em.setSchool(rs.getString("school"));
			  em.setTime(rs.getDate("time"));
			  em.setTitle(rs.getString("title"));
			  return em;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			C3P0_Util.release(conn, pstmt, rs);
		}
		return null;
	}
	//删除员工信息
	public boolean delete(int id){
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			conn = C3P0_Util.getConnection();
			String sql = "delete from employee where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			int num = pstmt.executeUpdate();
			if(num>0){
				result = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			C3P0_Util.release(conn, pstmt);
		}
		return result;	
	}
	//添加员工信息
	public boolean add(String name,String password,String sex,String birthday,String time,String title,String school,String experience,String job){
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			conn = C3P0_Util.getConnection();
			String sql = "insert employee(name,password,sex,birthday,time,title,school,experience,job) values(?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,name);
			pstmt.setString(2,password);
			pstmt.setString(3,sex);
			pstmt.setString(4, birthday);
			pstmt.setString(5, time);
			pstmt.setString(6, title);
			pstmt.setString(7, school);
			pstmt.setString(8, experience);
			pstmt.setString(9, job);
			int num = pstmt.executeUpdate();
			if(num>0){
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			C3P0_Util.release(conn, pstmt);
		}
		System.out.println(result);
		return result;
	}
	//查看未分配员工信息
		public List<Employee> findAllot(){
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String job="员工";
			List<Employee> list = new ArrayList<Employee>();
			try {
				conn = C3P0_Util.getConnection();
				String sql = "select * from employee where leader is null and job=? ";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,job);
				rs = pstmt.executeQuery();
				while(rs.next()){
					Employee em = new Employee();
					em.setId(rs.getInt("id"));
					em.setPassword(rs.getString("password"));
					em.setName(rs.getString("name"));
					em.setSex(rs.getString("sex"));
					em.setBirthday(rs.getDate("birthday"));
					em.setJob(rs.getString("job"));
					list.add(em);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				C3P0_Util.release(conn, pstmt, rs);
			}
			return list;
		}
		//分配主管
		public Employee allot(int id){
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = C3P0_Util.getConnection();
				String sql = "select * from employee where id=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, id);
				rs = pstmt.executeQuery();
				while(rs.next()){
				  Employee em = new Employee();
			      em.setId(rs.getInt("id"));
			      em.setName(rs.getString("name"));
				  return em;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				C3P0_Util.release(conn, pstmt, rs);
			}
			return null;
		}
		//查找主管
		public List<Employee> findAllLeader(){
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String job="主管";
			List<Employee> list = new ArrayList<Employee>();
			try {
				conn = C3P0_Util.getConnection();
				String sql = "select * from employee where  job=? ";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, job);
				rs = pstmt.executeQuery();
				while(rs.next()){
					Employee em = new Employee();
					em.setName(rs.getString("name"));
					list.add(em);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				C3P0_Util.release(conn, pstmt, rs);
			}
			return list;
		}
		//分配员工
		public boolean submit(int id,String leader){
			Connection conn = null;
			PreparedStatement pstmt = null;
			boolean result = false;
			System.out.println(id);
			System.out.println(leader);
			try {
				conn = C3P0_Util.getConnection();
				String sql = "update employee set leader=? where id=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,leader);
				pstmt.setInt(2, id);
				int num = pstmt.executeUpdate();
				if(num>0){
					result = true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				C3P0_Util.release(conn, pstmt);
			}
			System.out.println(result);
			return result;
		}
		
}
