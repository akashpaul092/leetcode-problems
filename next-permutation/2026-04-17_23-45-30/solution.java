class Solution {
    public void nextPermutation(int[] nums) {
        int breakpoint = -1;
        for(int i = nums.length - 1; i>0; i--){
            if(nums[i-1] < nums[i]){
                breakpoint = i-1;
                break;
            }
        }
        if(breakpoint >= 0){
            for(int i = nums.length - 1; i>breakpoint; i--){
                if(nums[i] > nums[breakpoint]){
                    int temp = nums[i];
                    nums[i] = nums[breakpoint];
                    nums[breakpoint] = temp;
                    break;
                }
            }
        }

        int left = breakpoint + 1;
        int right = nums.length - 1;
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}