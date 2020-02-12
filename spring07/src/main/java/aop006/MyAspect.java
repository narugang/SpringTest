package aop006;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAspect {
	@Pointcut("execution(* runSomething())")
	private void imple() {
		
	}
	
	
	@Before("imple()")
	public void beforeMain(JoinPoint joinPoint) {
		//JoinPoint는 위 @before에서 선언한 메서드
		System.out.println("얼굴 인식 확인 : 문을 개방한다.");
		//System.out.println("열쇠로 문을 열고 집에 들어간다.");
	}
	
	@After("imple()")
	public void lockDoor(JoinPoint joinPoint) {
		System.out.println("주인이 나감 : 문을 잠궈라");
	}
}
