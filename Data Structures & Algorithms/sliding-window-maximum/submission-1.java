class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int l = 0;
        ArrayList<Integer> results = new ArrayList<>();
        for(int r = k - 1; r < nums.length; r++) {
            l = r - (k - 1);
            //window that starts from left to right

            //while or for that check all nums inside the window
            //store the max value inside an array
            int maxValue = Integer.MIN_VALUE;
            for(int i = l; i <= r; i++){
                maxValue = Math.max(maxValue, nums[i]);
            }
            results.add(maxValue);
        }
        return results.stream()
                      .mapToInt(Integer::intValue)
                      .toArray();  
    }
}
