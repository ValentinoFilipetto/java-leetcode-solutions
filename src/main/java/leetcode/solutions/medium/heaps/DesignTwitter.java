package leetcode.solutions.medium.heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Pattern: min-heap
 * Time complexity: postTweet(), follow() and unfollow() take O(1) time, getNewsFeed() takes O(f * t), where f
 * is the number of followers and t is the number of tweets.
 * Space complexity: 
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
            (a, b) -> a[1] - b[1]
        );

        // Make a copy, otherwise followers.add(userId) mutates the real map list.
        Set<Integer> followers = new HashSet<>(
            followersMap.getOrDefault(userId, new HashSet<>())
        );

        // User should see their own tweets too.
        followers.add(userId);

        for (int follower : followers) {
            List<int[]> tweets = tweetsMap.get(follower);

            if (tweets == null) continue;

            for (int[] tweet : tweets) {
                minHeap.offer(tweet);

                // Remove oldest tweet when more than 10.
                if (minHeap.size() > 10) minHeap.poll();
            }
        }
        
        List<Integer> topTenTweets = new ArrayList<>();

        while (!minHeap.isEmpty()) {
            topTenTweets.add(minHeap.poll()[0]);
        }

        // Because min heap gives oldest -> newest,
        // but news feed needs newest -> oldest.
        Collections.reverse(topTenTweets);

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