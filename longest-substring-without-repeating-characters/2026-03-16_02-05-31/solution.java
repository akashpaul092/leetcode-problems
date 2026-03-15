class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n <= 1) return n;
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int res = 0;
        for(int j=0; j<n; j++){
            char ch = s.charAt(j);
            if(map.containsKey(ch)){
                i = Math.max(i, map.get(ch) + 1);
            }
            map.put(ch, j);
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}