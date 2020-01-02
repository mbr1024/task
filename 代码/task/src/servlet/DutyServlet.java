package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javabean.Duty;
import javabean.Employee;
import javabean.Plan;
import javabean.User;
import service.DutyService;

/**
 * Servlet implementation class DutyServlet
 */
public class DutyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DutyService ds = new DutyService();

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
			this.makeDuty(request, response);
			break;
		case 2:
	        this.checkName(request, response);
			break;
		case 3:
			this.checkDuty(request, response);
			break;
		case 4:
			this.checkDutyList(request,response);
			break;
		case 5:
			this.checkPlanList(request, response);
			break;
		case 6:
			this.followDuty(request,response);
			break;
		case 7:
			this.followDutyList(request,response);
			break;
		case 8:
			this.followSubmit(request,response);
			break;
		case 9:
			this.adjustDuty(request,response);
			break;
		case 10:
			this.checkAdjust(request,response);
			break;
		case 11:
			this.adjustSubmit(request, response);
			break;
		case 12:
			this.checkStaff(request,response);
			break;
		case 13:
			this.checkStaffList(request,response);
			break;
		case 14:
			this.deleteDuty(request,response);
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
	
	//制定任务
	protected void makeDuty(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee employee= (Employee)request.getSession().getAttribute("employee");
		String username = employee.getName();
		String dutyname = request.getParameter("dutyname");
        String starttime= request.getParameter("starttime");
        String endtime=request.getParameter("endtime");
        String staff=request.getParameter("staff");
        String describe=request.getParameter("describe");
        String status=request.getParameter("status");
        boolean result = ds.makeDuty(username,dutyname,starttime,endtime,staff,describe,status);
		if(result){
			this.checkDuty(request, response);
		}
	}
	//查看员工
	protected void checkName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Employee employee= (Employee)request.getSession().getAttribute("employee");
		 String username = employee.getName();
		 List<Employee> list = ds.checkName(username);
		 request.setAttribute("List", list);
		 request.getRequestDispatcher("dutyAdd.jsp").forward(request, response);
	}
	//查看任务
	protected void checkDuty(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Employee employee= (Employee)request.getSession().getAttribute("employee");
		 String username = employee.getName();
		 List<Duty> list = ds.checkDuty(username);
		 request.setAttribute("dutyList", list);
		 request.getRequestDispatcher("dutyList.jsp").forward(request, response);
	}
	//查看任务具体信息
	protected void checkDutyList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dutyname = request.getParameter("dutyname");
		request.getSession().setAttribute("dutyname", dutyname);
		Duty list = ds.checkDutyList(dutyname);
		request.setAttribute("dutylist", list);
		this.checkPlan(request, response);
		request.getRequestDispatcher("checkDuty.jsp").forward(request, response);
	}
	//查看计划
	protected void checkPlan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String dutyname= (String)request.getSession().getAttribute("dutyname");
		 List<Plan> list = ds.checkPlan(dutyname);
		 request.setAttribute("planList", list);
	}
	//查看具体计划
	protected void checkPlanList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String planname = request.getParameter("planname");
		 String dutyname=request.getParameter("dutyname");
		 Plan list = ds.checkPlanList(planname,dutyname);
		 request.setAttribute("plan", list);
		 request.getRequestDispatcher("planList.jsp").forward(request, response);
	}
	//跟踪任务
	protected void followDuty(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Employee employee= (Employee)request.getSession().getAttribute("employee");
		 String username = employee.getName();
		 List<Duty> list = ds.checkDuty(username);
		 request.setAttribute("followList", list);
		 request.getRequestDispatcher("followDuty.jsp").forward(request, response);
	}
	//查看跟踪任务
	protected void followDutyList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String followname = request.getParameter("followname");
		 request.getSession().setAttribute("dutyname", followname);
		 Duty list = ds.checkDutyList(followname);
		 request.setAttribute("followlist", list);
		 this.checkPlan(request, response);
		 request.getRequestDispatcher("followDutyList.jsp").forward(request, response);
	}
	//提交跟踪计划
	protected void followSubmit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dutyname = request.getParameter("dutyname");
		String status = request.getParameter("status");
		boolean result = ds.followSubmit(dutyname,status);
		if(result){
			request.setAttribute("follow", "提交成功！");
			request.getRequestDispatcher("followDutyList.jsp").forward(request, response);
		}
		
	}
	//调整任务
	protected void adjustDuty(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee employee= (Employee)request.getSession().getAttribute("employee");
		String username = employee.getName();
		List<Duty> list = ds.adjustDuty(username);
		request.setAttribute("adjustList", list);
		request.getRequestDispatcher("adjustList.jsp").forward(request, response);
	}
	//查看调整任务
	protected void checkAdjust(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dutyname = request.getParameter("dutyname");
		Duty list = ds.checkAdjust(dutyname);
		request.setAttribute("checkadjust", list);
		this.checkAdjustName(request, response);
		request.getRequestDispatcher("checkAdjust.jsp").forward(request, response);
		
	}
	//查看调整员工
	protected void checkAdjustName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Employee employee= (Employee)request.getSession().getAttribute("employee");
		 String username = employee.getName();
		 List<Employee> list = ds.checkName(username);
		 request.setAttribute("List", list);
	}
	//提交调整员工信息
	protected void adjustSubmit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dutyname = request.getParameter("dutyname");
        String starttime= request.getParameter("starttime");
        String endtime=request.getParameter("endtime");
        String staff=request.getParameter("staff");
        String describe=request.getParameter("describe");
        String status=request.getParameter("status");
        boolean result = ds.adjustSubmit(dutyname,starttime,endtime,staff,describe,status);
      		if(result){
      			request.setAttribute("adjust", "调整成功！");
    			request.getRequestDispatcher("checkAdjust.jsp").forward(request, response);
      		}
		
	}
	//查看主管下属员工
		protected void checkStaff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			 Employee employee= (Employee)request.getSession().getAttribute("employee");
			 String username = employee.getName();
			 List<Employee> list = ds.checkStaff(username);
			 request.setAttribute("staffList", list);
			 request.getRequestDispatcher("staffList.jsp").forward(request, response);
	}
	//查看主管下属员工具体信息
		protected void checkStaffList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			 int id = Integer.parseInt(request.getParameter("id"));
			 Employee em= (Employee) ds.checkStaffList(id);
			 request.setAttribute("stafflist", em); 
			 request.getRequestDispatcher("checkStaffList.jsp").forward(request, response);
		}
	//删除任务
	protected void deleteDuty(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String dutyname = request.getParameter("dutyname");
			System.out.println(dutyname);
			boolean result = ds.deleteDuty(dutyname);
			if(result){
				this.followDuty(request, response);
			}
		}	
	

}
