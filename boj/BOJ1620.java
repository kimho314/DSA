package boj;

import java.util.HashMap;
import java.util.Map;

public class BOJ1620 {
    static FastReader SC = new FastReader();
    static int N, M;
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        N = SC.nextInt();
        M = SC.nextInt();

        Map<Integer, String> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String pokemonName = SC.next();
            map1.put(i + 1, pokemonName);
            map2.put(pokemonName, i + 1);
        }

        for (int i = 0; i < M; i++) {
            String input = SC.next();
            try {
                Integer num = Integer.parseInt(input);
                SB.append(map1.get(num)).append('\n');
            }
            catch (Exception e) {
                SB.append(map2.get(input)).append('\n');
            }
        }
        System.out.println(SB.toString());
    }
}
