package stack;

import java.util.Stack;

public class redundant_braces {
/*    public static void main(String[] args) {

        System.out.println(braces("a+b"));
    }

    public static int braces(String A) {
        Stack<Character> stack = new Stack<>();
        char[] array = A.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (!Character.isLetter(array[i])) {
                if (array[i] == ')') {
                    stack.pop();
                    if (!stack.isEmpty()) {
                        stack.pop();
                    } else {
                        return 1;
                    }
                } else {
                    stack.push(array[i]);
                }
            }
        }
        return stack.isEmpty() ? 0 : 1;
    }*/
}
