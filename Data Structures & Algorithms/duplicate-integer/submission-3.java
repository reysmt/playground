class Solution {
    public boolean hasDuplicate(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(int num : nums){
            if(stack.size() > 0 && stack.peek() == num){
                return true;
            }
            stack.push(num);
        }
        return false;
    }
}