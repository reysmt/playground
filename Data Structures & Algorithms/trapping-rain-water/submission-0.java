class Solution {
    public int trap(int[] height) {
        int l=1, r=height.length - 2;
        int res = 0;
        int maxLeft = height[0];
        int maxRight = height[height.length - 1];
        for(int i = 0; i< height.length; i++){
            System.out.println(i);
            while (l < r){
                int lowestHeight = Math.min(height[l], height[r]);
                maxLeft = height[l];
                maxRight = height[r];
                if(maxLeft < maxRight || maxLeft == maxRight){
                    l++;
                }else{
                    r--;
                }

                int calculate = Math.min(maxLeft, maxRight) - height[i];
                if(calculate > 0){
                    res += calculate;
                }
            }   
        }
        return res;
    }
}
