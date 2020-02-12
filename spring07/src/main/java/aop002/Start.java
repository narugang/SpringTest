package aop002;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Start {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("resources.xml");
		
		Person romeo = ctx.getBean("boy", Person.class);
		romeo.runSomething();
		
		System.out.println("=============================");
		
		Person juliet = ctx.getBean("girl", Person.class);
		juliet.runSomething();
		((ClassPathXmlApplicationContext)ctx).close();
		
	}
}
