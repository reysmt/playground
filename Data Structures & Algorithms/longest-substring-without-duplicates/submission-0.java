class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<Character>();
        int l=0, r=1, result = 0;
        while(r < s.length()){
            if(seen.contains(s.charAt(r))){
                l=r-1;
            }
            seen.add(s.charAt(r));
            result = Math.max(result, r - l);
            r++;
        }
        return result;
    }
}
