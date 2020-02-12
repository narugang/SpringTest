package aspect;

import java.util.Arrays;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect
@Order(0)
public class ExeTimeAspect2 {
	
	@Pointcut("execution(public * chap06..*(..))")
	private void publicTarget() {
		
	}
	
	@Around("publicTarget()")
	public Object measure(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.nanoTime();
		try {
			System.out.println("time before");

			Object result = joinPoint.proceed(); //factorial()
			System.out.println("time after");

			return result;
		}
		finally {
			long finish = System.nanoTime();
			Signature sig = joinPoint.getSignature();
			System.out.printf("%s, %s(%s) 실행 시간 : %d ns\n",
					joinPoint.getTarget().getClass().getSimpleName(),
					sig.getName(),Arrays.deepToString(joinPoint.getArgs()),
					(finish - start)
					);
		}
	}
}
