package main;

import java.util.Stack;

public class Expression {
	private Stack<Operand> numberStack = null;
	private Stack<Operator> symbolStack = null;

	public Expression() {

	}

	public int evaluate(String input) {

		if (input != null) {
			input = input.replaceAll(" ", "");
		}
		if (isInt(input)) {	
			Operand o = new Operand(Integer.parseInt(input));
			return o.evaluate();
		}

		if (input.length() > 1 && !"=".equals(input.charAt(input.length() - 1) + "")) {
			input += "=";
		}

		numberStack = new Stack<Operand>();
		symbolStack = new Stack<Operator>();
		StringBuffer temp = new StringBuffer();

		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			if ((ch >= '0' && ch <= '9')) {
				temp.append(ch);
			} else {
				String tempStr = temp.toString();
				if (!tempStr.isEmpty()) {
					int num = Integer.parseInt(tempStr);
					Operand o1 = new Operand(num);
					numberStack.push(o1);
					temp = new StringBuffer();
				}

				while (!comparePriority(ch) && !symbolStack.empty()) {

					Operand b = numberStack.pop();
					Operand a = numberStack.pop();

					BinaryOperator br_plus = new BinaryOperator(symbolStack.pop().getOperator());
					Operand o2 = new Operand(br_plus.caculate(a, b));
					numberStack.push(o2);
				}

				if (ch != '=') {
					Operator or = new Operator(ch);
					symbolStack.push(or);
				}
			}
		}

		return numberStack.pop().evaluate();
	}

	private boolean comparePriority(char symbol) {
		if (symbolStack.empty()) {
			return true;
		}

		Operator top = symbolStack.peek();

		switch (symbol) {

		case '*': {
			if (top.getPriority() < 3)
				return true;
			else
				return false;
		}
		case '/': {
			if (top.getPriority() < 3)
				return true;
			else
				return false;
		}
		case '+': {
			if (top.getPriority() < 2)
				return true;
			else
				return false;
		}

		case '-': {
			if (top.getPriority() < 2)
				return true;
			else
				return false;
		}
		case '>':
			return false;

		case '<':
			return false;

		case '=':
			return false;
		default:
			break;
		}
		return true;
	}

	public static boolean isInt(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
