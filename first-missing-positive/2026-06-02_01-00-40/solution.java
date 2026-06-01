class Solution {
    public int firstMissingPositive(int[] nums) {
        int max = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
            max = Math.max(num, max);
        }
        for(int i=1; i<=max; i++){
            if(!set.contains(i)) return i;
        }
        return max < 0 ? 1 : max + 1;
    }
}