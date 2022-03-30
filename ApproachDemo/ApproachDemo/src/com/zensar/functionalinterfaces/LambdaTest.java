
package com.zensar.functionalinterfaces;

@FunctionalInterface
interface MathOperation {
	public int operation(int x, int y);
}

public class LambdaTest {
	public static void main(String[] args) {
		MathOperation addition = (int x, int y) -> x + y;
		MathOperation subtraction = (int x, int y) -> x - y;
		MathOperation multiplication = (int x, int y) -> x * y;
		MathOperation division = (int x, int y) -> x / y;
		System.out.println("Addtion : " + addition.operation(5, 10));
		System.out.println("Substraction : " + subtraction.operation(24, 2));
		System.out.println("Multiplication : " + multiplication.operation(55, 10));
		System.out.println("Division : " + division.operation(10, 2));
	}
}
