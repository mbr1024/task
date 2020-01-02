package service;

import java.sql.Date;
import java.util.List;

import dao.EmployeeDAO;
import javabean.Employee;


public class EmployeeService {
   EmployeeDAO employeeDAO = new EmployeeDAO();
	
	//��ѯ����Ա��
	public List<Employee> findAllEmployee(){
		return employeeDAO.findAll();
	}
	//�鿴Ա��������Ϣ
	public Employee checkman(int id){
		return employeeDAO.check(id);
	}
    //ɾ��Ա����Ϣ
	public boolean deleteman(int id){
		return employeeDAO.delete(id);
	}
	//���Ա����Ϣ
	public boolean addman(String name,String password,String sex, String birthday,String time,String title,String school,String experience,String job){
		return employeeDAO.add(name, password, sex, birthday,time,title,school,experience,job);
	}
	//�鿴δ����Ա����Ϣ
	public List<Employee> findAllotEmployee(){
		return employeeDAO.findAllot();
	}
	public Employee allotman(int id){
		return employeeDAO.allot(id);
	}
	//��������
	public List<Employee> findAllLeader(){
		return employeeDAO.findAllLeader();
	}
	//����Ա��
	public boolean allotSubmit(int id,String leader){
		return employeeDAO.submit(id, leader);
	}
	
	
}
