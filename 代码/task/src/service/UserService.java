package service;

import dao.UserDAO;
import javabean.Employee;
import javabean.User;
/*
 * 用户的业务
 */
public class UserService {
	private UserDAO userDAO = new UserDAO();
	
	//用户登录业务
	public User login(String username,String password,int id){
		return userDAO.find(username, password,id);
	}
	//主管员工登陆
	public Employee login1(String username,String password,String job){
		return userDAO.find1(username, password,job);
	}	
}
