package service;

import java.util.List;

import dao.DutyDAO;
import javabean.Duty;
import javabean.Employee;
import javabean.Plan;

public class DutyService {
	DutyDAO dutyDAO = new DutyDAO();
	//�ƶ�����
    public boolean makeDuty(String username,String dutyname,String starttime, String endtime,String staff,String describe,String status){
	    return dutyDAO.make(username,dutyname,starttime,endtime,staff,describe,status);
	}
   //����Ա��
  	public List<Employee> checkName(String username){
  		return dutyDAO.checkname(username);
  	}
  	//�鿴����
  	public List<Duty> checkDuty(String username){
		return dutyDAO.checkduty( username);
	}
  	//�鿴���������Ϣ
  	public Duty checkDutyList(String dutyname){
		return dutyDAO.checkdutylist(dutyname);
	}
  	//�鿴�ƻ�
  	public List<Plan> checkPlan(String dutyname){
		return dutyDAO.checkplan(dutyname);
	}
  	//�鿴����ƻ�
  	public Plan checkPlanList(String planname,String dutyname){
		return dutyDAO.checkplanList(planname,dutyname);
	}
  	//�ύ��������
  	 public boolean followSubmit(String dutyname,String status){
  		return dutyDAO.followsubmit(dutyname,status);
  	 }
  	 //��������
 	public List<Duty> adjustDuty(String username){
		return dutyDAO.adjustduty(username);
	}
 	//�鿴��������
 	public Duty checkAdjust(String dutyname){
		return dutyDAO.checkadjust(dutyname);
	}
 	//�ύ������Ϣ
 	public boolean adjustSubmit(String dutyname,String starttime, String endtime,String staff,String describe,String status){
 		return dutyDAO.adjustsubmit(dutyname,starttime,endtime,staff,describe,status);
 		
 	}
 	//�鿴��������Ա��
 	public List<Employee> checkStaff(String username){
		return dutyDAO.checkstaff(username);
	}
 	//�鿴��������Ա��������Ϣ
 	public Employee checkStaffList(int id){
		return dutyDAO.checkstafflist(id);
	}
 	//ɾ������
 	public boolean deleteDuty(String dutyname){
		return dutyDAO.deleteduty(dutyname);
	}
 	
  	
}
