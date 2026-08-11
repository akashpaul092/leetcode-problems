class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        if(s == null || s.length() == 0 || words.length == 0) return list;
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(String word: words) map.put(word, map.getOrDefault(word, 0)+1);
        int wordLength = words[0].length();
        for(int i=0; i< wordLength; i++){
            Map<String, Integer> innerMap = new HashMap<>();
            int left = i;
            int count = 0;
            for(int right = i; right<= s.length() - wordLength; right = right + wordLength){
                String substring = s.substring(right, right + wordLength);
                if(map.containsKey(substring)){
                    innerMap.put(substring, innerMap.getOrDefault(substring, 0) + 1);
                    count++;

                    while(innerMap.get(substring) > map.get(substring)){
                        String leftWord = s.substring(left, left + wordLength);
                        innerMap.put(leftWord, innerMap.get(leftWord) - 1);
                        left += wordLength;
                        count--;
                    }
                    
                }else{
                    innerMap.clear();
                    count = 0;
                    left = right + wordLength;
                }
                if(count == words.length) list.add(left);
            }
        }
        return list;
    }
}