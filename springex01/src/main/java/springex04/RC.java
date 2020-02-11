package springex04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class RC {
	
	private TV tv;	//의존
	
		
	public RC(TV tv) {
		this.tv = tv;
	}
	
	@Autowired
	@Qualifier("tv1")	//setter 주입은 디폴트 생성자가 없으면 에러
	public void setTV(TV tv) {
		this.tv = tv;
	}
	
	public RC(){
		System.out.println("리모컨 생성");
	}
	public void rcMethod() {
		System.out.println("리모컨으로 ");
		tv.tvMethod();
	}
}	
