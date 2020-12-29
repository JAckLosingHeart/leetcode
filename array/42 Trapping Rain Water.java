// 非常干净漂亮的解法， 以最高点为界限，从左右两边逼近
class Solution {
    public int trap(int[] height) {
        int length = height.length;
        if (length < 3)
            return 0;
        int maxIndex = 0;
        for (int i = 1; i < length; i++) {
            if (height[i] > height[maxIndex])
                maxIndex = i;
        }
        int leftMaxIndex = 0;
        int leftResult = 0;
        for (int i = 1; i <= maxIndex; i++) {
            if (height[i] >= height[leftMaxIndex]) {
                for (int j = leftMaxIndex+1; j < i; j++) {
                    leftResult += (height[leftMaxIndex] - height[j]);
                }
                leftMaxIndex = i;
            }
        }
        int rightMaxIndex = length - 1;
        int rightResult = 0;
        for (int i = length - 2; i >= maxIndex; i--) {
            if (height[i] >= height[rightMaxIndex]) {
                for (int j = rightMaxIndex - 1; j > i; j--) {
                    rightResult += (height[rightMaxIndex] - height[j]);
                }
                rightMaxIndex = i;
            }
        }
        return (leftResult + rightResult);
    }
}