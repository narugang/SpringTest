package springex05;

import javax.annotation.Resource;

public class RC {
	
	@Resource
	//멤버 필드의 이름과 동일한 이름의 빈 객체 주입(tv가 없으면 타입을 찾음)
	//없으면 동일한 타입의 객체 주입(2개 이상이면 에러)
	private TV tv;	//의존
	
		
	public RC(TV tv) {
		this.tv = tv;
	}
	
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
