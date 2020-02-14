package spring;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainForMemberDao {

	private static MemberDao memberDao;
	
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:addCtx.xml");
		memberDao = ctx.getBean("memberDao", MemberDao.class);
		
		selectAll();
		updateMember();
		insertMember();
		selectAll();
		
		ctx.close();
	}
	
	private static void selectAll() {
		System.out.println("------selectAll");
		int total = memberDao.count();
		System.out.println("전체 데이터 :" + total);
		List<Member> member = (List<Member>) memberDao.selectAll();
		for(Member m : member) {
			System.out.println(
					m.getId() + ":" + m.getEmail() + ":" + m.getName());
		}
	}
	
	private static void updateMember() {
		System.out.println("--------updateMember");
		Member member = memberDao.selectByEmail("garnet2929@naver.com");
		String oldPw = member.getPassword();
		String newPW = Double.toHexString(Math.random());
		member.changePassword(oldPw, newPW);
		
		memberDao.update(member);
		System.out.println("암호 번경 :" + oldPw + ">" + newPW);
		
	}
	
	private static void insertMember() {
		System.out.println("---------insertMember");
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMddHHmmss");
		String prefix = dateFormat.format(new Date());
		Member member = new Member(prefix + "@test.com", prefix, prefix, new Date());
		memberDao.insert(member);
		System.out.println(member.getId() + "데이터 추가");
	}
}
