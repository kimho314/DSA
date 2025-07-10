package boj;

import java.util.Arrays;

public class BOJ6996 {
    private static FastReader SC = new FastReader();
    private static int T;

    public static void main(String[] args) {
        input();
        StringBuilder sb = new StringBuilder();
        while (T > 0) {
            T--;
            String str1 = SC.next();
            char[] arr1 = str1.toCharArray();
            String str2 = SC.next();
            char[] arr2 = str2.toCharArray();

            Arrays.sort(arr1);
            Arrays.sort(arr2);

            boolean isAnagram = true;
            if (arr1.length != arr2.length) {
                isAnagram = false;
            }
            if (isAnagram) {
                for (int i = 0; i < arr1.length; i++) {
                    if (arr1[i] != arr2[i]) {
                        isAnagram = false;
                        break;
                    }
                }
            }

            if (isAnagram) {
                sb.append(str1)
                        .append(" ")
                        .append("&")
                        .append(" ")
                        .append(str2)
                        .append(" ")
                        .append("are")
                        .append(" ")
                        .append("anagrams")
                        .append(".")
                        .append("\n");
            }
            else {
                sb.append(str1)
                        .append(" ")
                        .append("&")
                        .append(" ")
                        .append(str2)
                        .append(" ")
                        .append("are")
                        .append(" ")
                        .append("NOT")
                        .append(" ")
                        .append("anagrams")
                        .append(".")
                        .append("\n");
            }
        }

        System.out.println(sb);
    }

    private static void input() {
        T = SC.nextInt();
    }
}
