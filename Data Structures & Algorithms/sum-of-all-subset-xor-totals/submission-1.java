class Solution {
    public int subsetXORSum(int[] nums) {
        Deque<int[]> stack = new ArrayDeque<>();//[index, total]
        stack.push(new int[]{0,0});
        int sum = 0;

        while(!stack.isEmpty()){
            int[] cur = stack.pop();
            int index = cur[0];
            int total = cur[1];

            if(index == nums.length){
                sum+=total;
                continue;
            }

            stack.push(new int[]{index + 1, total});
            stack.push(new int[]{index + 1, total ^ nums[index]});
        }

        return sum;
    }
}