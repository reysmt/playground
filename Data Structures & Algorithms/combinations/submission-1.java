class Solution {
    public List<List<Integer>> combine(int n, int k) {
        Deque<State> stack = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        stack.push(new State(1, new ArrayList<>()));

        while (!stack.isEmpty()) {
            State curr = stack.pop();
            int index = curr.index;
            List<Integer> subres = curr.subres;

            if (index > n) {
                if (subres.size() == k) {
                    res.add(subres);
                }
                continue;
            }

            stack.push(new State(index + 1, new ArrayList<>(subres)));
            
            List<Integer> withIndex = new ArrayList<>(subres);
            withIndex.add(index);
            stack.push(new State(index + 1, withIndex));
        }

        return res;
    }

    private static class State {
        final int index;
        final List<Integer> subres;

        State(int index, List<Integer> subres) {
            this.index = index;
            this.subres = subres;
        }
    }
}