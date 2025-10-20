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
        list = new ArrayList<>();
        int len = nums.length;

        for (int i = 0; i <= len; i++) {
            select = new int[i];
            if (i == 0) {
                List<Integer> empty = new ArrayList<>();
                list.add(empty);
            } else {
                dfs(0, i, -1, nums);
            }
        }

        return list;
    }

    private void dfs(int k, int len, int prev, int[] nums) {
        if (k == len) {
            List<Integer> list2 = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                list2.add(select[i]);
            }
            list.add(list2);
        } else {
            for (int i = prev + 1; i < nums.length; i++) {
                select[k] = nums[i];
                dfs(k + 1, len, i, nums);
                select[k] = -11;
            }
        }
    }
}
