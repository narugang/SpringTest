package spring;

import java.util.Date;

import org.springframework.security.crypto.password.PasswordEncoder;

//import org.springframework.security.authentication.encoding.PasswordEncoder;

public class MemberRegisterService {
	private MemberDao memberDao;
	
	public MemberRegisterService(MemberDao memberDao){
		this.memberDao = memberDao;
	}
	
	//---> spring에서 지원하는 암호화
	private PasswordEncoder encoder;
	public void setPasswordEncoder(PasswordEncoder encoder) {
		this.encoder = encoder;
	}
	//<---요기까지
	
	
	public void regist(RegisterRequest req){
		Member member = memberDao.selectByEmail(req.getEmail());
		if(member != null){
			throw new AlreadyExistingMemberException(
						"dup email " + req.getEmail());
		}
		
//		// 암호화 시작 -->
//		StringBuffer encryptPassword = new StringBuffer();
//		
//		String password = req.getPassword();
//		String salt = Sha256Util.genSalt();
//		
//		encryptPassword.append(Sha256Util.getEncrypt(password, salt));
//		encryptPassword.append("\\$").append(salt);
//		
//		System.out.println(encryptPassword.toString());
//		
//		req.setPassword(encryptPassword.toString());
//		
//		// --> 암호화 코드 끝
		
		//---> 요기까지 하면
		String password = req.getPassword();
		password = encoder.encode(password);
		req.setPassword(password);
		//<--- spring에서 해쉬값으로 바꿔줌
		
		
		Member newMember = new Member(
				req.getEmail(),
				req.getPassword(),
				req.getName(),
				new Date()
				);
		memberDao.insert(newMember);		
	}
}
