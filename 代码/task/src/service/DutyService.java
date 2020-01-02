package service;

import java.util.List;

import dao.DutyDAO;
import javabean.Duty;
import javabean.Employee;
import javabean.Plan;

public class DutyService {
	DutyDAO dutyDAO = new DutyDAO();
	//制定任务
    public boolean makeDuty(String username,String dutyname,String starttime, String endtime,String staff,String describe,String status){
	    return dutyDAO.make(username,dutyname,starttime,endtime,staff,describe,status);
	}
   //查找员工
  	public List<Employee> checkName(String username){
  		return dutyDAO.checkname(username);
  	}
  	//查看任务
  	public List<Duty> checkDuty(String username){
		return dutyDAO.checkduty( username);
	}
  	//查看任务具体信息
  	public Duty checkDutyList(String dutyname){
		return dutyDAO.checkdutylist(dutyname);
	}
  	//查看计划
  	public List<Plan> checkPlan(String dutyname){
		return dutyDAO.checkplan(dutyname);
	}
  	//查看具体计划
  	public Plan checkPlanList(String planname,String dutyname){
		return dutyDAO.checkplanList(planname,dutyname);
	}
  	//提交跟踪任务
  	 public boolean followSubmit(String dutyname,String status){
  		return dutyDAO.followsubmit(dutyname,status);
  	 }
  	 //调整任务
 	public List<Duty> adjustDuty(String username){
		return dutyDAO.adjustduty(username);
	}
 	//查看调整任务
 	public Duty checkAdjust(String dutyname){
		return dutyDAO.checkadjust(dutyname);
	}
 	//提交调整信息
 	public boolean adjustSubmit(String dutyname,String starttime, String endtime,String staff,String describe,String status){
 		return dutyDAO.adjustsubmit(dutyname,starttime,endtime,staff,describe,status);
 		
 	}
 	//查看主管下属员工
 	public List<Employee> checkStaff(String username){
		return dutyDAO.checkstaff(username);
	}
 	//查看主管下属员工具体信息
 	public Employee checkStaffList(int id){
		return dutyDAO.checkstafflist(id);
	}
 	//删除任务
 	public boolean deleteDuty(String dutyname){
		return dutyDAO.deleteduty(dutyname);
	}
 	
  	
}
