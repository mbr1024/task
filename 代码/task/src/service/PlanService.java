package service;

import java.util.List;

import dao.PlanDAO;
import javabean.Duty;
import javabean.Plan;

public class PlanService {
	PlanDAO planDAO = new PlanDAO();
	//查看任务
  	public List<Duty> checkPlan(String username){
		return planDAO.checkplan( username);
	}
  //查看任务具体信息
  	public Duty checkDutyList(String dutyname){
		return planDAO.checkdutylist(dutyname);
	}
  	//查看计划
  	public List<Plan> checkPlanList(String dutyname){
		return planDAO.checkplanList(dutyname);
	}
  	//提交计划
	public boolean planSubmit(String dutyname,String name,String planname, String planstarttime,String planendtime,String planconcrete,String planstatus,String planfeedback){
		return planDAO.plansubmit(dutyname,name,planname,planstarttime,planendtime,planconcrete,planstatus,planfeedback);
	}
	//更新任务状态
	public void updatePlan(String dutyname){
		planDAO.updateplan(dutyname);
	}
	//查看反馈计划信息
	public Plan checkFeedback(String planname,String dutyname){
		return planDAO.checkfeedback(planname,dutyname);
	}
	//提交反馈信息
	public boolean feedSubmit(String dutyname,String planname,String planstatus,String planfeedback,String backmessage){
		return planDAO.feedsubmit(dutyname,planname,planstatus,planfeedback,backmessage);
	}
    //查看员工下属任务
	public List<Duty> checkDuty(String staff){
		return planDAO.checkduty(staff);
	}
	//根据任务名反馈查询计划
	public List<Plan> seekPlan(String dutyname,String planfeedback){
		return planDAO.seekplan(dutyname,planfeedback);
	}
	//删除计划
	public boolean deleteFeedback(String planname,String dutyname){
		return planDAO.deletefeedback(planname,dutyname);
	}
	//按照任务名查找计划
	public List<Plan> seekPlan1(String dutyname){
		return planDAO.seekplan1(dutyname);
	}
	//按照任务名时间查找计划
	public List<Plan> seekPlan2(String dutyname,String planstarttime1,String planendtime1,String planstarttime2,String planendtime2){
		return planDAO.seekplan2(dutyname,planstarttime1,planendtime1,planstarttime2,planendtime2);
	}
	//按照任务名时间反馈查找计划
	public List<Plan> seekPlan3(String dutyname,String planfeedback,String planstarttime1,String planendtime1,String planstarttime2,String planendtime2){
		return planDAO.seekplan3(dutyname,planfeedback,planstarttime1,planendtime1,planstarttime2,planendtime2);
	}
}
