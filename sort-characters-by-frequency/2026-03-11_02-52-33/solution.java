class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        Map<Integer,List<Character>> map2 = new HashMap<>();
        for(Map.Entry<Character, Integer> m: map.entrySet()){
            if(!map2.containsKey(m.getValue())) map2.put(m.getValue(), new ArrayList<>());
            map2.get(m.getValue()).add(m.getKey());
        }

        StringBuilder str = new StringBuilder();
        for(int i = s.length(); i>= 1 ; i--){
            if(map2.containsKey(i)){
                for(char ch: map2.get(i)){
                    str.append(String.valueOf(ch).repeat(i));
                }
            }
        }
        return str.toString();
    }
}