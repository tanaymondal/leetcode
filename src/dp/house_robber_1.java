package dp;

import java.util.Arrays;

public class house_robber_1 {
    static int[] nums = {1, 2, 3, 1, 5};
    static int[] dp = new int[nums.length];

    public static void main(String[] args) {
        System.out.println(rob());
    }

    static int rob() {
        if (nums.length == 1) {
            return nums[0];
        }
        Arrays.fill(dp, -1);
        return maxMoney(nums, 0, dp);
    }

    static int maxMoney(int[] nums, int i, int[] dp) {
        if (i >= nums.length) {
            return 0;
        } else if (dp[i] != -1) {
            return dp[i];
        } else {
            dp[i] = Math.max(nums[i] + maxMoney(nums, i + 2, dp), maxMoney(nums, i + 1, dp));
            return dp[i];
        }
    }
}
