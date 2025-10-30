import java.util.*;

public class Permutations {
    private int[] select;
    private List<List<Integer>> res;
    private Map<Integer, Integer> map;

    public static void main(String[] args) {
        Permutations sol = new Permutations();
        List<List<Integer>> res = sol.permute(new int[] {1, 2, 3});
        System.out.println(res);
        res = sol.permute(new int[] {7});
        System.out.println(res);
    }

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int len = nums.length;
        select = new int[len];
        Arrays.fill(select, -11);
        res = new ArrayList<>();
        map = new HashMap<>();
        for (int elem : nums) {
            map.put(elem, map.getOrDefault(elem, 0) + 1);
        }

        dfs(0, nums, len);

        return res;
    }

    private void dfs(int k, int[] nums, int len) {
        if (k == len) {
            List<Integer> list = new ArrayList<>();
            for (int elem : select) {
                list.add(elem);
            }
            res.add(list);
        } else {
            for (int i = 0; i < len; i++) {
                if (map.get(nums[i]) > 0) {
                    select[k] = nums[i];
                    map.put(nums[i], map.get(nums[i]) - 1);
                    dfs(k + 1, nums, len);
                    select[k] = -11;
                    map.put(nums[i], map.get(nums[i]) + 1);
                }
            }
        }
    }

}
