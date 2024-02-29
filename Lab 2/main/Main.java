package main;


public class Main {

	public static void main(String[] args) {

		/*
		 * input is full string expression
		 * you can uncomment lines 12-15 in order to evaluate some sample expressions
		 */
//		 Expression Ex = new Expression();
//		 String num = "8+3<8";
//		 long result = Ex.evaluate(num);
//		 System.out.println("The result of string expression is :"+result);

		/*
		 * expression = "8+3<8" Lab2 asks your team to create a sequence diagram for lines 20-28
		 */
		BinaryOperator br_plus = new BinaryOperator('+');
		Operand o1 = new Operand(8);
		Operand o2 = new Operand(3);
		Operand o3 = new Operand(br_plus.caculate(o1, o2));
		System.out.println(o3.evaluate());

		BinaryOperator br_smallerThan = new BinaryOperator('<');
		Operand o4 = new Operand(br_smallerThan.caculate(o3, o1));
		System.out.println(o4.evaluate());
	}
}
