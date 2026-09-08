class Solution {
    public boolean canJump(int[] nums) {
        int index = 0;
        for(int num : nums){
            index += num;
            if(index >= nums.length){
                return false;
            }
        }
        return true;
    }
}
