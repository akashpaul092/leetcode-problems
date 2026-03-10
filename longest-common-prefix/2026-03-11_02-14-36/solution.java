class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1) return strs[0];
        int min = Integer.MAX_VALUE;
        for(String str: strs){
            min = Math.min(min, str.length());
        } 
        for(int i=0; i<min; i++){
            char ch = strs[0].charAt(i);
            for(int j=1; j<strs.length; j++){
                if(ch != strs[j].charAt(i)){
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0].substring(0, min);
    }
}