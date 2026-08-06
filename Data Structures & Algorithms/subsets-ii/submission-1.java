class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subres = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, subres, res);
        return new ArrayList<>(res);
    }

    private void backtrack(int[] nums, int i, List<Integer> subres, List<List<Integer>> res){
        if(i == nums.length){
            res.add(new ArrayList<>(subres));
            return;
        }
        subres.add(nums[i]);
        backtrack(nums, i + 1, subres, res);
        subres.remove(subres.size() - 1);
        
        while(i + 1 < nums.length && nums[i] == nums[i + 1]){
            i++;
        }

        backtrack(nums, i + 1, subres, res);
    }
}
