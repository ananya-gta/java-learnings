package dsa;
// https://leetcode.com/problems/maximum-ascending-subarray-sum

public class L1800 {

    static int maxAscendingSum(int[] nums) {
        int maxSum = 0;
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1])
                sum += nums[i];
            else {
                maxSum = Math.max(sum, maxSum);
                sum = nums[i];
            }
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = { 10, 20, 30, 5, 10, 50 };
        int[] nums1 = { 100, 10, 1 };
        System.out.println(maxAscendingSum(nums));
        System.out.println(maxAscendingSum(nums1));
    }

}
