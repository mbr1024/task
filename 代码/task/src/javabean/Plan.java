package javabean;

import java.sql.Date;

public class Plan {
	private String planname;
    private String planstatus;
    private String planfeedback;
    private Date planstarttime;
    private Date planendtime;
    private String dutyname;
    private String planconcrete;
    private String backmessage;
	public String getBackmessage() {
		return backmessage;
	}
	public void setBackmessage(String backmessage) {
		this.backmessage = backmessage;
	}
	public String getDutyname() {
		return dutyname;
	}
	public void setDutyname(String dutyname) {
		this.dutyname = dutyname;
	}
	public String getPlanconcrete() {
		return planconcrete;
	}
	public void setPlanconcrete(String planconcrete) {
		this.planconcrete = planconcrete;
	}
	public String getPlanname() {
		return planname;
	}
	public void setPlanname(String planname) {
		this.planname = planname;
	}
	public String getPlanstatus() {
		return planstatus;
	}
	public void setPlanstatus(String planstatus) {
		this.planstatus = planstatus;
	}
	public String getPlanfeedback() {
		return planfeedback;
	}
	public void setPlanfeedback(String planfeedback) {
		this.planfeedback = planfeedback;
	}
	public Date getPlanstarttime() {
		return planstarttime;
	}
	public void setPlanstarttime(Date planstarttime) {
		this.planstarttime = planstarttime;
	}
	public Date getPlanendtime() {
		return planendtime;
	}
	public void setPlanendtime(Date planendtime) {
		this.planendtime = planendtime;
	}
}
