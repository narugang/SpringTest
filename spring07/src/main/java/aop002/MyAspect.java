package aop002;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspect {

	@Before("execution(public void aop002.Boy.runSomething()) || execution(public void aop002.Girl.runSomething())")
	
	public void beforeMain(JoinPoint joinPoint) {
		//JoinPoint는 위 @before에서 선언한 메서드
		System.out.println("얼굴 인식 확인 : 문을 개방한다.");
		//System.out.println("열쇠로 문을 열고 집에 들어간다.");
	}
}
