/**
 * 像这种括号找配合的，用栈常常很方便
 */

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        String result = new String();
        List<Integer> toRemove = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                stack.push(i);
            else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    toRemove.add(i);
                } else {
                    stack.pop();
                }
            }
        }
        toRemove.addAll(stack);
        for (int i = 0; i < s.length(); i++) {
            if (!toRemove.contains(i))
                result += s.charAt(i);
        }
        return result;
    }
}