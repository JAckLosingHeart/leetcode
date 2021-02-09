import java.util.List;
import java.util.Map;
/**
 * 在所有的binary search中，常常使用left和right之间的闭区间作为可能存在答案的区间,
 * 即答案只可能出现在[left,right]之间，如果在长度为1的时候都不是答案，那么也就没有答案
 * 然后在所有的binary search中，也要保证最终区间能收敛到left==right或者甚至left>right，这些将作为我们结束循环的条件
 */

/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */
interface BinaryMatrix {
    public int get(int row, int col);
    public List<Integer> dimensions();
};

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int leftMost = Integer.MAX_VALUE;
        List<Integer> dimensions = binaryMatrix.dimensions();
        int rows = dimensions.get(0);
        int cols = dimensions.get(1);
        for (int i = 0; i < rows; i++) {
            int left = 0;
            int right = cols - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                int midInt = binaryMatrix.get(i, mid);
                if (midInt == 0) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (binaryMatrix.get(i, left) == 1) {
                leftMost = Math.min(leftMost, left);
            }
        }
        return leftMost < Integer.MAX_VALUE ? leftMost : -1;
    }
}