package boj;

import java.util.*;

public class BOJ16937 {
    private static FastReader SC = new FastReader();
    private static int H, W, N;
    private static Sticker[] STICKERS;
    private static int ANS;

    private static class Sticker {
        public int r;
        public int c;

        public Sticker(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void input() {
        H = SC.nextInt();
        W = SC.nextInt();
        N = SC.nextInt();
        STICKERS = new Sticker[N];
        for (int i = 0; i < N; i++) {
            int r = SC.nextInt();
            int c = SC.nextInt();
            Sticker s = new Sticker(r, c);
            STICKERS[i] = s;
        }
        ANS = 0;
    }

    private static void solve() {

        firstSticker();

        System.out.println(ANS);
    }

    private static void firstSticker() {
        for (int i = 0; i < N; i++) {
            Sticker s = STICKERS[i];
            int h = s.r;
            int w = s.c;

            if (h <= H && w <= W) {
                secondSticker(H - h, W - w, i + 1, h * w);
            }

            if (h <= W && w <= H) {
                secondSticker(H - w, W - h, i + 1, h * w);
            }
        }
    }

    private static void secondSticker(int newH, int newW, int idx, int size) {
        for (int i = idx; i < N; i++) {
            Sticker s = STICKERS[i];
            int h = s.r;
            int w = s.c;
            if ((h <= newH && w <= W) || (h <= H && w <= newW)) {
                ANS = Math.max(ANS, size + h * w);
            }

            h = s.c;
            w = s.r;
            if ((h <= newH && w <= W) || (h <= H && w <= newW)) {
                ANS = Math.max(ANS, size + h * w);
            }
        }
    }
}
