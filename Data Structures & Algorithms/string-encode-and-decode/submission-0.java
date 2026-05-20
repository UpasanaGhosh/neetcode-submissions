class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s: strs){
            s = s.replace("/", "//");
            sb.append(s);
            sb.append("/:");
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> strs = new ArrayList<>();
        if(str == null || str.length() == 0) return strs;

        int i=0;
        StringBuilder sb = new StringBuilder();
        while(i < str.length()){
            if(str.charAt(i) == '/' 
            && i + 1 < str.length() && str.charAt(i + 1) == '/'){
                sb.append(str.charAt(i));
                i+=2;
            }
            else if(str.charAt(i) == '/' 
            && i + 1 < str.length() && str.charAt(i + 1) == ':'){
                strs.add(sb.toString());
                sb = new StringBuilder();
                i+=2;
            }
            else{
                sb.append(str.charAt(i++));
            }
        }

        return strs;
    }
}
