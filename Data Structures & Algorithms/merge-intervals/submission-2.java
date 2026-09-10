class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1){
            return intervals;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> res = new ArrayList<>();
        int[] current = intervals[0].clone(); //clone first element
        
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] <= current[1]){
                current[1] = Math.max(current[1], intervals[i][1]);
            }else{
                res.add(current);
                current = intervals[i].clone();
            }
        }

        res.add(current);
        return res.toArray(new int[res.size()][]);
    }
}
