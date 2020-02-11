package springex03;

import org.springframework.beans.factory.annotation.Autowired;

public class RC {
	
	private TV tv;	//의존
	

//	public RC(TV tv) {
//		this.tv = tv;
//	}
	
	@Autowired
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
