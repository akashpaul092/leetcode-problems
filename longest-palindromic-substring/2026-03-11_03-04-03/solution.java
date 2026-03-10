class Solution {
    private String findPalindrom(int left, int right, String s){
        while(left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
    public String longestPalindrome(String s) {
        if(s.length() <= 1) return s;
        String ans = "";
        for(int i=1; i<s.length(); i++){
            String even = findPalindrom(i-1,i,s);
            String odd = findPalindrom(i,i,s);

            if(ans.length() < even.length()) ans = even;
            if(ans.length() < odd.length()) ans = odd;
        }
        return ans;
    }
}