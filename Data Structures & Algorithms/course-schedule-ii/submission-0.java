class Solution {
    private Map<Integer, List<Integer>> preMap = new HashMap<>();
    private Set<Integer> visiting = new HashSet<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //[0] wanted course
        //[1] course to do
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int i = 0; i < numCourses; i++){
            preMap.put(i, new ArrayList<>());
        }

        for(int[] prereq : prerequisites){
            preMap.get(prereq[0]).add(prereq[1]);
        }

        for(int c = 0; c < numCourses; c ++){
            if(!dfs(c)){
                return new int[]{};
            }
            res.add(c);
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean dfs(int crs){
        if(visiting.contains(crs)){
            return false;
        }

        if(preMap.get(crs).isEmpty()){
            return true;
        }

        visiting.add(crs);
        for(int pre : preMap.get(crs)){
            if(!dfs(pre)){
                return false;
            }
        }
        visiting.remove(crs);
        preMap.put(crs, new ArrayList<>());
        return true;
    }
}
