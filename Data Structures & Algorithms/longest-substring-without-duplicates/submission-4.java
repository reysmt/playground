class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> seen = new HashMap<Character, Integer>();
        int l=0, result = 0;
        for(int r = 0; r < s.length(); r++){
            if(seen.containsKey(s.charAt(r))){
                l = Math.max(seen.get(s.charAt(r)) + 1, l);
            }
            seen.put(s.charAt(r), r);
            result = Math.max(result, r-l + 1);
        }
        return result;
    }
}
