class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        for(int i=1; i < nums.length; i++){
            left[i] = nums[i - 1] * left[i - 1];
        }

        for(int i=nums.length - 2; i >= 0; i--){
            right[i] = nums[i + 1] * right[i + 1];
        }

        for(int i=0; i < nums.length; i++){
            left[i] *= right[i];
        }

        return left;
    }
} 
/*
[1, 1, 2, 8]
[48, 24, 6, 1]

[48, 24, 12, 8]
*/ 
