class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subres = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, subres, res);
        return new ArrayList<>(res);
    }

    private void backtrack(int[] nums, int i, List<Integer> subres, List<List<Integer>> res){
        res.add(new ArrayList<>(subres));
        for(int j = i; j < nums.length; j++){
            if(j > i && nums[j] == nums[j - 1]){
                continue;
            }
            subres.add(nums[j]);
            backtrack(nums, j + 1, subres, res);
            subres.remove(subres.size() - 1);
        }
    }
}
