class Solution {
    public int rob(int[] nums) {
        return Math.max(nums[0],
                Math.max(helper(Arrays.copyOfRange(nums, 1, nums.length)),
                         helper(Arrays.copyOfRange(nums, 0, nums.length - 1))));
    }

    private int helper(int[] nums){
        int first = 0, second = 0;

        for(int num : nums){
            int third = Math.max(first + num, second);
            first = second;
            second = third;
        }

        return second;
    }
}
