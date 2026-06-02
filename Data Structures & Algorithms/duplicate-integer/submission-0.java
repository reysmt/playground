class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Integer> seen = new HashMap<>();
        for(int i=0; i <= nums.length - 1; i++){
            if(seen.containsKey(nums[i])){
                return true;
            }else{
                seen.put(nums[i], i);
            }
        }
        return false;
    }
}