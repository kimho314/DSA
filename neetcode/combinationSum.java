package neetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class combinationSum {
    static void main() {
        combinationSum sol = new combinationSum();
        List<List<Integer>> res = sol.combinationSum(new int[]{3, 4, 5}, 16);
        System.out.println(res);
    }

    private Set<List<Integer>> res = new HashSet<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        dfs(nums, target, 0, 0, new ArrayList<>());

        return new ArrayList<>(res);
    }

    private void dfs(int[] nums, int target, int k, int sum, List<Integer> part) {
        if (sum == target) {
            System.out.println(sum + " " + part);
            List<Integer> copy = new ArrayList<>(part);
//            Collections.sort(copy);
            res.add(copy);
            return;
        }
        if (sum > target) {
            return;
        }

        for (int i = k; i < nums.length; i++) {
            part.add(nums[i]);
            dfs(nums, target, i, sum + nums[i], part);
            part.remove(part.size() - 1);
        }
    }
}
