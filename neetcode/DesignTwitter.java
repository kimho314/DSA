package neetcode;

import java.util.*;

public class DesignTwitter {
    static void main() {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 10); // User 1 posts a new tweet with id = 10.
        twitter.postTweet(2, 20); // User 2 posts a new tweet with id = 20.
        IO.println(twitter.getNewsFeed(1));   // User 1's news feed should only contain their own tweets -> [10].
        IO.println(twitter.getNewsFeed(2));   // User 2's news feed should only contain their own tweets -> [20].
        twitter.follow(1, 2);     // User 1 follows user 2.
        IO.println(twitter.getNewsFeed(1));   // User 1's news feed should contain both tweets from user 1 and user 2 -> [20, 10].
        IO.println(twitter.getNewsFeed(2));   // User 2's news feed should still only contain their own tweets -> [20].
        twitter.unfollow(1, 2);   // User 1 unfollows user 2.
        IO.println(twitter.getNewsFeed(1));   // User 1's news feed should only contain their own tweets -> [10].
    }

    public static class Twitter {
        private int count;
        private Map<Integer, List<int[]>> tweetMap;
        private Map<Integer, Set<Integer>> followMap;

        public Twitter() {
            count = 0;
            tweetMap = new HashMap<>();
            followMap = new HashMap<>();
        }

        public void postTweet(int userId, int tweetId) {
            tweetMap.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[]{count--, tweetId});
        }

        public List<Integer> getNewsFeed(int userId) {
            List<Integer> res = new ArrayList<>();
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(it -> it[0]));
            followMap.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);

            for (int followeeId : followMap.get(userId)) {
                if (tweetMap.containsKey(followeeId)) {
                    List<int[]> tweets = tweetMap.get(followeeId);
                    int idx = tweets.size() - 1;
                    int[] recentTweet = tweets.get(idx);
                    int count = recentTweet[0];
                    int tweetId = recentTweet[1];
                    pq.offer(new int[]{count, tweetId, idx, followeeId});
                }
            }

            while (!pq.isEmpty() && res.size() < 10) {
                int[] cur = pq.poll();
                int count = cur[0];
                int tweetId = cur[1];
                int idx = cur[2];
                int followeeId = cur[3];
                res.add(tweetId);

                if (idx > 0) {
                    int nextIdx = idx - 1;
                    int[] nextTweet = tweetMap.get(followeeId).get(nextIdx);
                    pq.offer(new int[]{nextTweet[0], nextTweet[1], nextIdx, followeeId});
                }
            }

            return res;
        }

        public void follow(int followerId, int followeeId) {
            followMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
        }

        public void unfollow(int followerId, int followeeId) {
            followMap.computeIfPresent(followerId, (k, v) -> {
                v.remove(followeeId);
                return v;
            });
        }
    }
}
