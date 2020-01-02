package dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javabean.Duty;
import javabean.Plan;
import utils.C3P0_Util;

public class PlanDAO {
	//查看任务
	public List<Duty> checkplan(String username){
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String status="已完成";
			List<Duty> list = new ArrayList<Duty>();
			try {
				conn = C3P0_Util.getConnection();
				String sql = "select * from duty where staff=? ";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, username);
				rs = pstmt.executeQuery();
				while(rs.next()){
				 if(rs.getString("status").equals(status)==false) {	
					Duty dy = new Duty();
					dy.setDutyname(rs.getString("dutyName"));
					dy.setLeader(rs.getString("leader"));
					dy.setStarttime(rs.getDate("starttime"));
					dy.setEndtime(rs.getDate("endtime"));
					dy.setStatus(rs.getString("status"));
					list.add(dy);
				 }
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
	public List<Plan> checkplanList(String dutyname){
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
	//提交计划
	public boolean plansubmit(String dutyname,String name,String planname, String planstarttime,String planendtime,String planconcrete,String planstatus,String planfeedback){
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			conn = C3P0_Util.getConnection();
			String sql = "insert plan(dutyname,name,planname,planstarttime,planendtime,planconcrete,planstatus,planfeedback) values(?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,dutyname);
			pstmt.setString(2,name);
			pstmt.setString(3,planname);
			pstmt.setString(4, planstarttime);
			pstmt.setString(5, planendtime);
			pstmt.setString(6, planconcrete);
			pstmt.setString(7, planstatus);
			pstmt.setString(8, planfeedback);
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
	//更新任务状态
	public void updateplan(String dutyname){
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		String status="实施中";
		try {
			conn = C3P0_Util.getConnection();
			String sql = "update duty set status=? where dutyname=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,status);
			pstmt.setString(2, dutyname);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			C3P0_Util.release(conn, pstmt);
		}
		System.out.println(result);
	}
	//查看反馈计划信息
	public Plan checkfeedback(String planname,String dutyname){
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
				pl.setPlanconcrete(rs.getString("planconcrete"));
				pl.setPlanstarttime(rs.getDate("planstarttime"));
				pl.setPlanendtime(rs.getDate("planendtime"));
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
	//提交反馈信息
	public boolean feedsubmit(String dutyname,String planname,String planstatus,String planfeedback,String backmessage){
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			conn = C3P0_Util.getConnection();
			String sql = "update plan set planstatus=?,planfeedback=?,backmessage=? where dutyname=? and planname=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,planstatus);
			pstmt.setString(2, planfeedback);
			pstmt.setString(3, backmessage);
			pstmt.setString(4, dutyname);
			pstmt.setString(5, planname);
			pstmt.executeUpdate();
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
	//查看员工下属任务
	public List<Duty> checkduty(String staff){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Duty> list = new ArrayList<Duty>();
		try {
			conn = C3P0_Util.getConnection();
			String sql = "select * from duty where staff=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, staff);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Duty dy = new Duty();
				dy.setDutyname(rs.getString("dutyName"));
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
	//根据人物名反馈查询计划
	public List<Plan> seekplan(String dutyname,String planfeedback){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Plan> list = new ArrayList<Plan>();
		try {
			conn = C3P0_Util.getConnection();
			String sql = "select * from plan where dutyname=? and planfeedback=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dutyname);
			pstmt.setString(2, planfeedback);
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
	//删除计划
	public boolean deletefeedback(String planname,String dutyname){
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			conn = C3P0_Util.getConnection();
			String sql = "delete from plan where planname=? and dutyname=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, planname);
			pstmt.setString(2, dutyname);
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
	//按照任务名来查找计划
	public List<Plan> seekplan1(String dutyname){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Plan> list = new ArrayList<Plan>();
		try {
			conn = C3P0_Util.getConnection();
			String sql = "select * from plan where dutyname=?";
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
	//按照任务名时间来查找计划
		public List<Plan> seekplan2(String dutyname,String planstarttime1,String planendtime1,String planstarttime2,String planendtime2){
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		    Date beginTime1 = null;
		    Date endTime1 = null;
		    try {
				beginTime1 = (Date) df.parse(planstarttime1);
				endTime1 = (Date) df.parse(planendtime1);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    Date beginTime2 = null;
		    Date endTime2 = null;
		    try {
				beginTime2 = (Date) df.parse(planstarttime2);
				endTime2 = (Date) df.parse(planendtime2);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List<Plan> list = new ArrayList<Plan>();
			try {
				conn = C3P0_Util.getConnection();
				String sql = "select * from plan where dutyname=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dutyname);
				rs = pstmt.executeQuery();
				while(rs.next()){
					Plan pl = new Plan();
					pl.setPlanstarttime(rs.getDate("planstarttime"));
					pl.setPlanendtime(rs.getDate("planendtime"));
					Calendar date1 = Calendar.getInstance();
			        date1.setTime(rs.getDate("planstarttime"));
			        Calendar begin1 = Calendar.getInstance();
			        begin1.setTime(beginTime1);
			        Calendar end1 = Calendar.getInstance();
			        end1.setTime(endTime1);
			        Calendar date2 = Calendar.getInstance();
			        date2.setTime(rs.getDate("planendtime"));
			        Calendar begin2 = Calendar.getInstance();
			        begin2.setTime(beginTime2);
			        Calendar end2 = Calendar.getInstance();
			        end2.setTime(endTime2);
			        if ((date1.after(begin1) && date1.before(end1))&&(date2.after(begin2) && date1.before(end2))) {
					   pl.setPlanname(rs.getString("planname"));
					   pl.setPlanstatus(rs.getString("planstatus"));
					   pl.setPlanendtime(rs.getDate("planendtime"));
					   pl.setDutyname(rs.getString("dutyname"));
					   pl.setPlanfeedback(rs.getString("planfeedback"));
					   pl.setPlanstarttime(rs.getDate("planstarttime"));
					   pl.setPlanendtime(rs.getDate("planendtime"));
					   pl.setPlanconcrete(rs.getString("planconcrete"));
					   list.add(pl);
			        }
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				C3P0_Util.release(conn, pstmt, rs);
			}
			return list;
		}
		//按照任务名时间反馈来查找计划
		public List<Plan> seekplan3(String dutyname,String planfeedback,String planstarttime1,String planendtime1,String planstarttime2,String planendtime2){
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		    Date beginTime1 = null;
		    Date endTime1 = null;
		    try {
				beginTime1 = (Date) df.parse(planstarttime1);
				endTime1 = (Date) df.parse(planendtime1);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    Date beginTime2 = null;
		    Date endTime2 = null;
		    try {
				beginTime2 = (Date) df.parse(planstarttime2);
				endTime2 = (Date) df.parse(planendtime2);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List<Plan> list = new ArrayList<Plan>();
			try {
				conn = C3P0_Util.getConnection();
				String sql = "select * from plan where dutyname=? and planfeedback=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dutyname);
				pstmt.setString(2, planfeedback);
				rs = pstmt.executeQuery();
				while(rs.next()){
					Plan pl = new Plan();
					pl.setPlanstarttime(rs.getDate("planstarttime"));
					pl.setPlanendtime(rs.getDate("planendtime"));
					Calendar date1 = Calendar.getInstance();
			        date1.setTime(rs.getDate("planstarttime"));
			        Calendar begin1 = Calendar.getInstance();
			        begin1.setTime(beginTime1);
			        Calendar end1 = Calendar.getInstance();
			        end1.setTime(endTime1);
			        Calendar date2 = Calendar.getInstance();
			        date2.setTime(rs.getDate("planendtime"));
			        Calendar begin2 = Calendar.getInstance();
			        begin2.setTime(beginTime2);
			        Calendar end2 = Calendar.getInstance();
			        end2.setTime(endTime2);
			        if ((date1.after(begin1) && date1.before(end1))&&(date2.after(begin2) && date1.before(end2))) {
					   pl.setPlanname(rs.getString("planname"));
					   pl.setPlanstatus(rs.getString("planstatus"));
					   pl.setPlanendtime(rs.getDate("planendtime"));
					   pl.setDutyname(rs.getString("dutyname"));
					   pl.setPlanfeedback(rs.getString("planfeedback"));
					   pl.setPlanstarttime(rs.getDate("planstarttime"));
					   pl.setPlanendtime(rs.getDate("planendtime"));
					   pl.setPlanconcrete(rs.getString("planconcrete"));
					   list.add(pl);
			        }
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				C3P0_Util.release(conn, pstmt, rs);
			}
			return list;
		}
	
}
