class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= suffix;
            suffix *= nums[i];
        }

        return answer;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = {1, 2, 3, 4};
        int[] result1 = sol.productExceptSelf(nums1);
        System.out.print("Output 1: ");
        for (int x : result1) System.out.print(x + " ");
        System.out.println();
        int[] nums2 = {-1, 1, 0, -3, 3};
        int[] result2 = sol.productExceptSelf(nums2);
        System.out.print("Output 2: ");
        for (int x : result2) System.out.print(x + " ");
    }
}