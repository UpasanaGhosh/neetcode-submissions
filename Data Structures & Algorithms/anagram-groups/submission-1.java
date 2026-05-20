class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {  
      Map<String, List<String>> genStoStrMap = new HashMap<>();

      for(String s: strs){
        char[] sArr = s.toCharArray();
        Arrays.sort(sArr);
        String genS = new String(sArr);

        genStoStrMap.putIfAbsent(genS, new ArrayList<>());
        genStoStrMap.get(genS).add(s);
      }

      return new ArrayList<>(genStoStrMap.values());
    }
}
