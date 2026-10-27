class Solution {
    public int appendCharacters(String s, String t) {
        int res = 0;
        int s1 = 0;
        int s2 = 0;

        while(s1 < s.length() && s2 < t.length()){
            if(s.charAt(s1) == t.charAt(s2)){
                s1++;
                s2++;
            }else{
                s1++;
            }

            res = t.substring(s2, t.length()).length();
        }

        return res;
    }
}