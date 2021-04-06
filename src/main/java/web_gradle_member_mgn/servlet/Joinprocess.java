package web_gradle_member_mgn.servlet;

import java.io.IOException;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web_gradle_member_mgn.dto.Member;
import web_gradle_member_mgn.service.MemberService;

@WebServlet("/joinprocess")
public class Joinprocess extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService service = new MemberService();

	public Joinprocess() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		String passwd = request.getParameter("pass");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");

		Member member = new Member(id, passwd, name, age, gender, email);
		int res = service.addMember(member);
		Member m = (Member) request.getSession().getAttribute("member");
		
		if (m==null) {
			if (res == 1) {
				request.getRequestDispatcher("loginForm.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("joinForm.jsp").forward(request, response);
			}
		} else if (m.getId().equals("admin")){
			request.getRequestDispatcher("memberList").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
