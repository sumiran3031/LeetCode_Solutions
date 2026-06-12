public class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {0, 1, 0, 3, 12};
        sol.moveZeroes(nums1);
        System.out.print("Output 1: ");
        for (int x : nums1) System.out.print(x + " "); // 1 3 12 0 0

        System.out.println();

        int[] nums2 = {0};
        sol.moveZeroes(nums2);
        System.out.print("Output 2: ");
        for (int x : nums2) System.out.print(x + " "); // 0
    }
}