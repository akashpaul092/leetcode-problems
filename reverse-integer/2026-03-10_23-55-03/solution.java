class Solution {
    public int reverse(int x) {
        int a = x;
        int ans = 0;
        while(a != 0){
            if((ans > Integer.MAX_VALUE/10) || (ans < Integer.MIN_VALUE/10)){
                return 0;
            }else if((ans == Integer.MAX_VALUE/10) || (ans == Integer.MIN_VALUE/10)){
                if(a%10 > Integer.MAX_VALUE%10 || a%10 < Integer.MIN_VALUE%10) return 0;
            }
            ans = (ans*10) + (a%10);
            a /= 10;
        }
        return ans;
    }
}