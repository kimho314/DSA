package boj;

public class BOJ1145 {
    static FastReader SC = new FastReader();
    static int[] NUMS = new int[5];

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            NUMS[i] = SC.nextInt();
        }

        int res = 1;
        boolean found = false;
        while (true) {
            for (int i = 0; i < 3; i++) {
                for (int j = i + 1; j < 4; j++) {
                    for (int k = j + 1; k < 5; k++) {
                        if (res % NUMS[i] == 0 && res % NUMS[j] == 0 && res % NUMS[k] == 0) {
                            found = true;
                            break;
                        }
                    }
                    if (found) {
                        break;
                    }
                }
                if (found) {
                    break;
                }
            }
            if (found) {
                break;
            }
            res++;
        }
        System.out.println(res);
    }
}
