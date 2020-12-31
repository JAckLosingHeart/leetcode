class Solution {
    // 虽然很简单，但不是每个人一开始就能想到的
    public int[] twoSum(int[] numbers, int target) {
        int length = numbers.length;
        int low = 0;
        int high = length - 1;
        while (low < high) {
            if (numbers[low] + numbers[high] == target) {
                break;
            }
            if (numbers[low] + numbers[high] > target) {
                high--;
            } else {
                low++;
            }
        }
        return new int[]{low+1, high+1};
    }
}