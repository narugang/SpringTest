package spring;

import java.util.Collection;

public class MemberListPrinter {
	
	private MemberDao memberDao;
	private MemberPrinter printer;
	
	public MemberListPrinter(MemberDao memberDao, MemberPrinter printer){
		System.out.println("memberListPrinter 동작");
		this.memberDao = memberDao;
		this.printer = printer;
	}
	
	public void printAll(){
		Collection<Member> members = memberDao.selectAll();
		System.out.println("Collection<Member> members 에 memberDao.selectAll()의 정보 담김");
		for(Member m : members){
			printer.print(m);
		}
	}
}
