import java.util.HashMap;
import java.util.Map;

class Solution {
    // 自顶向下的动态规划同样存储信息
    Map<String, Integer> minDic = new HashMap<>();

    public int minDifficulty(int[] jobDifficulty, int d) {
        // 防止此函数被多次调用时还存有上次的记录
        minDic.clear();
        int length = jobDifficulty.length;
        if (length < d)
            return -1;
        return recursiveMin(jobDifficulty, d, 0, length - 1);
    }

    private int recursiveMin(int[] jobDifficulty, int d, int left, int right) {
        String key = left + " " + right + " " + d;
        // 动态规划向来是先查字典
        if (minDic.containsKey(key)) {
            return minDic.get(key);
        }
        int result;
        // d == 1的情况比较特殊，是要取数组里的最大值
        if (d == 1) {
            result = Integer.MIN_VALUE;
            for (int i = left; i <= right; i++) {
                if (jobDifficulty[i] > result)
                    result = jobDifficulty[i];
            }
        } else {
            result = Integer.MAX_VALUE;
            for (int i = left; i <= right + 1 - d; i++) {
                int sum = recursiveMin(jobDifficulty, 1, left, i)
                        + recursiveMin(jobDifficulty, d - 1, i + 1, right);
                if (sum < result) {
                    result = sum;
                }
            }
        }
        // 保存求出的结果
        minDic.put(key, result);
        return result;
    }
}