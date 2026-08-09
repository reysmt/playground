class Solution {
    private String[] digitToChar = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"
    };
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) return res;
        process(0, "", digits);
        return res;
    }

    private void process(int i, String curStr, String digits){
        if(curStr.length() == digits.length()){
            res.add(curStr);
            return;
        }
        String chars = digitToChar[digits.charAt(i) - '0'];
        for(char c : chars.toCharArray()){
            process(i + 1, curStr + c, digits);
        }
    }
}
