package ordertestaround;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

@Aspect
@Order(0)
public class OrderZeroAspect {
	@Around("execution(void *.run())")
	public void printOrder(ProceedingJoinPoint jp) {
		try {
			System.out.println("before:order 0");
			jp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("after:order 0");
	}
}
