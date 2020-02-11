package spring;

import javax.annotation.Resource;

public class MemberInfoPrinter {
	
	//@Autowired
	@Resource
	private MemberDao memDao;
	
	private MemberPrinter printer;
	
	public void setMemberDao(MemberDao memberDao){
		this.memDao = memberDao;
	}
	
	//@Autowired
	//@Qualifier("sysout")
	@Resource(name="memberPrinter1")
	public void setMemberPrinter(MemberPrinter printer){
		this.printer = printer;
	}
	
	public void printMemberInfo(String email){
		Member member = memDao.selectByEmail(email);
		if(member == null){
			System.out.println("정보 없음!\n");
			return;
		}
		printer.print(member);
		System.out.println();
	}
}
