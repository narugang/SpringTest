package springex06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		//@Resource 사용
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:appctx6.xml");
		
		RC rc = ctx.getBean("rc", RC.class);
		rc.rcMethod();
	}
}	
