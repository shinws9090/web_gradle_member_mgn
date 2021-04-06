package web_gradle_member_mgn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web_gradle_member_mgn.dto.Member;
import web_gradle_member_mgn.service.MemberService;

@WebServlet("/memberList")
public class MemberList extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MemberService service = new MemberService();
    
    public MemberList() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//userId=1 & pwd=asdf
		List<Member> members =null;
		Member member = (Member) request.getSession().getAttribute("member");
		
		
		if(member ==null) {
			request.getRequestDispatcher("admin/member_list.jsp").forward(request, response);
		}else if(member.getId().equals("admin")) {
			members = service.showMembers();
			
			if(members !=null){
				request.setAttribute("members", members);
				request.getRequestDispatcher("admin/member_list.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("admin/main.jsp").forward(request, response);
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
