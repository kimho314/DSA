package boj;

public class BOJ2941 {
    static FastReader SC = new FastReader();
    static String[] MAP = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

    public static void main(String[] args) {
        String input = SC.nextLine();

        int cnt = 0;
        for (String elem : MAP) {
            while (input.contains(elem)) {
                cnt++;
                input = input.replaceFirst(elem, " ");
            }
        }

        if (!input.isEmpty()) {
            cnt += input.replaceAll(" ", "").length();
        }

        System.out.println(cnt);
    }
}
