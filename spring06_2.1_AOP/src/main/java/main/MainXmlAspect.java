package main;

import org.springframework.context.support.GenericXmlApplicationContext;

import chap06.Calculator;


public class MainXmlAspect {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("aopOrder.xml");
		
		long fiveFact = 0;
		
		Calculator implCal = ctx.getBean("implCal", Calculator.class);
		fiveFact = implCal.factorial(5);
		System.out.println("impCal.factorial(5) = "+ fiveFact);
		
		Calculator recCal = ctx.getBean("recCal", Calculator.class);
		fiveFact = recCal.factorial(5);
		System.out.println("recCal.factorial(5) = " + fiveFact);
		ctx.close();
	}
}
