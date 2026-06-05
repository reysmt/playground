class Solution {
    public int maxProfit(int[] prices) {
        int l = 0, r = prices.length - 1;
        int res = 0;
        while (l < r){
            if(prices[r] - prices[l] > 0){
                res = Math.max(res, prices[r] - prices[l]);
            }
            if(prices[l] > prices[r]){
                l++;
            }else {
                r--;
            }
        }
        return res;
    }
}
