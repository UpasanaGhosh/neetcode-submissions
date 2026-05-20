class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {  
      List<List<String>> res = new ArrayList<>();  

      if(strs == null || strs.length == 0) return res;

      Map<String, List<String>> genStoStrMap = new HashMap<>();

      for(String s: strs){
        char[] sArr = s.toCharArray();
        Arrays.sort(sArr);
        String genS = new String(sArr);

        genStoStrMap.putIfAbsent(genS, new ArrayList<>());
        genStoStrMap.get(genS).add(s);
      }

      for(String key: genStoStrMap.keySet()){
        res.add(genStoStrMap.get(key));
      }

      return res;
    }
}
