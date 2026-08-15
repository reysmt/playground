class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Set<Integer> seen = new HashSet<>();
        int ROWS = prerequisites.length, COLS = prerequisites[0].length;

        return detectCycle(numCourses, prerequisites, seen);
    }

    private boolean detectCycle(int numCourses, int[][] prerequisites, Set<Integer> seen){
        int ROWS = prerequisites.length;
        int COLS = prerequisites[0].length;

        for(int r = 0; r < ROWS; r ++){
            for (int c = 0; c < COLS; c++){
                if(!seen.add(prerequisites[r][c])){
                    return false;
                }
            }
        }
        return true;
    }
}
