/**
 * 这题也tm太机智了，给n-1个数加1，就是只给剩下那个数减1
 */
class Solution {
    public int minMoves(int[] nums) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            min = Math.min(min, nums[i]);
        }
        return sum - min * nums.length;
    }
}