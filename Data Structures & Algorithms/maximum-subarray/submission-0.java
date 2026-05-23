class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE, sum = 0;

        for(int n: nums){
            sum = Math.max(n, sum + n);
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}
/*
TC: O(n), SC: O(1)
*/
