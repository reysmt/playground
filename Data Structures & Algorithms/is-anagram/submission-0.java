class Solution {
    public boolean isAnagram(String s, String t) {
        boolean isAnagram = false;
        if(s.isEmpty() || t.isEmpty()){
            return isAnagram;
        }
        if(s.length() != t.length()){
            return isAnagram;
        }
        HashSet<Character> seen = new HashSet<Character>();
        for(int i = 0; i < s.length(); i++){
            seen.add(s.charAt(i));
        }
        for(int i = 0; i < t.length(); i++){
            if(seen.contains(t.charAt(i))){
                isAnagram = true;
            }else{
                isAnagram = false;
            }
        }
        return isAnagram;
    }
}
