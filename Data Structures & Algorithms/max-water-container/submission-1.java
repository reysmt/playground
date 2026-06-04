class Solution {
    public int maxArea(int[] heights) {
        int l = 0, r = heights.length -1;
        boolean found = false;
        int res = 0;
        while (l < r) {
            int calc = (r-l) * Math.min(heights[l], heights[r]);
            res = Math.max(res, calc);
            if (heights[l] <= heights[r]){
                l++;
            }else{
                r--;
            }
        }
        return res;
    }
}
