class Solution {
    public long countPrefixSuffixPairs(String[] words) {
        int total = 1;

        for(String word : words) total *= word.length();
        
        HashMap<Long, Integer> children = new HashMap<>(total * 2);
        int[] endCount = new int[total];

        int nodes = 1;
        long res = 0;

        for (String w : words) {
            int n = w.length();
            int node = 0;

            for (int i = 0; i < n; i++) {

                int pair = (w.charAt(i) - 'a') * 26 + (w.charAt(n - 1 - i) - 'a');
                long key = node * 675L + pair;

                Integer child = children.get(key);
                if(child == null){
                    child = nodes++;
                    children.put(key, child);
                }
                node = child;

                res += endCount[node];
            }

            endCount[node]++;
        }
        return res;
    }
}
