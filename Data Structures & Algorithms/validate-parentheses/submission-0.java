class Solution {
    public boolean isValid(String s) {
        Deque<Character> stk = new ArrayDeque<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');

        for(char c: s.toCharArray()){
            if(map.containsKey(c)){
                stk.push(c);
            }
            else if(!stk.isEmpty() && c == map.get(stk.peek())){
                stk.pop();
            }
            else{
                return false;
            }
        }

        return stk.isEmpty();
    }
}
