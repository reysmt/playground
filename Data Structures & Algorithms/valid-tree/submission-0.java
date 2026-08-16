class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length == n - 1){
            return true;
        }else if(edges.length >= n){
            return false;
        }
        return false;
    }
}
