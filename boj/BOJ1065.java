package boj;

public class BOJ1065 {
    static FastReader SC = new FastReader();
    static int N;

    public static void main(String[] args) {
        N = SC.nextInt();

        int res = 0;
        for (int i = 1; i <= N; i++) {
            boolean isTrue = true;
            int tmpNum = i;
            int[] nums = new int[1000];
            int cnt = 0;
            while (tmpNum > 0) {
                int num = tmpNum % 10;
                nums[cnt++] = num;
                tmpNum = tmpNum / 10;
            }

            if (cnt > 2) {
                int diff = nums[1] - nums[0];
                for (int j = 1; j < cnt - 1; j++) {
                    if (nums[j + 1] - nums[j] != diff) {
                        isTrue = false;
                        break;
                    }
                }
            }
            if (isTrue) {
                System.out.println("num = " + i);
                res++;
            }
        }

        System.out.println("======");
        System.out.println(res);
    }
}
