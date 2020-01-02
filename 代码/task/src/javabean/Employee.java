package javabean;

import java.sql.Date;

public class Employee {
   private int id;
   private String password;
   private String name;
   private String sex;
   private Date birthday;
   private String job;
   private String school;
   private String title;
   private Date time;
   private String leader;
public String getLeader() {
	return leader;
}
public void setLeader(String leader) {
	this.leader = leader;
}
public String getSchool() {
	return school;
}
public void setSchool(String school) {
	this.school = school;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public Date getTime() {
	return time;
}
public void setTime(Date time) {
	this.time = time;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public Date getBirthday() {
	return birthday;
}
public void setBirthday(Date birthday) {
	this.birthday = birthday;
}
public String getJob() {
	return job;
}
public void setJob(String job) {
	this.job = job;
}
   
}
