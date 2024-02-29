package main;

public class BinaryOperator extends Operator {

	char symbol;

	public BinaryOperator(char op) {
		super(op);
		symbol = op;
	}

	public int caculate(Operand od1, Operand od2) {
		char sl = symbol;
		int result = 0;
		switch (sl) {
		case '+':
			result = (od1.evaluate() + od2.evaluate());
			break;
		case '-':
			result = (od1.evaluate() - od2.evaluate());
			break;
		case '*':
			result = (od1.evaluate() * od2.evaluate());
			break;
		case '/':
			result = (od1.evaluate() / od2.evaluate());
			break;
		case '>':
			if (od1.evaluate() > od2.evaluate()) {
				result = 1;
				break;
			} else {
				result = 0;
				break;
			}
		case '<':
			if (od1.evaluate() < od2.evaluate()) {
				result = 1;
				break;
			} else {
				result = 0;
				break;
			}
		default:
			break;
		}
		return result;
	}
}
