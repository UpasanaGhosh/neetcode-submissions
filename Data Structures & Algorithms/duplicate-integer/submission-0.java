class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> uniqueNums = new HashSet<>();

        for(int n: nums){
            if(!uniqueNums.add(n)){
                return true;
            }
        }

        return false;
    }
}