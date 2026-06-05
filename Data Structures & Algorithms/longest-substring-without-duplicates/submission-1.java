class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0, r=0, maxlen=0;
        Set<Character> set = new HashSet<>();

        while(r < s.length()){
            while(!set.isEmpty() && set.contains(s.charAt(r))){
                set.remove(s.charAt(l++));
            }
            set.add(s.charAt(r++));
            maxlen = Math.max(maxlen, set.size());
        }
        return maxlen;
    }
}
/*
while j < s.length():
    set = x,y,z
    i = 1, j = 4
    maxlen = 3
*/
