class Solution {//用一组数作key时，要么就转为string，要么就用list

    public String longestPalindrome(String s) {
        int length = s.length();
        int left = 0, right = 0;
        boolean[][] p = new boolean[length][length];
        for (int i = 0; i < length; i++)
            for (int j = 0;j < length; j++){
                if (i == j) {
                    p[i][j] = true;
                    continue;
                }
                if (j == i+1 && s.charAt(i) == s.charAt(j)) {
                    p[i][j] = true;
                    left = i;
                    right = j;
                    continue;
                }
                p[i][j] = false;
            }
        for (int subLen = 3; subLen <= length; subLen++)
            for (int i = 0; i < length + 1 - subLen; i++)
                if (s.charAt(i) == s.charAt(i + subLen - 1) && p[i + 1][i + subLen - 2]) {
                    p[i][i + subLen - 1] = true;
                    left = i;
                    right = i + subLen - 1;
                }
        return s.substring(left, right + 1);
    }
}