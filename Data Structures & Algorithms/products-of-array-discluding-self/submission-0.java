class Solution {
    public int[] productExceptSelf(int[] nums) {
        Map<Integer, Integer> computed = new HashMap<Integer, Integer>();
        int[] result = new int[nums.length];
        for(int j = 0; j < nums.length; j ++){
            int product = 1;
            for (int i = 0; i < nums.length; i ++){
                if(nums[j] != nums[i]){
                    product *= nums[i];
                }
                result[j] = product;
            }
        }
        return result;
    }
}  
