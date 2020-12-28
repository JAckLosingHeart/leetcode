import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        // 记住所有可以被wordDict解析的字符串
        Set<String> wordsBreakable = new HashSet<>();
        // 只有一个字符的字符串比较特殊，因为不用拆分
        for (char c : s.toCharArray()) {
            if (wordDict.contains(""+c))
                wordsBreakable.add(""+c);
        }
        for (int subLen = 2; subLen <= s.length(); subLen++) {
            for (int i = 0; i < length+1-subLen; i++) {
                String substring = s.substring(i, i + subLen);
                // 先直接看有没有在wordDic里
                if (wordDict.contains(substring)) {
                    wordsBreakable.add(substring);
                    continue;
                }
                // 再看能不能被更小的字符串组成
                for (int j = 0; j < subLen-1; j++) {
                    if (wordsBreakable.contains(substring.substring(0, j+1))
                    && wordsBreakable.contains(substring.substring(j+1, subLen))) {
                        wordsBreakable.add(substring);
                        continue;
                    }
                }
            }
        }
        return wordsBreakable.contains(s);
    }
}