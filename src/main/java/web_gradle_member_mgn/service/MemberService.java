package web_gradle_member_mgn.service;

import java.sql.Connection;
import java.util.List;

import web_gradle_member_mgn.dao.impl.MemberDaoImpl;
import web_gradle_member_mgn.ds.JndiDS;
import web_gradle_member_mgn.dto.Member;

public class MemberService {
	private MemberDaoImpl dao = MemberDaoImpl.getInstance();
	private Connection con = JndiDS.getConnection();
	
	
	public MemberService() {
		dao.setCon(con);
	}


	public Member loginMember(Member member) {
		return dao.selectMemberById(member);
	}
	
	public Member showMember(Member member) {
		return dao.selectMemberById2(member);
	}
	
	public List<Member> showMembers() {
		return dao.selectMemberByAll();
	}


	public int addMember(Member member) {
		return dao.insertMember(member);
	}
	public int modifyMember(Member member) {
		return dao.updateMember(member);
	}
	public int removeMember(Member member) {
		return dao.deleteMember(member);
	}
}
