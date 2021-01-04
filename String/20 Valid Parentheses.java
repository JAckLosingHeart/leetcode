/**
 * 这个思路来源于之间学中缀表达式的时候，就是通过栈这个结构来解决
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (stack.isEmpty() || c != map.get(stack.peek())) {
                stack.push(c);
            } else {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}