class Solution {
    // 记录s[i:]和p[j:]是不是匹配成功， memory
    Boolean[][] memo;
    public boolean isMatch(String s, String p) {
        // 每次调用函数都要初始化
        memo = new Boolean[s.length()+1][p.length()+1];
        // pattern长度是0的话，就要求string长度必须也是0，反之则不然
        if (p.length() == 0) {
            if (s.length() == 0)
                return true;
            else
                return false;
        }
        return dp(0, 0, s, p);
    }

    private boolean dp(int i, int j, String s, String p) {
        // 如果memory里已经有了直接返回
        if (memo[i][j] != null)
            return memo[i][j];
        Boolean result;
        // pattern到头了， string也到头才能返回true
        if (j == p.length()) {
            result = (i == s.length());
        } else {
            // 先判断当前字符是否一样
            Boolean first_match = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
            // 如果还有下一个字符是*，那么相当于是特殊情况，进行特殊的判断操作
            if (j+1 < p.length() && p.charAt(j+1) == '*') {
                result = (dp(i, j+2, s, p) || first_match && dp(i+1, j, s, p));
            } else {
                // 不特殊的话，直接往后挪一位
                result = first_match && dp(i+1, j+1, s, p);
            }
        }
        // 记录一下结果
        memo[i][j] = result;
        return result;
    }
}