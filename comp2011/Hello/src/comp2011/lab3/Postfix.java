package comp2011.lab3;

import java.util.StringTokenizer;

public class Postfix {

    /*
     * This method is not related to our course.
     * Its purpose here is to demostrate the use of StringTokenizer.
     * More imformation can be found in Java API.
     */

    public static int evalPostFix(String postfix) {
        StringTokenizer parser = new StringTokenizer(postfix, " \n\t\r+-*/", true);
        // 13 2 1 - - has five tokens,
        IntStack stack = new IntStack();
        while (parser.hasMoreTokens()) {
            String token = parser.nextToken();
            if (token.equals(" ")) {
                continue;
            }
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(operand1 + operand2);
                        break;
                    case "-":
                        stack.push(operand1 - operand2);
                        break;
                    case "*":
                        stack.push(operand1 * operand2);
                        break;
                    case "/":
                        stack.push(operand1 / operand2);
                        break;
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println("3 2 - 1 - = " + evalPostFix("3 2 - 1 -")); // - 3 2
        System.out.println("3 2 1 - - = " + evalPostFix("3 2 1 - -"));
        System.out.println("5 1 - 2 - 6 5 / + = " + evalPostFix("5 1 - 2 - 6 5 / +"));
    }

}
