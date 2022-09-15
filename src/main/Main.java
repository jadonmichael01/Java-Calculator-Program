// NAME: JADONMICHAEL DE JESUS

package main;

import java.util.*;

public class Main {
    private static int getOp(String exp, int cur) {
        Scanner s = new Scanner(exp.substring(cur));
        s.useDelimiter("[^0-9]");
        return s.nextInt();
    }

    public static void main(String args[]) throws Exception {
        Stack<Integer> num = new Stack<>();
        Stack<Boolean> op = new Stack<>();
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.println("Please enter a new expression: ");
            String exp = s.nextLine();
            if (exp.equals("DONE"))
                break;
            int result = 0;
            boolean add = true;//if false, means subtract
            for (int cur = 0; cur < exp.length(); cur++) {
                if (exp.charAt(cur) == '(') { // push the current result and boolean
                    num.push(result);
                    op.push(add);
                    result = 0; // reset the result and boolean values
                    add = true;
                }
                else if (exp.charAt(cur) == ')') { // pop the current result and boolean values
                    result = op.pop()? num.pop() + result : num.pop() - result; // and add or subtract to the result
                } else if (exp.charAt(cur) == '+')
                    add = true;
                else if (exp.charAt(cur) == '-')
                    add = false;
                else if (Character.isDigit(exp.charAt(cur))) {
                    int operand = getOp(exp, cur);
                    while (cur < exp.length() && Character.isDigit(exp.charAt(cur)))
                        cur++;
                    cur--;
                    result = add ? result + operand : result - operand;
                }else
                    throw new Exception("Error: bad input");
                }

            System.out.println("The result is " + result);
        }
    }
}


