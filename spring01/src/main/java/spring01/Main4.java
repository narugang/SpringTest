package spring01;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main4 {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("applicationContext3.xml");
		
		Calculator cal = ctx.getBean("calc", Calculator.class);
		
		System.out.println(cal.add(10, 10));
		System.out.println(cal.sub(10, 10));
		System.out.println(cal.mul(10, 10));
		System.out.println(cal.div(10, 10));
	}
	
	
}
