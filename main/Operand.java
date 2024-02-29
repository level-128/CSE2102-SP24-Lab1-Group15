package main;


public class Operand extends Expression {

	int value;

	public Operand(int i) {
		super();
		value = i;

	}

	public int evaluate() {
		return value;
	}


}
