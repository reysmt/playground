class Solution {
    public int maxArea(int[] heights) {
        int l = 0, r = 1;
        boolean found = false;
        int res = 0;
        while (l != r) {
            if (r < heights.length - 1){
                r++;
            }else{
                l++;
            }
            int calc = (r-l) * Math.min(heights[l], heights[r]);
            res = Math.max(res, calc);
        }
        return res;
    }
}
