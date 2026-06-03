class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> seen = new HashMap<Integer, Integer>();
        for(int i = 0; i <= numbers.length; i++){
            int complement = target - numbers[i];
            if(seen.containsKey(complement)){
                return new int[]{seen.get(complement) + 1, i + 1};
            }
            seen.put(numbers[i], i);
        } 
        return new int[]{0,0};
    }
}
