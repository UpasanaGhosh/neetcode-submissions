class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0) return false;

        s = s.toLowerCase().replaceAll("[^0-9a-z]", "");
        int i=0, j = s.length() - 1;

        while(i <= j){
            if(s.charAt(i++) != s.charAt(j--)){
                return false;
            }
        }

        return true;
    }
}
