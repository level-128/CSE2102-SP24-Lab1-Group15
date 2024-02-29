class NumStorage:
    def __init__(self):
        self.number: int = [0] * 100
        self.top = -1

    def in_num_storage(self, num) -> None:
        self.top += 1
        self.number[self.top] = num

    def read_num_storage(self) -> int:
        return self.number[self.top]

    def get_num_data(self):
        num = self.number[self.top]
        self.top -= 1
        return num


class SymbolStorage:
    def __init__(self):
        self.symbol = [''] * 100
        self.top = -1

    def in_symbol_storage(self, ch):
        self.top += 1
        self.symbol[self.top] = ch

    def read_symbol_storage(self):
        return self.symbol[self.top]

    def get_symbol(self):
        symbol = self.symbol[self.top]
        self.top -= 1
        return symbol

    @staticmethod
    def judge_symbol_priority(ch):
        if ch == '(':
            return 1
        elif ch == '+' or ch == '-':
            return 2
        elif ch == '*' or ch == '/':
            return 3
        elif ch == ')':
            return 4


def math(v1, v2, c):
    if c == '+':
        return v1 + v2
    elif c == '-':
        return v1 - v2
    elif c == '*':
        return v1 * v2
    elif c == '/':
        return v1 / v2

if __name__ == "__main__":
    print("Enter the expression (no blank, no decimals): ")
    data = NumStorage()
    symbol = SymbolStorage()
    user_input = input()
    t = sum_val = 0
    v = [''] * 100

    for i in range(len(user_input)):
        if user_input[i].isdigit() or (i == 0 and user_input[i] == '-') or (user_input[i] == '-' and user_input[i-1] == '('):
            # handleing digits
            start = i
            if user_input[i] == '-':
                i += 1
            while i < len(user_input) and user_input[i].isdigit():
                i += 1
            num = int(user_input[start:i])
            data.in_num_storage(num)
            i -= 1  
        elif user_input[i] in "+-*/()":
            
            while symbol.top != -1 and symbol.judge_symbol_priority(user_input[i]) <= symbol.judge_symbol_priority(symbol.read_symbol_storage()):
                if user_input[i] == '(':
                    break
                v2 = data.get_num_data()
                if data.top == -1:
                    break
                v1 = data.get_num_data()
                op = symbol.get_symbol()
                if op == '(' and user_input[i] == ')':
                    break
                sum_val = math(v1, v2, op)
                data.in_num_storage(sum_val)
            if user_input[i] != ')':
                symbol.in_symbol_storage(user_input[i])
            else:
                symbol.get_symbol()

    while symbol.top != -1:
        v2 = data.get_num_data()
        v1 = data.get_num_data()
        op = symbol.get_symbol()
        sum_val = math(v1, v2, op)
        data.in_num_storage(sum_val)

    print("The result is: ", data.read_num_storage())

