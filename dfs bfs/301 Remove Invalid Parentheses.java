/**
 * 深度优先的遍历（常常会用到递归）一般势必要回溯
 * 这就是一道回溯遍历所有情况的题
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    private Set<String> results = new HashSet<>();
    private int minimumRemove;

    private void clear() {
        results.clear();
        minimumRemove = Integer.MAX_VALUE;
    }
    public List<String> removeInvalidParentheses(String s) {
        clear();
        recursiveTraverse(s, 0, 0, 0, new StringBuilder(), 0);
        // ArrayList可以直接被collections初始化
        return new ArrayList<>(results);
    }

    private void recursiveTraverse(String string, int index, int leftCount, int rightCount,
                                   StringBuilder stringBuilder, int removedCount) {
        if (index == string.length()) {
            if (leftCount == rightCount) {
                if (removedCount < minimumRemove) {
                    results.clear();
                    results.add(stringBuilder.toString());
                    minimumRemove = removedCount;
                } else if (removedCount == minimumRemove) {
                    results.add(stringBuilder.toString());
                }
            }
        } else {
            Character currCharacter = string.charAt(index);
            int length = stringBuilder.length();
            if (currCharacter != '(' && currCharacter != ')') {
                stringBuilder.append(currCharacter);
                recursiveTraverse(string, index + 1, leftCount, rightCount, stringBuilder, removedCount);
                stringBuilder.deleteCharAt(length);
            } else {
                recursiveTraverse(string, index + 1, leftCount, rightCount,
                        stringBuilder, removedCount + 1);
                stringBuilder.append(currCharacter);
                if (currCharacter == '(') {
                    recursiveTraverse(string, index + 1, leftCount + 1, rightCount,
                            stringBuilder, removedCount);
                } else if (leftCount > rightCount) {
                    recursiveTraverse(string, index + 1, leftCount, rightCount + 1,
                            stringBuilder, removedCount);
                }
                // StringBuilder的deleteCharAt()
                stringBuilder.deleteCharAt(length);
            }
        }
    }
}