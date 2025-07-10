package boj;

public class BOJ9093 {
    static FastReader SC = new FastReader();
    static int T;
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        T = SC.nextInt();
        while (T > 0) {
            T--;
            String str = SC.nextLine();
            solve(str);
        }
        System.out.println(SB.toString());
    }


    private static void solve(String str) {
        String[] split = str.split(" ");
        String[] result = new String[split.length];

        for (int i = 0; i < split.length; i++) {
            result[i] = rotate(split[i]);
        }

        SB.append(String.join(" ", result)).append("\n");
    }

    private static String rotate(String input) {
        char[] arr = input.toCharArray();
        for (int i = 0; i < arr.length / 2; i++) {
            char temp = input.charAt(i);
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }

        String str = "";
        for (int i = 0; i < arr.length; i++) {
            str += String.valueOf(arr[i]);
        }
        return str;
    }
}
