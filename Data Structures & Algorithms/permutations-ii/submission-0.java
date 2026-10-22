class Solution {
    Set<List<Integer>> res = new HashSet<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> perm = new ArrayList<>();
        backtrack(nums, perm);
        return new ArrayList<>(res);
    }

    public void backtrack(int[] nums,  List<Integer> curr){
        if(curr.size() == nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i] != Integer.MIN_VALUE){
                int temp = nums[i];
                curr.add(nums[i]);
                nums[i] = Integer.MIN_VALUE;
                backtrack(nums, curr);
                nums[i] = temp;
                curr.remove(curr.size() - 1);
            }
        }
    }
}