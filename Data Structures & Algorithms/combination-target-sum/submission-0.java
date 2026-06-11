class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        backtrack(new ArrayList<Integer>(), 0, nums, target);
        return res;
    }

    public void backtrack(List<Integer> combo, int idx, int[] nums, int target){
        // 1. exit condition: add combo if target is achieved
        if(target == 0){
            res.add(new ArrayList<>(combo));
            return;
        }

        // 2. exit if combo sum > target or idx is more than nums length
        if(target < 0 || idx >= nums.length){
            return;
        }

        // 3. Option 1: Include the current num and find a combination
        combo.add(nums[idx]);
        backtrack(combo, idx, nums, target - nums[idx]);

        // 4. Option 2: Skip the current num and move onto next index
        combo.remove(combo.size() - 1);
        backtrack(combo, idx + 1, nums, target);
    }
}
