class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i< t.length(); i++){
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int length = Integer.MAX_VALUE;
        int count = 0;
        int startIndex = 0;
        while(right < s.length()){
            char ch = s.charAt(right);
            if(map.containsKey(ch) && map.get(ch) > 0){
                count++;
            }
            map.put(ch, map.getOrDefault(ch, 0) - 1);
            while(count == t.length()){
                char innerCh = s.charAt(left);
                map.put(innerCh, map.getOrDefault(innerCh, 0) + 1);

                if(map.get(innerCh) > 0){
                    count--;
                    if(length > right - left + 1){
                        length = right - left + 1;
                        startIndex = left;
                    }
                }
                left++;
            }
            right++;
        }
        return length == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + length);
    }
}