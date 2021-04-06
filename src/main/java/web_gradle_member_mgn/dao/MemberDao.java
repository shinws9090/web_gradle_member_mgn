package web_gradle_member_mgn.dao;

import java.util.List;

import web_gradle_member_mgn.dto.Member;

public interface MemberDao {
	
	Member selectMemberById(Member member);

	List<Member> selectMemberByAll();

	int insertMember(Member member);

	Member selectMemberById2(Member member);

	int deleteMember(Member member);

	int updateMember(Member member);
}
