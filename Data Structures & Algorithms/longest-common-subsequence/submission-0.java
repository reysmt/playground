class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        return dfs(text1, text2, 0, 0);
    }

    private int dfs(String text1, String text2, int i, int j){
        int result;

        if(j >= text2.length()|| i >= text1.length()){
            return 0;
        }

        if(text1.charAt(i) == text2.charAt(j)){
            result = 1 + dfs(text1, text2, i + 1, j + 1);
        }else {
            result = Math.max(dfs(text1, text2, i + 1, j), dfs(text1, text2, i, j + 1));
        }

        return result;
    }
}
