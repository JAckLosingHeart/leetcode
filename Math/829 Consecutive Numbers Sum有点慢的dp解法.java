/**
 * 数组里常常存储的值就是那些子问题的结果
 */

import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<String, Integer> map = new HashMap<>();
    public static void main(String args[]) {
        System.out.println(new Solution().consecutiveNumbersSum(855204));
    }
    public int consecutiveNumbersSum(int N) {
        int mid = N/2;
        int result = 0;
        for (int i = 1; i <= mid; i++) {
            result += dp(N-i, i+1);
        }
        return result+1;
    }
    int dp(int N, int start) {
        if (start == N)
            return 1;
        if (start > N/2)
            return 0;
        String key = N + " " + start;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        int result = dp(N-start, start+1);
        map.put(key, result);
        return result;
    }
}