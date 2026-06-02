class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for (String text : strs){
            int[] count = new int[26];
            for(char c : text.toCharArray()){
                count[c - 'a'] ++;
            }
            String key = Arrays.toString(count);
            res.putIfAbsent(key, new ArrayList<>());
            res.get(key).add(text);
        }
        return new ArrayList<>(res.values());
    }
}
