class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numIdxMap = new HashMap<>();

        for(int i=0; i < nums.length; i++){
            if(numIdxMap.containsKey(target - nums[i])){
                return new int[]{numIdxMap.get(target - nums[i]), i};
            }
            numIdxMap.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
