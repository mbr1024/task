package service;

import dao.UserDAO;
import javabean.Employee;
import javabean.User;
/*
 * �û���ҵ��
 */
public class UserService {
	private UserDAO userDAO = new UserDAO();
	
	//�û���¼ҵ��
	public User login(String username,String password,int id){
		return userDAO.find(username, password,id);
	}
	//����Ա����½
	public Employee login1(String username,String password,String job){
		return userDAO.find1(username, password,job);
	}	
}
