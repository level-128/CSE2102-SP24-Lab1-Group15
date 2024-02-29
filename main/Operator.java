package main;


public class Operator {

	char symbol;
	int priority;

	public Operator(char or) {

		symbol = or;
		switch (or) {

		case '*': {
			priority=3;
			break;
		}
		case '/': {
			priority=3;
			break;
		}
		case '+': {
			priority=2;
			break;
		}
		case '-': {
			priority=2;
			break;
		}
		case '>':
			priority=1;
			break;
		case '<':
			priority=1;
			break;
		case '=':
			priority=0;
			break;
		default:
			break;
		}
	}

	public char getOperator() {
		return symbol;
	}
	
	public int getPriority() {
		return priority;
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
		default:
			break;
		}
		return result;
	}
}
