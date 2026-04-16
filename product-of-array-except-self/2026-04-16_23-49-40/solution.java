class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        if(n == 0) return ans;
        int prefix = 1;
        for(int i=0; i< n; i++){
            ans[i] = prefix;
            prefix *= nums[i];
        }
        int sufix = 1;
        for(int i=n-1; i>=0; i--){
            ans[i] *= sufix;
            sufix *= nums[i];
        }
        return ans;
    }
}