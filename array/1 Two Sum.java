import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            numsMap.put(nums[i], i);
        }
        for (int i = 0; i < length; i++) {
            int complement = target - nums[i];
            // 那个complement不能是同一个元素
            if (numsMap.containsKey(complement) && numsMap.get(complement) != i)
                return new int[]{i, numsMap.get(complement)};
        }
        return null;
    }
}