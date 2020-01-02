package service;

import java.util.List;

import dao.PlanDAO;
import javabean.Duty;
import javabean.Plan;

public class PlanService {
	PlanDAO planDAO = new PlanDAO();
	//�鿴����
  	public List<Duty> checkPlan(String username){
		return planDAO.checkplan( username);
	}
  //�鿴���������Ϣ
  	public Duty checkDutyList(String dutyname){
		return planDAO.checkdutylist(dutyname);
	}
  	//�鿴�ƻ�
  	public List<Plan> checkPlanList(String dutyname){
		return planDAO.checkplanList(dutyname);
	}
  	//�ύ�ƻ�
	public boolean planSubmit(String dutyname,String name,String planname, String planstarttime,String planendtime,String planconcrete,String planstatus,String planfeedback){
		return planDAO.plansubmit(dutyname,name,planname,planstarttime,planendtime,planconcrete,planstatus,planfeedback);
	}
	//��������״̬
	public void updatePlan(String dutyname){
		planDAO.updateplan(dutyname);
	}
	//�鿴�����ƻ���Ϣ
	public Plan checkFeedback(String planname,String dutyname){
		return planDAO.checkfeedback(planname,dutyname);
	}
	//�ύ������Ϣ
	public boolean feedSubmit(String dutyname,String planname,String planstatus,String planfeedback,String backmessage){
		return planDAO.feedsubmit(dutyname,planname,planstatus,planfeedback,backmessage);
	}
    //�鿴Ա����������
	public List<Duty> checkDuty(String staff){
		return planDAO.checkduty(staff);
	}
	//����������������ѯ�ƻ�
	public List<Plan> seekPlan(String dutyname,String planfeedback){
		return planDAO.seekplan(dutyname,planfeedback);
	}
	//ɾ���ƻ�
	public boolean deleteFeedback(String planname,String dutyname){
		return planDAO.deletefeedback(planname,dutyname);
	}
	//�������������Ҽƻ�
	public List<Plan> seekPlan1(String dutyname){
		return planDAO.seekplan1(dutyname);
	}
	//����������ʱ����Ҽƻ�
	public List<Plan> seekPlan2(String dutyname,String planstarttime1,String planendtime1,String planstarttime2,String planendtime2){
		return planDAO.seekplan2(dutyname,planstarttime1,planendtime1,planstarttime2,planendtime2);
	}
	//����������ʱ�䷴�����Ҽƻ�
	public List<Plan> seekPlan3(String dutyname,String planfeedback,String planstarttime1,String planendtime1,String planstarttime2,String planendtime2){
		return planDAO.seekplan3(dutyname,planfeedback,planstarttime1,planendtime1,planstarttime2,planendtime2);
	}
}
