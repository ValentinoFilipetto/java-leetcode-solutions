package leetcode.solutions.medium.heaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Pattern: max-heap
 * Time complexity: postTweet(), follow() and unfollow() take O(1) time, getNewsFeed() takes O(f * log f). 
 * where f is the number of followers, for the frontier build-up.
 * 
 * Space complexity: O(Nt + NF + f) where N is the total number of user ids, t is the maximum number of tweets per user, 
 * F is the maximum number of followers per user and f is the total number of followers associated with userId
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
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> b[1] - a[1]
        );

        // Make a copy, otherwise followers.add(userId) on line 50 will mutate the real map list.
        Set<Integer> followers = new HashSet<>(
            followersMap.getOrDefault(userId, new HashSet<>())
        );

        // User should see their own tweets too.
        followers.add(userId);

        // Build a `frontier` (most recent tweets in each list of tweets) and push them to the min-heap.
        for (int follower : followers) {
            List<int[]> tweets = tweetsMap.get(follower);

            if (tweets == null) continue;

            int index = tweets.size() - 1;
            int[] tweet = tweets.get(index);
            // Structure is { tweetId, time, follower, index of last (and latest) tweet }
            maxHeap.offer(new int[] { tweet[0], tweet[1], follower, index - 1 });
        }

        List<Integer> topTenTweets = new ArrayList<>();
        while (!maxHeap.isEmpty() && topTenTweets.size() < 10) {
            // Take the most recent tweet and add it to solution.
            int[] topTweet = maxHeap.poll();
            topTenTweets.add(topTweet[0]);
            
            // Move index to the next most recent tweet in the same list and add it to minHeap.
            // It could still be more recent than other tweets in the frontier and we do not want to miss it.
            int topTweetIndex = topTweet[3];
            if (topTweetIndex >= 0) {
                int[] newTweet = tweetsMap.get(topTweet[2]).get(topTweetIndex);
                maxHeap.offer(new int[] { newTweet[0], newTweet[1], topTweet[2], topTweetIndex - 1 });
            }
        }
        return topTenTweets;
    }
    
    public void follow(int followerId, int followeeId) {
        followersMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followees = followersMap.get(followerId);
        // If followerId is not in followersMap, then followees will be null;
        if (followees == null) return;
        followees.remove(followeeId);
    }
}