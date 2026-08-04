class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res.clear();
        Arrays.sort(candidates);
        dfs(0, new ArrayList<>(), 0, candidates, target);
        return res;
    }

    private void dfs(int i, List<Integer> cur, int total, int[] candidates, int target){
        if(total == target){
            res.add(new ArrayList<>(cur));
            return;
        }

        for(int j = i; j < candidates.length; j++){
            if(j > i && candidates[j] == candidates[j - 1]){
                continue;
            }
            if(total + candidates[j] > target){
                break;
            }
            cur.add(candidates[j]);
            dfs(j + 1, cur, total + candidates[j], candidates, target);
            cur.remove(cur.size() - 1);
        }
    }
}
