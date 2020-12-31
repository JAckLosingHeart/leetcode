import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        // nums[i]一旦大于零就没可能有新的组合了
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            // 跳过重复的元素
            if (i == 0 || nums[i - 1] != nums[i]) {
                findTriplets(result, nums, i);
            }
        }
        return result;
    }

    private void findTriplets(List<List<Integer>> result, int[] nums, int i) {
        int low = i + 1;
        int high = nums.length - 1;
        int target = -nums[i];
        while (low < high) {
            if (nums[low] + nums[high] < target) {
                low++;
            } else if (nums[low] + nums[high] > target) {
                high--;
            } else {
                // Arrays.asList可以直接将一组数字转化为list
                result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                low++;
                // 跳过重复的
                while (nums[low] == nums[low - 1] && low < high) { low++; }
            }
        }
    }
}