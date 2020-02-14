package spring;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import encrypt.Sha256Util;

public class ChangePasswordService {

	private MemberDao memberDao;
	
	public ChangePasswordService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	private PasswordEncoder encoder;
	public void setPasswordEncoder(PasswordEncoder encoder) {
		this.encoder = encoder;
	}
	
	@Transactional
	public void changePassword(String email, String oldPwd,String newPwd) {
		Member member = memberDao.selectByEmail(email);
		if(member == null) {
			throw new MemberNotFoundException();
		}
		
		//--> 직접 해싱값 만들어본 것
//		String dbPass = member.getPassword();
//		String oldSalt = dbPass.split("\\$")[1];
//		
//	//사용자가 입력한 평문을 위에서 가져온 salt값으로 해싱
//		StringBuffer eop = new StringBuffer();
//		eop.append(Sha256Util.getEncrypt(oldPwd, oldSalt)); 
//		eop.append("\\$").append(oldSalt); // 기존 비밀번호와 비교할 값 (salt를 다 붙인 온전한 값으로 비교하려고) 
//		oldPwd = eop.toString();
//		//위의 값이 원본의 비밀번호와 같다면--->
//		
//	//사용자가 입력한 새로운 비밀번호를 해싱하는 코드가 필요하다.
//		StringBuffer encryptPassword = new StringBuffer();
//		String newSalt = Sha256Util.genSalt();
//		encryptPassword.append(Sha256Util.getEncrypt(newPwd, newSalt));
//		encryptPassword.append("\\$").append(newSalt);
//		newPwd = encryptPassword.toString();
//		
//		
//	//---> 여기서 새로운 비밀번호를 넣어준다.
//		System.out.println("기존 비밀번호(db):" + member.getPassword());
//		System.out.println("기존 비밀번호(u)" + oldPwd);
		
		//[spring / 해싱]
		//---> 인코더야 ~ 새로운 패스워드 인코딩 해라
		newPwd = encoder.encode(newPwd);
		
		member.changePassword(oldPwd, newPwd);
		memberDao.update(member);
	}
}
