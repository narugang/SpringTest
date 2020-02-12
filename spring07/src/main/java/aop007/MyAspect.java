package aop007;

import org.aspectj.lang.JoinPoint;

public class MyAspect {
	
	public void beforeMain(JoinPoint joinPoint) {
		//JoinPoint는 위 @before에서 선언한 메서드
		System.out.println("얼굴 인식 확인 : 문을 개방한다.");
		//System.out.println("열쇠로 문을 열고 집에 들어간다.");
	}
	public void lockDoor(JoinPoint joinPoint) {
		System.out.println("주인이 나감 : 문을 잠궈라");
	}
	
}
