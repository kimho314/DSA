import java.util.*;

public class SubsetsII {
    private Set<List<Integer>> set;

    public static void main(String[] args) {
        SubsetsII sol = new SubsetsII();
        List<List<Integer>> res = sol.subsetsWithDup(new int[] {1, 2, 1});
        System.out.println(res);
        res = sol.subsetsWithDup(new int[] {7, 7});
        System.out.println(res);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        Arrays.sort(nums);
        set = new HashSet<>();
        set.add(new ArrayList<>());

        dfs(nums, new ArrayList<>(), 0);

        return new ArrayList<>(set);
    }

    private void dfs(int[] nums, List<Integer> list, int i) {
        if (i >= nums.length) {
            set.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[i]);
        dfs(nums, list, i + 1);
        list.remove(list.size() - 1);
        dfs(nums, list, i + 1);
    }
}
