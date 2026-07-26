class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int right = -1;
        int max = nums[0];
        for(int i=1; i<nums.length; i++){
            if(nums[i] >= max){
                max = nums[i];
            }else{
                right = i;
            }
        }

        if(right == -1) return 0;

        int left = - 1;
        int min = nums[nums.length - 1];
        for(int i=nums.length - 2; i>=0; i--){
            if(nums[i] <= min){
                min = nums[i];
            }else{
                left = i;
            }
        }
        return right - left + 1;
    }
}