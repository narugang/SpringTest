package main;

import chap06.ExeTimeCalculator;
import chap06.ImplCalculator;
import chap06.RecCalculator;

public class MainProxy {
	public static void main(String[] args) {
		ExeTimeCalculator ttCall = new ExeTimeCalculator(new ImplCalculator());
		System.out.println(ttCall.factorial(20));
		
		ExeTimeCalculator ttCall2 = new ExeTimeCalculator(new RecCalculator());
		System.out.println(ttCall2.factorial(20));
}
}
