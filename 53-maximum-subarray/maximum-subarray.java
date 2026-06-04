class Solution {
    public int maxSubArray(int[] nums) {
        int maxsoFar = nums[0];
        int currentMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            maxsoFar = Math.max(maxsoFar, currentMax);
        }
        return maxsoFar;
    }
}
