import java.util.Arrays;

public class Epam3 {

    public static void main(String[] args) {
        Epam3 sol = new Epam3();
        int n = 4;
        int[] teamA = {1, 4, 2, 4};
        int m = 2;
        int[] teamB = {3, 5};
        System.out.println(Arrays.toString(sol.solution(n, teamA, m, teamB))); //[2,4]
        System.out.println(Arrays.toString(sol.solution2(n, teamA, m, teamB)));

        n = 3;
        teamA = new int[]{1, 2, 3};
        m = 2;
        teamB = new int[]{2, 4};
        System.out.println(Arrays.toString(sol.solution(n, teamA, m, teamB))); //[2,3]
        System.out.println(Arrays.toString(sol.solution2(n, teamA, m, teamB)));
    }

    private int[] solution(int n, int[] teamA, int m, int[] teamB) {
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (teamB[i] >= teamA[j]) {
                    cnt++;
                }
            }
            res[i] = cnt;
        }

        return res;
    }

    private int[] solution2(int n, int[] teamA, int m, int[] teamB) {
        int[] res = new int[m];
        Arrays.sort(teamA);

        for (int i = 0; i < m; i++) {
            int lower = search(n, teamA, teamB[i]);
            int cnt = lower + 1;
            res[i] = cnt;
        }

        return res;
    }

    private int search(int len, int[] arr, int target) {
        int l = 0;
        int r = len - 1;
        if (arr[0] == target) return 0;
        if (arr[len - 1] == target) return len - 1;
        int res = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] <= target) {
                res = mid;
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return res;
    }
}
