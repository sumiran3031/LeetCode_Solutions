class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] vals = new int[n + 2];
        vals[0] = 1;
        vals[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            vals[i + 1] = nums[i];
        }

        int[][] dp = new int[n + 2][n + 2];

        for (int length = 1; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length + 1;
                for (int k = i + 1; k < j; k++) {
                    int coins = vals[i] * vals[k] * vals[j];
                    int total = coins + dp[i][k] + dp[k][j];
                    if (total > dp[i][j]) {
                        dp[i][j] = total;
                    }
                }
            }
        }

        return dp[0][n + 1];
    }
}
