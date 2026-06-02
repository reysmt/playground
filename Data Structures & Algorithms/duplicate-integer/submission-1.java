class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for(int i=0; i <= nums.length - 1; i++){
            if(seen.contains(nums[i])){
                return true;
            }else{
                seen.add(nums[i]);
            }
        }
        return false;
    }
}