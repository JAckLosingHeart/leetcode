import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    int splitSausage(int k) {
        map.clear();
        return dp(k);
    }
    int dp(int k) {
        if (k < 2)
            return 0;
        if (k < 4)
            return 1;
        if (map.containsKey(k))
            return map.get(k);
        int result = 1;
        for (int i = 2; i <= k-2; i++) {
            result += dp(k-i);
        }
        map.put(k, result);
        return result;
    }
    public static void main (String args[]) {
        System.out.println(new Solution().dp(6));
    }
}