import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int maximalSquare(char[][] matrix) {
        //用一个字符串来表示一个正方形的id —— i j len， 把所有全是1的正方形
        //放到下面这个set里
        Set<String> set = new HashSet<>();
        int width = matrix.length;
        int length = matrix[0].length;
        int maxLen = Math.min(width, length);
        int result = 0;
        //把边长1的先看一遍有没有是1的
        for (int i = 0; i < width; i++)
            for (int j = 0; j < length; j++) {
                if (matrix[i][j] == '1')
                    result = 1;
            }
        for (int len = 2; len <= maxLen; len++) {
            //上一个边长如果没有满足要求的，说明后面的都没有了，直接提前退出即可
            if (result != (len - 1) * (len - 1))
                return result;
            for (int i = 0; i < width + 1 - len; i++) {
                for (int j = 0; j < length + 1 - len; j++) {
                    //边长为2的特殊处理，因为边长为1的都不在set里
                    if (len == 2) {
                        if (matrix[i][j] == '1' && matrix[i][j + 1] == '1'
                                && matrix[i + 1][j] == '1' && matrix[i + 1][j + 1] == '1') {
                            result = 4;
                            set.add(i + " " + j + " " + "2");
                        }
                        continue;
                    }
                    if (set.contains(i + " " + j + " " + (len - 1))
                            && set.contains(i + " " + (j + 1) + " " + (len - 1))
                            && set.contains((i + 1) + " " + j + " " + (len - 1))
                            && set.contains((i + 1) + " " + (j + 1) + " " + (len - 1))) {
                        result = len * len;
                        set.add(i + " " + j + " " + len);
                    }
                }
            }
        }
        return result;
    }
}