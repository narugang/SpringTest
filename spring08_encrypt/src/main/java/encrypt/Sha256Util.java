package encrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/*우리가 직접 정의하는 암호화 유틸*/
public class Sha256Util {
	
	public static String getEncrypt(String source,String salt) {
		return getEncrypt(source, salt.getBytes());
	}
	
	
	public static String getEncrypt(String source, byte[] salt) {
		String resultValue = "";
		
		//바이트 단위로 소스를 쪼개려고
		byte[] src = source.getBytes();
		byte[] bytes = new byte[src.length + salt.length];
		
		System.arraycopy(src, 0, bytes, 0, src.length);
		System.arraycopy(salt, 0, bytes, src.length, salt.length);
		
		//이제 암호화 작업이 필요하다.
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(bytes);
			byte[] byteData = md.digest(); // byte[]로 돌아오는 값 hashing
			
			StringBuffer sb = new StringBuffer();
			for(int i=0; i<byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 256, 16).substring(1)); // 여기를 이해하려하지 마라 (양수로 만들어주는 과정이라고만 알아두기)
			}
			resultValue = sb.toString();	// 해싱 된 결과가 써 먹을 수 있는 결과로 반환된다.
		}
		catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return resultValue;
	}
	
	
	
	/*salt를 만드는 코드*/
	public static String genSalt() {
		Random random = new Random();
		
		byte[] salt = new byte[8];
		random.nextBytes(salt);
		
		System.out.println("salt" + salt);
		
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<salt.length; i++) {
			sb.append(String.format("%02x", salt[i]));
		}
		System.out.println("salt ret :" + sb.toString());
		return sb.toString();
		//16진수의 특정 문자열로 만듬(%02x)
	}
}
