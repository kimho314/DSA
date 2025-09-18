import java.util.HashSet;
import java.util.Set;

public class FindtheDuplicatNumber {
    public static void main(String[] args) {
        FindtheDuplicatNumber sol = new FindtheDuplicatNumber();
        System.out.println(sol.findDuplicate(new int[] {1, 2, 3, 2, 2}));
        System.out.println(sol.findDuplicate(new int[] {1, 2, 3, 4, 4}));
    }

    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int elem : nums) {
            if (set.contains(elem)) {
                return elem;
            }
            set.add(elem);
        }

        return 0;
    }
}
