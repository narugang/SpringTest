package spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainForCPS {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:addCtx.xml");
		
		ChangePasswordService cps = ctx.getBean("changePwdSvc", ChangePasswordService.class);
		
		try {
			cps.changePassword("garnet2929@naver.com", "0x1.e7f595e51cab8p-2","1234");
			System.out.println("암호를 변경하였습니다.");
		} catch(MemberNotFoundException e) {
			System.out.println("회원 정보가 존재하지 않습니다.");
		} catch(IdPasswordNotMatchingException e) {
			System.out.println("암호를 다시 확인하세요.");
		}
	}
}
