class Pair{
    int freq;
    char ch;
    Pair(int freq, char ch){
        this.freq = freq;
        this.ch = ch;
    }
}
class Solution {
    public String frequencySort(String s) {
        Pair[] pair = new Pair[128];

        for(int i=0; i<128; i++){
            pair[i] = new Pair(0, (char)i);
        }

        for(int i=0; i<s.length(); i++){
            int pos = (int)s.charAt(i);
            pair[pos].freq++;
        }

        Arrays.sort(pair, (a,b) -> Integer.compare(b.freq, a.freq));

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<128; i++){
            if(pair[i].freq == 0) break;
            sb.append(String.valueOf(pair[i].ch).repeat(pair[i].freq));
        }
        return sb.toString();
    }
}