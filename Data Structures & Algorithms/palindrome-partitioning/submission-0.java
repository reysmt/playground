class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> subres = new ArrayList<>();
        process(s,res, subres,0);
        return res;
    }

    private void process(String s, List<List<String>> res, List<String> subres, int i){
        if(i>=s.length()){
            res.add(new ArrayList<>(subres));
            return;
        }

        for(int j = i; j < s.length(); j++){
            if(isPalindrome(s, i, j)){
                subres.add(s.substring(i, j + 1));
                process(s, res, subres, j+1);
                subres.remove(subres.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right){
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left ++;
            right --;
        }
        return true;
    }
}
