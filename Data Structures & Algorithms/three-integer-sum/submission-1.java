class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int target = -nums[i], l = i + 1, r = nums.length - 1;

            while(l < r){
                if(nums[l] + nums[r] == target){
                    triplets.add(Arrays.asList(nums[i], nums[l++], nums[r--]));
                    while(l < r && nums[l] == nums[l-1]) l++;
                    while(r > l && nums[r] == nums[r+1]) r--;
                }
                else if(nums[l] + nums[r] < target){
                    l++;
                }
                else{
                    r--;
                }
            }
        }
        return triplets;
    }
}
