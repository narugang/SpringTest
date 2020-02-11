package springex04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		//@Autowired 사용
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:appctx4.xml");
		
		RC rc = ctx.getBean("rc", RC.class);
		rc.rcMethod();
	}
}	
