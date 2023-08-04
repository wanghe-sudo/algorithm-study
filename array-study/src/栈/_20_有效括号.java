package 栈;

import java.util.Stack;

public class _20_有效括号 {
    public boolean isValid(String s) {
        if (null == s || s.isEmpty()) {
            return true;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (!stack.isEmpty()) {
                    Character pop = stack.pop();
                    if (pop == '(' && c != ')') {
                        return false;
                    }
                    if (pop == '{' && c != '}') {
                        return false;
                    }
                    if (pop == '[' && c != ']') {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
