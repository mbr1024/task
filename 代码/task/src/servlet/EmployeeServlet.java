package servlet;

import java.io.IOException;
import java.text.*;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javabean.Employee;
import service.EmployeeService;

/**
 * Servlet implementation class employeeServlet
 */
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeService es = new EmployeeService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
		int f = Integer.parseInt(request.getParameter("f"));
		//System.out.println(f);
		switch (f) {
		case 1:
			this.findAllEmployeeman(request, response);
			break;
		case 2:
	        this.checkEmployee(request, response);
			break;
		case 3:
			this.deleteEmployee(request, response);
			break;
		case 4:
			this.addEmployee(request,response);
			break;
		case 5:
			this.AllotEmployee(request, response);
			break;
		case 6:
			this.allotMan(request,response);
			break;
		case 7:
			this.allotSubmit(request,response);
			break;
		}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	//��ѯ����Ա��
	protected void findAllEmployeeman(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 List<Employee> list = es.findAllEmployee();
		 request.setAttribute("employeeList", list);
		 request.getRequestDispatcher("employeeList.jsp").forward(request, response);
	}
	//�鿴Ա��������Ϣ
	protected void checkEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int id = Integer.parseInt(request.getParameter("id"));
		 Employee em= (Employee) es.checkman(id);
		 request.setAttribute("checkList", em); 
		 request.getRequestDispatcher("checkEmployee.jsp").forward(request, response);
	}
	//ɾ��Ա����Ϣ
	protected void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		boolean result = es.deleteman(id);
		if(result){
			this.findAllEmployeeman(request, response);
		}
	}
	//���Ա����Ϣ
	protected void addEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	    String name = request.getParameter("name");
        String password= request.getParameter("password");
        String sex=request.getParameter("sex");
        String birthday=request.getParameter("birthday");
        String time=request.getParameter("time");
        String title=request.getParameter("title");
        String school=request.getParameter("school");
        String experience=request.getParameter("experience");
        String job=request.getParameter("job");
        boolean result = es.addman(name,password,sex,birthday,time,title,school,experience,job);
		if(result){
			this.findAllEmployeeman(request, response);
		}
}
	//�鿴δ����Ա����Ϣ
		protected void AllotEmployee(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
			// TODO Auto-generated method stub
			 List<Employee> list = es.findAllotEmployee();
			 request.setAttribute("allotList", list);
			 request.getRequestDispatcher("allotList.jsp").forward(request, response);
		}
	//����Ա��
		protected void allotMan(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
			 int id = Integer.parseInt(request.getParameter("id"));
			 Employee em= (Employee) es.allotman(id);
			 request.setAttribute("allList", em);
			 this.findAllLeader(request, response);
			 request.getRequestDispatcher("allotEmployee.jsp").forward(request, response);
			
		}
		//��ѯ����
		protected void findAllLeader(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			 List<Employee> list = es.findAllLeader();
			 request.setAttribute("leaderList", list);
		}
		//����Ա��
		protected void allotSubmit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			int id = Integer.parseInt(request.getParameter("id"));
	        String leader=request.getParameter("leader");
	        boolean result = es.allotSubmit(id,leader);
			if(result){
				request.setAttribute("success", "����ɹ���");
				request.getRequestDispatcher("allotEmployee.jsp").forward(request, response);
				//this.findAllEmployeeman(request, response);
			 }
	    }

		
}
