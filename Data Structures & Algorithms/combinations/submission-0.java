class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subres = new ArrayList<>();
        dfs(n, k, subres, 1, res);
        return res;
    }

    private void dfs(
        int number, int combination, List<Integer> subres, int index, List<List<Integer>> res) {
        if (index > number) {
            if (subres.size() == combination) {
                res.add(new ArrayList<>(subres));
            }
            return;
        }

        subres.add(index);
        dfs(number, combination, subres, index + 1, res);
        subres.remove(subres.size() - 1);
        dfs(number, combination, subres, index + 1, res);
    }
}