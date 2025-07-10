package boj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class BOJ10798 {
    static FastReader SC = new FastReader();

    public static void main(String[] args) {
        ArrayList<String>[] arr = new ArrayList[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = new ArrayList<>();
        }
        int max = 0;
        for (int i = 0; i < 5; i++) {
            String str = SC.nextLine();
            max = Math.max(max, str.length());
            arr[i].addAll(Arrays.stream(str.split("")).collect(Collectors.toList()));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < 5; j++) {
                String str = i >= arr[j].size() ? "" : arr[j].get(i);
                if (!str.isEmpty()) {
                    sb.append(str);
                }
            }
        }
        System.out.println(sb.toString());
    }
}
