package spring;

import java.util.Date;

import javax.annotation.Resource;

public class MemberRegisterService {
	@Resource
	private MemberDao memberDao;
	
	public MemberRegisterService(){}
	//@Resource는 interface같은 개념 생성자에 정의할 수 없게 되어있다.
	
	//@Autowired
	public MemberRegisterService(MemberDao memberDao){
		this.memberDao = memberDao;
	}
	
	public void regist(RegisterRequest req){
		Member member = memberDao.selectByEmail(req.getEmail());
		if(member != null){
			throw new AlreadyExistingMemberException(
						"dup email " + req.getEmail());
		}
		Member newMember = new Member(
				req.getEmail(),
				req.getPassword(),
				req.getName(),
				new Date()
				);
		memberDao.insert(newMember);		
	}
}
