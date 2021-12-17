package comp2011.lab3;

public class MultipleBalanced {

    public static boolean isMultipleBalanced(char[] s) {
        CharStack stack = new CharStack();
        for (int i = 0; i < s.length; i++) {
            // System.out.println(stack);
            if (s[i] == '(' || s[i] == '[' || s[i] == '{' || s[i] == '<') stack.push(s[i]);
            if (s[i] == ')') {
                if (stack.isEmpty()) return false;
                char c = stack.pop();
                if (c != '(' && c != '<') return false;
            }
            if (s[i] == ']') {
                if (stack.isEmpty()) return false;
                char c = stack.pop();
                if (c != '[' && c != '<') return false;
            }
            if (s[i] == '}') {
                if (stack.isEmpty()) return false;
                char c = stack.pop();
                if (c != '{' && c != '<') return false;
            }
            if (s[i] == '>') {
                if (stack.isEmpty()) return false;
                char c = stack.pop();
                if (c != '(' && c != '[' && c != '{' && c != '<') return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "{[]<[>)[]}";//"{ ( } )";
        System.out.println(s + (isMultipleBalanced(s.toCharArray()) ? " is " : " is not ") + "balanced.");
    }

}
