package boj;

public class BOJ16472 {
    static FastReader sc = new FastReader();
    static int N;
    static String str;
    static int[] CHAR = new int[26];
    static int kind = 0;

    public static void main(String[] args) {
        N = sc.nextInt();
        str = sc.nextLine();

        int len = str.length();
        int ans = 0;

        // right 먼저 이동
        for (int right = 0, left = 0; right < len; right++) {
            add(str.charAt(right));

            // 더이상 인식 불간으하면 가능할때까지 left 이동
            while (kind > N) {
                erase(str.charAt(left++));
            }

            ans = Math.max(ans, right - left + 1);
        }

        System.out.println(ans);
    }

    static void add(char ch) {
        CHAR[ch - 'a']++;
        if (CHAR[ch - 'a'] == 1) {
            kind++;
        }
    }

    static void erase(char ch) {
        CHAR[ch - 'a']--;
        if (CHAR[ch - 'a'] == 0) {
            kind--;
        }
    }
}
