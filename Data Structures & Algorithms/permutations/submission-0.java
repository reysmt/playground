class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subres = new ArrayList<>();
        backtrack(res, nums, subres, new boolean[nums.length]);
        return res;
    }

    private void backtrack(List<List<Integer>> res, int[] nums, List<Integer> subres, boolean[] pick){
        if(subres.size() == nums.length){
            res.add(new ArrayList<>(subres));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(!pick[i]){
                subres.add(nums[i]);
                pick[i] = true;
                backtrack(res, nums, subres, pick);
                subres.remove(subres.size() - 1);
                pick[i] = false;
            }
        }
    }
}
