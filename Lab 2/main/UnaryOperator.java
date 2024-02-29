package main;

public class UnaryOperator extends Operator {

	char symbol;

	public UnaryOperator(char op) {
		super(op);
		symbol = op;
	}

	public int caculate(Operand od1) {

		char sl = symbol;
		int result = od1.evaluate();
		if (sl == '-') {
			result = od1.evaluate() * (-1);
		}
		return result;
	}
}
