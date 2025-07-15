import java.util.HashMap;

public class Epam2 {
    public static void main(String[] args) {
        Epam2 sol = new Epam2();
        System.out.println(sol.solution("cdadcda")); // c
        System.out.println(sol.solution("aaa")); // a
        System.out.println(sol.solution("aaaZ0")); // Z
    }

    private char solution(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char elem : s.toCharArray()) {
            map.put(elem, map.getOrDefault(elem, 0) + 1);
        }

        int minCnt = Integer.MAX_VALUE;
        for (char elem : s.toCharArray()) {
            int cnt = map.get(elem);
            if (cnt < minCnt) {
                minCnt = cnt;
            }
        }

        char res = '\0';
        for (char elem : s.toCharArray()) {
            int cnt = map.get(elem);
            if (cnt == minCnt) {
                res = elem;
                break;
            }
        }

        return res;
    }
}
