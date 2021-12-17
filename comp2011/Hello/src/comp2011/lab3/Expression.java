package comp2011.lab3;

public class Expression {

    public static boolean isBalanced(char[] s) {
        int count = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == '(')
                count++;
            if (s[i] == ')')
                count--;
            if (count < 0)
                return false;
        }
        return count == 0;
    }

    public static boolean isMultipleBalanced(char[] s) {
        CharStack stack = new CharStack();
        for (int i = 0; i < s.length; i++) {
            // System.out.println(stack);
            if (s[i] == '(' || s[i] == '[' || s[i] == '{') stack.push(s[i]);
            if (s[i] == ')') {
                if (stack.isEmpty()) return false;
                char c = stack.pop();
                if (c != '(') return false;
            }
            if (s[i] == ']') {
                if (stack.isEmpty()) return false;
                char c = stack.pop();
                if (c != '[') return false;
            }
            if (s[i] == '}') {
                if (stack.isEmpty()) return false;
                char c = stack.pop();
                if (c != '{') return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "(()(()))";
        System.out.println(s + (isBalanced(s.toCharArray()) ? " is " : " is not ") + "balanced.");
        s = "(()((()))";
        System.out.println(s + (isBalanced(s.toCharArray()) ? " is " : " is not ") + "balanced.");
        s = "{[]([])[]}";//"{ ( } )";
        System.out.println(s + (isMultipleBalanced(s.toCharArray()) ? " is " : " is not ") + "balanced.");
        System.out.println(s + (geek(s.toCharArray()) ? " is " : " is not ") + "balanced.");
        s = "{[]<[>)[]}";//"{ ( } )";
        System.out.println(s + (isMultipleBalanced(s.toCharArray()) ? " is " : " is not ") + "balanced.");
    }

    // Geek's version. It's fine if you don't understand it.
    public static boolean geek(char[] s) {
        CharStack stack = new CharStack();
        for (int i = 0; i < s.length; i++) {
            // System.out.println(stack);
            if (s[i] == '(' || s[i] == '[' || s[i] == '{')
                stack.push(s[i]);
            if (s[i] == ')' || s[i] == ']' || s[i] == '}') {
                int d = s[i] - stack.pop();
                if (d < 0 || d > 2) return false;
            }
        }
        return stack.isEmpty();
    }
}
