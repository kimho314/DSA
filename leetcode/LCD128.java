package leetcode;

import java.util.HashSet;

public class LCD128 {
    public static void main(String[] args) {
        LCD128 sol = new LCD128();
        System.out.println(sol.longestConsecutive(new int[] {100, 4, 200, 1, 3, 2}));
        System.out.println(sol.longestConsecutive(new int[] {0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
        System.out.println(sol.longestConsecutive(new int[] {1, 0, 1, 2}));
    }

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        HashSet<Integer> numSet = new HashSet<>();
        for (int elem : nums) {
            numSet.add(elem);
        }

        int longestStreak = 0;
        for (int elem : numSet) {
            if (!numSet.contains(elem - 1)) {
                int curNum = elem;
                int curStreak = 1;

                while (numSet.contains(curNum + 1)) {
                    curNum++;
                    curStreak++;
                }

                longestStreak = Math.max(longestStreak, curStreak);
            }
        }
        return longestStreak;
    }
}
