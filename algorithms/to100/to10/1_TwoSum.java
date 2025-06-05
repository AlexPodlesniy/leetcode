package to100.to10;

import java.util.HashMap;
import java.util.Map;

class TwoSum {

    public static void main (String[] args) {
        System.out.println("Start testing");

        Solution solution = new Solution();
        int[] result = solution.twoSum(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}, 16);

        System.out.println("result: [" + result[0] + ", " + result[1] + "]");
    }

    public static class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> valuesWithIndexes = new HashMap<>(nums.length - 1);
            for (int i = 0; i < nums.length; i++) {
                int expectedPair = target - nums[i];
                Integer pairIndex = valuesWithIndexes.get(expectedPair);
                if (pairIndex != null) {
                    return new int[] {pairIndex, i};
                } else {
                    valuesWithIndexes.put(nums[i], i);
                }
            }
            throw new IllegalArgumentException("There is no pair of int that sums to given target");
        }
    }
}