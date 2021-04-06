package web_gradle_member_mgn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web_gradle_member_mgn.dao.MemberDao;
import web_gradle_member_mgn.dto.Member;

public class MemberDaoImpl implements MemberDao {
	private static final MemberDaoImpl instance = new MemberDaoImpl();

	public static MemberDaoImpl getInstance() {
		return instance;
	}

	private MemberDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	private Connection con;

	public void setCon(Connection con) {
		this.con = con;
	}

	@Override
	public Member selectMemberById(Member member) {
		String sql = "select id, name, age, gender, email\r\n" + "from mamber where id = ? and password = password(?) ";

		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPasswd());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return getMember(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Member selectMemberById2(Member member) {
		String sql = "select id, name, age, gender, email\r\n" + "from mamber where id = ?";

		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, member.getId());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return getMember(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Member> selectMemberByAll() {
		String sql = "select id, name, age, gender, email\r\n" + "from mamber";

		try (PreparedStatement pstmt = con.prepareStatement(sql); ResultSet rs = pstmt.executeQuery();) {
			if (rs.next()) {
				List<Member> list = new ArrayList<Member>();
				do {
					list.add(getMember(rs));
				} while (rs.next());
				return list;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Member getMember(ResultSet rs) throws SQLException {
		String id = rs.getString("id");
		String name = rs.getString("name");
		int age = rs.getInt("age");
		String gender = rs.getString("gender");
		String email = rs.getString("email");

		return new Member(id, name, age, gender, email);
	}

	@Override
	public int insertMember(Member member) {
		String sql = "insert into mamber values(?,password(?),?,?,?,?)";

		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPasswd());
			pstmt.setString(3, member.getName());
			pstmt.setInt(4, member.getAge());
			pstmt.setString(5, member.getGender());
			pstmt.setString(6, member.getEmail());
			return pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public int updateMember(Member member) {
		String sql = "update mamber set name=?, age=?, gender=?, email=? where id = ?";
		
		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, member.getName());
			pstmt.setInt(2, member.getAge());
			pstmt.setString(3, member.getGender());
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, member.getId());
			return pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteMember(Member member) {
		String sql = "delete from mamber where id = ?";

		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, member.getId());
			
			return pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
