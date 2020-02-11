package springex03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		//@Autowired 사용 - setter 주입
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:appctx3.xml");
		
		RC rc = ctx.getBean("rc", RC.class);
		rc.rcMethod();
	}
}	
