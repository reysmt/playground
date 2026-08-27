class Solution {
    public int rob(int[] nums) {
        int first = 0, second = 0;

        for(int num : nums){
            int third = Math.max(num + first, second);
            first = second;
            second = third;
        }

        return second;
    }
}
