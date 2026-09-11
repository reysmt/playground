class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int count = 0;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[] current = intervals[0].clone();

        for(int i = 1; i < intervals.length; i ++){
            if(current[1] > intervals[i][0]){
                current[1] = Math.min(current[1], intervals[i][1]);
                count++;
            }else{
                current = intervals[i].clone();
            }
        }
        return count;
    }
}
