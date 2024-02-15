# CSE-2102-Lab1

This is a Lab assignment for Uconn CSE 2102. This is not an OSS project, and it is under proprietary terms.

Generally how this code works as a calculator:
1. Iterate through each character in the input expression.
2. When encountering digits, push them onto the numbers stack.
3. When encountering operators or parentheses, we push them onto the symbols stack.
4. When encountering a closing parenthesis:
       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;evaluate the expression within the parentheses until we encounter the corresponding opening parenthesis.  
       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;perform operations according to the order of operations.  
5. After iterating through the entire expression, perform the final evaluation to handle any remaining operators.
6. The final result is the top element of the operand stack.
