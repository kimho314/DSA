import java.util.ArrayList;
import java.util.HashSet;

public class KaoMo2 {
    public static void main(String[] args) {
        KaoMo2 kaoMo2 = new KaoMo2();
        System.out.println(kaoMo2.solution(new int[]{0, 0, 1, 1}, new int[]{2}));
        System.out.println(kaoMo2.solution(new int[]{0, 0, 0, 0, 2, 3, 3}, new int[]{2, 5, 6}));
        System.out.println(kaoMo2.solution(new int[]{0, 0, 1, 2}, new int[]{1, 2}));
    }

    private static boolean[] VISITED;
    private static ArrayList<Integer>[] ADJ;
    private static HashSet<Character> PATH;

    public int solution(int[] T, int[] A) {
        // Implement your solution here
        VISITED = new boolean[T.length];
        ADJ = new ArrayList[T.length];
        PATH = new HashSet<>();
        for (int i = 0; i < T.length; i++) {
            ADJ[i] = new ArrayList<>();
        }
        for (int i = 1; i < T.length; i++) {
            ADJ[T[i]].add(i);
        }


        for (int i = 0; i < A.length; i++) {
            dfs(0, String.valueOf(0), A[i]);
//            System.out.println(PATH);
        }
        int res = PATH.size();
        return res;
    }


    private static void dfs(int node, String path, int target) {
        if (target == node) {
//            System.out.println(target + " " + path);
            for (int i = 0; i < path.length(); i++) {
                PATH.add(path.charAt(i));
            }
        }
        else {
            for (Integer elem : ADJ[node]) {
                dfs(elem, path + elem, target);
            }
        }
    }
}
