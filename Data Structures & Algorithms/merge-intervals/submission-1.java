class Solution {
    public int[][] merge(int[][] intervals) {

        if(intervals.length <= 1){
            return intervals;
        }

        List<int[]> res = new ArrayList<>();
        int[] temp = new int[2];
        
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] <= intervals[i-1][1]){
                intervals[i][0] = Math.min(intervals[i-1][0], intervals[i][0]);
                intervals[i][1] = Math.max(intervals[i-1][1], intervals[i][1]);
            }
            res.add(intervals[i]);
        }


        return res.toArray(new int[res.size()][]);
    }
}
