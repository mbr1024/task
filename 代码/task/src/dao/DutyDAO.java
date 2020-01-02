package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javabean.Duty;
import javabean.Employee;
import javabean.Plan;
import utils.C3P0_Util;

public class DutyDAO {
	//制定任务
		public boolean make(String username,String dutyname,String starttime, String endtime,String staff,String describe,String status){
			Connection conn = null;
			PreparedStatement pstmt = null;
			boolean result = false;
			try {
				conn = C3P0_Util.getConnection();
				String sql = "insert duty(dutyname,starttime,endtime,staff,concrete,status,leader) values(?,?,?,?,?,?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,dutyname);
				pstmt.setString(2,starttime);
				pstmt.setString(3,endtime);
				pstmt.setString(4, staff);
				pstmt.setString(5, describe);
				pstmt.setString(6, status);
				pstmt.setString(7, username);
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
		//查找员工
				public List<Employee> checkname(String username){
					Connection conn = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					List<Employee> list = new ArrayList<Employee>();
					try {
						conn = C3P0_Util.getConnection();
						String sql = "select * from employee where  leader=? ";
						pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, username);
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
		//查看任务
			public List<Duty> checkduty(String username){
					Connection conn = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					List<Duty> list = new ArrayList<Duty>();
					try {
						conn = C3P0_Util.getConnection();
						String sql = "select * from duty where leader=? ";
						pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, username);
						rs = pstmt.executeQuery();
						while(rs.next()){
							Duty dy = new Duty();
							dy.setDutyname(rs.getString("dutyName"));
							dy.setStaff(rs.getString("staff"));
							dy.setStarttime(rs.getDate("starttime"));
							dy.setEndtime(rs.getDate("endtime"));
							dy.setStatus(rs.getString("status"));
							list.add(dy);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
						C3P0_Util.release(conn, pstmt, rs);
					}
					return list;
				}
	  //查看任务具体信息
			public Duty checkdutylist(String dutyname){
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				try {
					conn = C3P0_Util.getConnection();
					String sql = "select * from duty where dutyname=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, dutyname);
					rs = pstmt.executeQuery();
					while(rs.next()){
					  Duty dy = new Duty();
				      dy.setDutyname(rs.getString("dutyname"));
				      dy.setConcrete(rs.getString("concrete"));
				      dy.setStarttime(rs.getDate("starttime"));
				      dy.setEndtime(rs.getDate("endtime"));
				      dy.setStaff(rs.getString("staff"));
				      dy.setStatus(rs.getString("status"));
					  return dy;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					C3P0_Util.release(conn, pstmt, rs);
				}
				return null;
			}
			//查看计划信息
			public List<Plan> checkplan(String dutyname){
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				List<Plan> list = new ArrayList<Plan>();
				try {
					conn = C3P0_Util.getConnection();
					String sql = "select * from plan where dutyname=? ";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, dutyname);
					rs = pstmt.executeQuery();
					while(rs.next()){
						Plan pl = new Plan();
						pl.setPlanname(rs.getString("planname"));
						pl.setPlanstatus(rs.getString("planstatus"));
						pl.setPlanfeedback(rs.getString("planfeedback"));
						pl.setPlanstarttime(rs.getDate("planstarttime"));
						pl.setPlanendtime(rs.getDate("planendtime"));
						pl.setDutyname(rs.getString("dutyname"));
						pl.setPlanconcrete(rs.getString("planconcrete"));
						list.add(pl);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					C3P0_Util.release(conn, pstmt, rs);
				}
				return list;
			}
			//查看计划具体信息
			public Plan checkplanList(String planname,String dutyname){
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				try {
					conn = C3P0_Util.getConnection();
					String sql = "select * from plan where planname=? and dutyname=? ";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, planname);
					pstmt.setString(2, dutyname);
					rs = pstmt.executeQuery();
					while(rs.next()){
						Plan pl = new Plan();
						pl.setPlanname(rs.getString("planname"));
						pl.setPlanstatus(rs.getString("planstatus"));
						pl.setPlanfeedback(rs.getString("planfeedback"));
						pl.setPlanstarttime(rs.getDate("planstarttime"));
						pl.setPlanendtime(rs.getDate("planendtime"));
						pl.setDutyname(rs.getString("dutyname"));
						pl.setPlanconcrete(rs.getString("planconcrete"));
						return pl;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					C3P0_Util.release(conn, pstmt, rs);
				}
				return null;
			}
			//提交跟踪任务
			public boolean followsubmit(String dutyname,String status){
				Connection conn = null;
				PreparedStatement pstmt = null;
				boolean result = false;
				try {
					conn = C3P0_Util.getConnection();
					String sql = "update duty set status=? where dutyname=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1,status);
					pstmt.setString(2,dutyname);
					int num = pstmt.executeUpdate();
					if(num>0){
						result = true;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					C3P0_Util.release(conn, pstmt);
				}
				return result;	
			}
	  //调整任务
			public List<Duty> adjustduty(String username){
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				String status="未实施";
				List<Duty> list = new ArrayList<Duty>();
				try {
					conn = C3P0_Util.getConnection();
					String sql = "select *from duty where leader=? and status=? ";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, username);
					pstmt.setString(2, status);
					rs = pstmt.executeQuery();
					while(rs.next()){
						Duty dy = new Duty();
						dy.setDutyname(rs.getString("dutyName"));
						dy.setStaff(rs.getString("staff"));
						dy.setStarttime(rs.getDate("starttime"));
						dy.setEndtime(rs.getDate("endtime"));
						dy.setStatus(rs.getString("status"));
						list.add(dy);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					C3P0_Util.release(conn, pstmt, rs);
				}
				return list;
			}
	  //查看调整任务
			public Duty checkadjust(String dutyname){
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				try {
					conn = C3P0_Util.getConnection();
					String sql = "select * from duty where dutyname=? ";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, dutyname);
					rs = pstmt.executeQuery();
					while(rs.next()){
						Duty dy=new Duty();
						dy.setDutyname(rs.getString("dutyname"));
						dy.setStarttime(rs.getDate("starttime"));
						System.out.println(rs.getDate("starttime"));
						dy.setEndtime(rs.getDate("endtime"));
						dy.setConcrete(rs.getString("concrete"));
						return dy;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					C3P0_Util.release(conn, pstmt, rs);
				}
				return null;
			}
		//提交调整任务信息
			public boolean adjustsubmit(String dutyname,String starttime, String endtime,String staff,String describe,String status){
				Connection conn = null;
				PreparedStatement pstmt = null;
				boolean result = false;
				try {
					conn = C3P0_Util.getConnection();
					String sql = "update duty set starttime=?,endtime=?,staff=?,concrete=? where dutyname=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1,starttime);
					pstmt.setString(2,endtime);
					pstmt.setString(3, staff);
					pstmt.setString(4, describe);
					pstmt.setString(5,dutyname);
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
			//查看主管下属员工
			public List<Employee> checkstaff(String username){
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				List<Employee> list = new ArrayList<Employee>();
				try {
					conn = C3P0_Util.getConnection();
					String sql = "select * from employee where leader=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1,username);
					rs = pstmt.executeQuery();
					while(rs.next()){
						Employee em = new Employee();
						em.setId(rs.getInt("id"));
						em.setName(rs.getString("name"));
						em.setSex(rs.getString("sex"));
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
			//查看主管下属员工具体信息
			public Employee checkstafflist(int id){
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
			//删除任务
			public boolean deleteduty(String dutyname){
				Connection conn = null;
				PreparedStatement pstmt = null;
				boolean result = false;
				try {
					conn = C3P0_Util.getConnection();
					String sql = "delete from duty where dutyname=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, dutyname);
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
			
			
}
