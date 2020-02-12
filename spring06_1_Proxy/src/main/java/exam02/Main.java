package exam02;

public class Main {
	public static void main(String[] args) {
		Pet cat = new Proxy(new Cat());
		Pet dog = new Proxy(new Dog());
		/*
		 * 개나 고양이가 cry()하면 그 시점 전 , 후에 어떤 기능을 실행하고자 한다.
		 * 1. 공통 기능이 적용될 핵심 기능에 대해 인터페이스를 생성
		 * 2. 핵심 기능에 해당되는 클래스는 1에서 만든 인터페이스를 구현하도록 만듬 
		 * 3. 핵심 기능을 호출하는 공통기능이 정의된 클래스(Proxy)를 작성한다.
		 * */
		
		//System.out.println("울기 전");
		cat.cry();
		//System.out.println("울기 후");
		//System.out.println("울기 전");
		dog.cry();
		//System.out.println("울기 후");
		
		
	}
}
