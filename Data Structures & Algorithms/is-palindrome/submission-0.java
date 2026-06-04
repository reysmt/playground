class Solution {
    public boolean isPalindrome(String s) {
        String saniizedText = s.replaceAll("[^a-zA-Z0-9]", "");
        for(int i = 0; i < saniizedText.length()/2; i++){
            if(saniizedText.charAt(i) != saniizedText.charAt(saniizedText.length() - i - 1)){
                if(saniizedText.charAt(i) + 32 == saniizedText.charAt(saniizedText.length() - i - 1)
                    || saniizedText.charAt(i) - 32 == saniizedText.charAt(saniizedText.length() - i - 1)
                    || saniizedText.charAt(i) == saniizedText.charAt(saniizedText.length() - i - 1) + 32
                    || saniizedText.charAt(i) == saniizedText.charAt(saniizedText.length() - i - 1) - 32){
                    continue;
                }
                return false;
            }
        }
        return true;
    }
}
