class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> sequence = new HashSet<Integer>();
        int longest = 0;
        for (int number : nums){
            sequence.add(number);
        }
        for(int number : sequence){
            if(!sequence.contains(number - 1)){
                int length = 1;
                while (sequence.contains(number + length)){
                    length ++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }
}
