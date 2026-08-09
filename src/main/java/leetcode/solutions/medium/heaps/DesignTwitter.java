package leetcode.solutions.medium.heaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Pattern: min-heap
 * Time complexity: postTweet(), follow() and unfollow() take O(1) time, getNewsFeed() takes O(f * log f). 
 * where f is the number of followers, for the frontier build-up.
 * 
 * Space complexity: O(N * m + N * M + n) where n is the total number of followers associated with userId,
 * m is the maximum number of tweets per user, N is the total number of user ids and M is the maximum number of 
 * followers per user.
 */
class Twitter {
    private Map<Integer, List<int[]>> tweetsMap; // tweet: [tweetId, creationTime]
    private Map<Integer, Set<Integer>> followersMap;
    private int time;

    public Twitter() {
        this.tweetsMap = new HashMap<>();
        this.followersMap = new HashMap<>();
        this.time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        int[] tweet = new int[] { tweetId, time };
        tweetsMap
            .computeIfAbsent(userId, k -> new ArrayList<>())
            .add(tweet);
        time++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> b[1] - a[1]
        );

        // Make a copy, otherwise followers.add(userId) mutates the real map list.
        Set<Integer> followers = new HashSet<>(
            followersMap.getOrDefault(userId, new HashSet<>())
        );

        // User should see their own tweets too.
        followers.add(userId);

        // Build frontier (most recent tweets in each list of tweets) and push them to the min-heap.
        for (int follower : followers) {
            List<int[]> tweets = tweetsMap.get(follower);

            if (tweets == null) continue;

            int index = tweets.size() - 1;
            int[] tweet = tweets.get(index);
            minHeap.offer(new int[] { tweet[0], tweet[1], follower, index - 1 });
        }

        List<Integer> topTenTweets = new ArrayList<>();
        while (!minHeap.isEmpty() && topTenTweets.size() < 10) {
            // Take the most recent tweet and add to solution.
            int[] topTweet = minHeap.poll();
            topTenTweets.add(topTweet[0]);
            
            // Move index to the next most recent tweet in the same list and add it to minHeap.
            // It could still be more recent than other tweets in the frontier and we do not want to miss it.
            int topTweetIndex = topTweet[3];
            if (topTweetIndex >= 0) {
                int[] newTweet = tweetsMap.get(topTweet[2]).get(topTweet[3]);
                minHeap.offer(new int[] { newTweet[0], newTweet[1], topTweet[2], topTweetIndex - 1 });
            }
        }
        
        return topTenTweets;
    }
    
    public void follow(int followerId, int followeeId) {
        followersMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followees = followersMap.get(followerId);
        if (followees == null) return;
        followees.remove(followeeId);
    }
}