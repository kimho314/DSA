import java.util.*;

public class CombinationSumII {
    private List<List<Integer>> res;
    private Set<String> set;

    public static void main(String[] args) {
        CombinationSumII sol = new CombinationSumII();
        List<List<Integer>> res = sol.combinationSum2(new int[] {9, 2, 2, 4, 6, 1, 5}, 8);
        System.out.println(res);
        res = sol.combinationSum2(new int[] {1, 2, 3, 4, 5}, 7);
        System.out.println(res);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        set = new HashSet<>();
        List<Integer> cur = new ArrayList<>();

        dfs(candidates, cur, 0, target);

        return res;
    }

    private void dfs(int[] candidates, List<Integer> cur, int i, int target) {
        if (target == 0) {
            // System.out.println(cur + " " + i + " " + target);
            List<Integer> list = new ArrayList<>(cur);
            Collections.sort(list);
            StringBuilder sb = new StringBuilder();
            for (Integer elem : list) {
                sb.append(elem);
            }
            if (!set.contains(sb.toString())) {
                res.add(list);
                set.add(sb.toString());
            }

            return;
        }
        if (target < 0 || i >= candidates.length) {
            return;
        }

        cur.add(candidates[i]);
        dfs(candidates, cur, i + 1, target - candidates[i]);
        cur.remove(cur.size() - 1);
        dfs(candidates, cur, i + 1, target);
    }
}
