
public class KokoEatingBababas {
    public static void main(String[] args) {
        KokoEatingBababas sol = new KokoEatingBababas();
        System.out.println(sol.minEatingSpeed(new int[] {1, 4, 3, 2}, 9));
        System.out.println(sol.minEatingSpeed(new int[] {25, 10, 23, 4}, 4));
        System.out.println(sol.minEatingSpeed(new int[] {1, 1, 1, 999999999}, 10));
    }

    public int minEatingSpeed(int[] piles, int h) {
        int res = 0;
        int l = 1;
        int r = 1_000_000_000;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (determine(mid, piles, h)) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return res;
    }

    private boolean determine(int rate, int[] piles, int h) {
        int sum = 0;
        for (int i = 0; i < piles.length; i++) {
            int hour = piles[i] / rate;
            if (piles[i] % rate > 0) {
                hour++;
            }
            sum += hour;
        }

        return sum <= h;
    }
}
