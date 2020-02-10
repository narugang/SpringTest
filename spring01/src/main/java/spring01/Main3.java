package spring01;


import org.springframework.context.support.GenericXmlApplicationContext;

public class Main3 {
	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext2.xml");
		
		//spring 에서 관리하는 위 객체는 기본 싱글톤으로 동작한다.(하나의 객체만 만든다.)
		Greeter g1 = ctx.getBean("greeter1", Greeter.class);
		Greeter g2 = ctx.getBean("greeter2", Greeter.class);
		
		System.out.println(g1 == g2);
		ctx.close();
	}
}
