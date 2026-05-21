class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        int maxLen = 0;

        for(int num: nums){
            numSet.add(num);
        }

        for(int n: numSet){
            if(numSet.contains(n - 1)) continue;

            int len = 1;
            int next = n + 1;
            while(numSet.contains(next++)){
                len++;
            }

            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }
}
/*
[2, 20, 4, 10, 3, 5]
len = 
maxlen = 4
*/
