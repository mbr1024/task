package service;

import java.sql.Date;
import java.util.List;

import dao.EmployeeDAO;
import javabean.Employee;


public class EmployeeService {
   EmployeeDAO employeeDAO = new EmployeeDAO();
	
	//查询所有员工
	public List<Employee> findAllEmployee(){
		return employeeDAO.findAll();
	}
	//查看员工具体信息
	public Employee checkman(int id){
		return employeeDAO.check(id);
	}
    //删除员工信息
	public boolean deleteman(int id){
		return employeeDAO.delete(id);
	}
	//添加员工信息
	public boolean addman(String name,String password,String sex, String birthday,String time,String title,String school,String experience,String job){
		return employeeDAO.add(name, password, sex, birthday,time,title,school,experience,job);
	}
	//查看未分配员工信息
	public List<Employee> findAllotEmployee(){
		return employeeDAO.findAllot();
	}
	public Employee allotman(int id){
		return employeeDAO.allot(id);
	}
	//查找主管
	public List<Employee> findAllLeader(){
		return employeeDAO.findAllLeader();
	}
	//分配员工
	public boolean allotSubmit(int id,String leader){
		return employeeDAO.submit(id, leader);
	}
	
	
}
