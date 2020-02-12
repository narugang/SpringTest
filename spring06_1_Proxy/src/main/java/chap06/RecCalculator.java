package chap06;

//implements Calculator로 Calculator interface를 Override해서 이용한다.
//interface 를 구현하는 두 번째 메서드 구현
//재귀호출을 이용한 팩토리얼을 구하는 기능의 클래스

public class RecCalculator implements Calculator{

	@Override
	public long factorial(long num) {
		if(num == 0) {
			return 1;
		}
		else {
			return num * factorial(num - 1);
		}
		
	}
	
}
