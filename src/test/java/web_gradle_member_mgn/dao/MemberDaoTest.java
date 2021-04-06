package web_gradle_member_mgn.dao;

import java.sql.Connection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import web_gradle_member_mgn.dao.impl.MemberDaoImpl;
import web_gradle_member_mgn.dto.Member;

public class MemberDaoTest {
	private MemberDaoImpl dao;
	private static Connection con;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		con = JdbcUtil.getConnection();
	}
	
	@Before
	public void setUp() throws Exception {
		dao =MemberDaoImpl.getInstance();
		dao.setCon(con);
	}

	@After
	public void tearDown() throws Exception {
		dao =null;
	}
	@Test
	public void testSelectMemberById() {
		Member member = new Member("1","1111");
		Member a = dao.selectMemberById(member);
		Assert.assertNotNull(a);
		System.out.println(a);
	}
	@Test
	public void testInsertMember() {
		Member member = new Member("sdfsfd","1111","sd",30,"sdfa","asdf");
		int a = dao.insertMember(member);
		Assert.assertEquals(1, a);
		System.out.println(dao.selectMemberById(member));
	}

}
