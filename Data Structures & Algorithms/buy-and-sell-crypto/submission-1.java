class Solution {
    public int maxProfit(int[] prices) {
        int l = 0, r = prices.length - 1;
        int res = 0;
        int maxRight = 0;
        while (l < r){
            maxRight = Math.max(maxRight,prices[r]);
            if(maxRight - prices[l] > 0){
                res = Math.max(res, maxRight - prices[l]);
            }
            if(prices[l] > prices[r]){
                l++;
            }else{
                r--;
            }
        }
        return res;
    }
}
