package chap06;

//implements Calculator로 Calculator interface를 Override해서 이용한다.
// interface 를 구현하는 첫 번째 메서드 구현
// for문을 이용해 팩토리얼을 수하는 기능의 클래스를 만듬

public class ImplCalculator implements Calculator{

	@Override
	public long factorial(long num) {
		System.out.println("핵심");
		long result = 1;
		for(int i = 1; i <= num; i++) {
			result *= i;
		}
		return result;
	}
	
}
