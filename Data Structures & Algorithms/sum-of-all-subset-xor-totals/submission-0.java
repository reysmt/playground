class Solution {
    public int subsetXORSum(int[] nums) {
        return dfs(nums, 0, 0);
    }

    private int dfs(int[] nums, int index, int total){
        if(index == nums.length){
            return total;
        }
        return dfs(nums, index + 1, total ^ nums[index]) + dfs(nums, index + 1, total);
    }
}