class Twitter {

    HashMap<Integer, List<int[]>> userNtweets;
    HashMap<Integer, Set<Integer>> userFollowing;
    int count;
    public Twitter() {
        userNtweets = new HashMap<>();
        userFollowing = new HashMap<>();
        count = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        userNtweets.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[]{count--, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        userFollowing.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);
        for(int followeeId : userFollowing.get(userId)){
            if(userNtweets.containsKey(followeeId)){
                List<int[]> tweets = userNtweets.get(followeeId);
                int index = tweets.size() - 1;
                int[] tweet = tweets.get(index);
                minHeap.offer(new int[]{tweet[0], tweet[1], followeeId, index});
            }
        }

        while(!minHeap.isEmpty() && res.size() < 10 ){
            int[] curr = minHeap.poll();
            res.add(curr[1]);
            int index = curr[3];
            if (index > 0){
                int[] tweet = userNtweets.get(curr[2]).get(index - 1);
                minHeap.offer(new int[]{tweet[0], tweet[1], curr[2], index - 1});
            }
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        userFollowing.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);

    }
    
    public void unfollow(int followerId, int followeeId) {
        userFollowing.computeIfPresent(followerId, (k,v) -> {v.remove(Integer.valueOf(followeeId)); return v;});
    }

}
