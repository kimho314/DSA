package boj;

public class BOJ1152 {
    static FastReader SC = new FastReader();

    public static void main(String[] args) {
        String str = SC.nextLine();

        String[] split = str.split(" ");
        int res = 0;
        for (String elem : split) {
            if (!elem.isEmpty()) {
                res++;
            }
        }
        System.out.println(res);
    }
}
