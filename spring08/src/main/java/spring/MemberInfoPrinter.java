package spring;

public class MemberInfoPrinter {
	private MemberDao memDao;
	private MemberPrinter printer;
	
	// 오류 해결을 위해 constructor생성 : 
	// Could not resolve matching constructor 
	//(hint: specify index/type/name arguments for simple parameters to avoid type ambiguities)
	public MemberInfoPrinter() {
		super();
	}
	public MemberInfoPrinter(MemberDao memDao, MemberPrinter printer) {
		super();
		this.memDao = memDao;
		this.printer = printer;
	}

	//
	
	public void setMemberDao(MemberDao memberDao){
		this.memDao = memberDao;
	}
	
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
