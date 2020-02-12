package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import chap06.Calculator;
import config.JavaConfig2;

public class MainJavaAspect {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig2.class); 
		
		long fiveFact = 0;
		
		Calculator implCal = ctx.getBean("implCal", Calculator.class);
		fiveFact = implCal.factorial(5);
		System.out.println("impCal.factorial(5) = "+ fiveFact);
		System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
		Calculator recCal = ctx.getBean("recCal", Calculator.class);
		fiveFact = recCal.factorial(5);
		System.out.println("recCal.factorial(5) = "+ fiveFact);
		ctx.close();
	}
}
