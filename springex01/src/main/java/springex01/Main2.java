package springex01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main2 {
	public static void main(String[] args) {
		//@Autowired 사용
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:appctx.xml");
		
		RC rc = ctx.getBean("rc", RC.class);
		rc.rcMethod();
	}
}	
