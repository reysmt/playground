class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, n, 0, 0, new StringBuilder());
        return res;
    }

    private void backtrack(List<String> res, int n, int close, int open, StringBuilder ch){
        if(ch.toString().length() == n*2){
            res.add(ch.toString());
            return;
        }


        if(open < n){
            ch.append("(");
            backtrack(res, n, close, open + 1, ch);
            ch.deleteCharAt(ch.length() - 1);
        }
 
        if(close < open){
            ch.append(")");
            backtrack(res, n, close + 1, open, ch);
            ch.deleteCharAt(ch.length() - 1);
        }
        
    }
}
