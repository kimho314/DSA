import java.util.*;

public class Subsets {
    private List<List<Integer>> list;
    private int[] select;

    public static void main(String[] args) {
        Subsets sol = new Subsets();
        List<List<Integer>> res = sol.subsets(new int[] {1, 2, 3});
        System.out.println(res);
        res = sol.subsets(new int[] {7});
        System.out.println(res);
    }


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            List<Integer> list = new ArrayList<>();
            dfs(res, list, nums, -1, 0, i);
        }

        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> list, int[] nums, int prev, int k,
            int len) {
        if (k == len) {
            IO.println(list);
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = prev + 1; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(res, list, nums, i, k + 1, len);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs2(nums, 0, subset, res);
        return res;
    }

    private void dfs2(int[] nums, int i, List<Integer> subset, List<List<Integer>> res) {
        if (i >= nums.length) {
            System.out.println(i + " " + subset);
            res.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        dfs2(nums, i + 1, subset, res);
        subset.remove(subset.size() - 1);
        dfs2(nums, i + 1, subset, res);
    }
}
