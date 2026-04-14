class Solution {
    public int kthFactor(int n, int k) {
        int i = n;
        int output = -1;
        while(i > 0){
            if(k == 0) break;
            if(n%i == 0){
                output = n/i;
                k--;
            }
            i--;
        }
        if(k == 0) return output;
        return -1;
    }
}