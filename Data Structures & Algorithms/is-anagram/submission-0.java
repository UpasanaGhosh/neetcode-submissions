class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        HashMap<Character, Integer> freqMap = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            if(!freqMap.containsKey(c)){
               return false; 
            }

            freqMap.put(c, freqMap.get(c) - 1);
        }

        for(char c: freqMap.keySet()){
            if(freqMap.get(c) != 0) return false;
        }

        return true;
    }
}
