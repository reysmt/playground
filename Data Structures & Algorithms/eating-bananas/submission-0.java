class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int sum = 0;
        double result = 0;
        int maxPile = 0;
        for(int pile : piles){
            sum += pile;
            maxPile = Math.max(maxPile, pile);
        }
        result = Math.ceil((double)sum / (double)h);
        if(h == piles.length){
            return maxPile;
        }
        return (int)result;
    }
}
