class Solution {
    public boolean isPalindrome(String s) {
        String ss = s.replaceAll("[^a-zA-Z0-9]", "");
        for(int i = 0; i < ss.length()/2; i++){
            if(Character.toLowerCase(ss.charAt(i)) 
                != Character.toLowerCase(ss.charAt(ss.length() - i - 1))){
                return false;
            }
        }
        return true;
    }
}
