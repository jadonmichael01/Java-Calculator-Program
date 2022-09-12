# Java-Calculator-Program

Implemented a simple calculator supporting integer values with only two operations addition and subtraction. The program receives an expression like 95 − (12 + 33) from the keyboard and prints out the result (50 in this case) on the screen.

Please note that the input expression may include nested parentheses like 2+(1−(3+((4−1)+(12−6))))

Therefore, my program uses the stack data structure (like java.util.Stack) to store the intermediate results of inner parentheses and/or the operators.
