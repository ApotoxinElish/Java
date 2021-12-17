package comp2011.lab3;

import java.util.Scanner;

public class DuplicateRemover {
    public static String remove(String str) {
        CharStack stack = new CharStack(str.length());
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!stack.isEmpty() && stack.peek() == c) stack.pop();
            else stack.push(c);
        }
        return stack.toString();
    }

    public static void main(String[] args) throws Exception {
        String s;
//        s = "careermonk";
//        System.out.println(s + " becomes " + remove(s));
        s = "mississippi";
        System.out.println(s + " becomes " + remove(s));
//        s = "香港港安醫院院長";
//        System.out.println(s + " becomes " + remove(s));

//        System.out.print("Please input a string: ");
//        Scanner input = new Scanner(System.in);
//        String str = input.next();
//        System.out.println(str + " becomes " + remove(str));
//        input.close();
    }
}
