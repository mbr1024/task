package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javabean.Employee;
import javabean.User;
import service.UserService;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService us = new UserService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8");
         response.setCharacterEncoding("utf-8");
		int f = Integer.parseInt(request.getParameter("f"));
		switch (f) {
		case 1:
			this.login(request, response);
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
	
	//�û���¼
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password= request.getParameter("password");
		int id = Integer.parseInt(request.getParameter("id"));
		if(id==1) {
		   User user = us.login(username, password,id);
		   if(user==null){
			     request.setAttribute("error", "�û�����������������ְλ��ƥ�䣡");
			     //����ת������½ҳ��
			     request.getRequestDispatcher("login.jsp").forward(request, response);
		    }else{//��½�ɹ�
			     //��user���󱣴浽session��Χ��
			   request.getSession().setAttribute("user", user);
			   response.sendRedirect("index.jsp");
		 }
		}else if(id==2) {
			  String job="����";
			  Employee user1=us.login1(username,password,job);
			  if(user1==null){
				 request.setAttribute("error", "�û�����������������ְλ��ƥ�䣡");
				  //����ת������½ҳ��
				  request.getRequestDispatcher("login.jsp").forward(request, response);
			   }else{//��½�ɹ�
				 //��user���󱣴浽session��Χ��
				 request.getSession().setAttribute("employee", user1);
				 //�ض���ϵͳ��ҳ
				 response.sendRedirect("index1.jsp");
		    }
		}else if(id==3) {
			  String job="Ա��";
			  Employee user2=us.login1(username,password,job);
			  if(user2==null){
				 request.setAttribute("error", "�û�����������������ְλ��ƥ�䣡");
				  //����ת������½ҳ��
				  request.getRequestDispatcher("login.jsp").forward(request, response);
			   }else{//��½�ɹ�
				 //��user���󱣴浽session��Χ��
				 request.getSession().setAttribute("employee1", user2);
				 //�ض���ϵͳ��ҳ
				 response.sendRedirect("index2.jsp");
		    }
		}
}
}
