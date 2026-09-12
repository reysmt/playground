/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */
//Collections.sort(intervals, Comparator.comparingInt(i -> i.start));
class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        Collections.sort(intervals, Comparator.comparingInt(i -> i.start));
        int count = 1;
        for(int i = 1; i < intervals.size(); i ++ ){
            if(intervals.get(i - 1).end > intervals.get(i).start){
                count++;
            }
        }
        return count;
    }
}
