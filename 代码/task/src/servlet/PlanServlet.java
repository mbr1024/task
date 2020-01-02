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
import service.DutyService;
import service.PlanService;

/**
 * Servlet implementation class PlanServlet
 */
public class PlanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	private PlanService ps=new PlanService(); 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
		int f = Integer.parseInt(request.getParameter("f"));
		switch (f) {
		case 1:
			this.checkPlan(request, response);
			break;
		case 2:
	        this.makePlan(request, response);
			break;
		case 3:
			this.planSubmit(request,response);
			break;
		case 4:
			this.checkFeedback(request, response);
			break;
		case 5:
			this.feedSubmit(request,response);
			break;
		case 6:
			this.deleteFeedback(request,response);
			break;
		case 7:
			this.checkDuty(request,response);
			break;
		case 8:
			this.seekPlan(request,response);
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
	//查看任务
		protected void checkPlan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			 Employee employee1= (Employee)request.getSession().getAttribute("employee1");
			 String username = employee1.getName();
			 List<Duty> list = ps.checkPlan(username);
			 request.setAttribute("PlanList", list);
			 request.getRequestDispatcher("checkPlanList.jsp").forward(request, response);
		}
		//查看任务具体信息
		protected void makePlan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String dutyname = request.getParameter("dutyname");
			request.getSession().setAttribute("dutyname", dutyname);
			Duty list = ps.checkDutyList(dutyname);
			request.setAttribute("dutylist", list);
			this.checkPlanList(request, response);
			request.getRequestDispatcher("makePlan.jsp").forward(request, response);
		}
		//查看计划
		protected void checkPlanList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			 String dutyname= (String)request.getSession().getAttribute("dutyname");
			 List<Plan> list = ps.checkPlanList(dutyname);
			 request.setAttribute("planList", list);
		}
		//提交计划
		protected void planSubmit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String dutyname= (String)request.getSession().getAttribute("dutyname");
			Employee employee1= (Employee)request.getSession().getAttribute("employee1");
			String name = employee1.getName();
			String planname = request.getParameter("planname");
	        String planstarttime= request.getParameter("planstarttime");
	        String planendtime=request.getParameter("planendtime");
	        String planconcrete=request.getParameter("planconcrete");
	        String planstatus=request.getParameter("planstatus");
	        String planfeedback=request.getParameter("planfeedback");
	        boolean result = ps.planSubmit(dutyname,name,planname,planstarttime,planendtime,planconcrete,planstatus,planfeedback);
			if(result){
				this.updatePlan(request, response);
				this.checkPlan(request, response);
			}
		       
		}
		//更新任务状态
		protected void updatePlan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String dutyname= (String)request.getSession().getAttribute("dutyname");
			ps.updatePlan(dutyname);		
		}
		//查看反馈计划信息
		protected void checkFeedback(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			 String planname = request.getParameter("planname");
			 String dutyname=request.getParameter("dutyname");
			 Plan list =ps.checkFeedback(planname,dutyname);
			 request.setAttribute("feedback", list);
			 request.getRequestDispatcher("feedbackList.jsp").forward(request, response);
		}
	   //提交反馈信息
		protected void feedSubmit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			 String dutyname= (String)request.getSession().getAttribute("dutyname");
			 String planname = request.getParameter("planname");
			 String planstatus=request.getParameter("planstatus");
			 String planfeedback=request.getParameter("planfeedback");
			 String backmessage=request.getParameter("backmessage");
			 boolean result = ps.feedSubmit(dutyname,planname,planstatus,planfeedback,backmessage);
			 if(result){
				    request.setAttribute("backmessage", "反馈成功！");
					request.getRequestDispatcher("feedbackList.jsp").forward(request, response);
			}
		}
		//删除计划
		protected void deleteFeedback(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String planname = request.getParameter("planname");
			String dutyname = request.getParameter("dutyname");
			boolean result = ps.deleteFeedback(planname,dutyname);
			if(result){
				this.checkPlan(request, response);
			}
		}
		//查看员工下属任务
		protected void checkDuty(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			 Employee employee1= (Employee)request.getSession().getAttribute("employee1");
			 String staff = employee1.getName();
			 List<Duty> list = ps.checkDuty(staff);
			 request.setAttribute("plandutyList", list);
			 request.getRequestDispatcher("plandutyList.jsp").forward(request, response);
			
		}
		//查看员工下属任务
		protected void checkDuty1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			Employee employee1= (Employee)request.getSession().getAttribute("employee1");
			String staff = employee1.getName();
			List<Duty> list = ps.checkDuty(staff);
			request.setAttribute("plandutyList1", list);
		}
		//查询计划
		protected void seekPlan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String dutyname = request.getParameter("dutyname");
			String planfeedback=request.getParameter("planfeedback");
			String planstarttime1=request.getParameter("planstarttime1");
			String planendtime1=request.getParameter("planendtime1");
			System.out.println(planendtime1);
			String planstarttime2=request.getParameter("planstarttime2");
			String planendtime2=request.getParameter("planendtime2");
			if("".equals(planfeedback)==false&&planstarttime1.equals("")==true) {
			  List<Plan> list = ps.seekPlan(dutyname,planfeedback);
			  request.setAttribute("seekplanList", list);
			}else if(planfeedback.equals("")==true&&planstarttime1.equals("")==true) {
				System.out.println("111");
				List<Plan> list = ps.seekPlan1(dutyname);
				request.setAttribute("seekplanList", list);
			}else if(planfeedback.equals("")==true&&planstarttime1.equals("")==false) {
				List<Plan> list = ps.seekPlan2(dutyname,planstarttime1,planendtime1,planstarttime2,planendtime2);
				request.setAttribute("seekplanList", list);
			}
			else if(planfeedback.equals("")==false&&planstarttime1.equals("")==false) {
				List<Plan> list = ps.seekPlan3(dutyname,planfeedback,planstarttime1,planendtime1,planstarttime2,planendtime2);
				request.setAttribute("seekplanList", list);
			}
			this.checkDuty1(request, response);
			request.getRequestDispatcher("seekplanList.jsp").forward(request, response);
				
			
		}
		
		

}
