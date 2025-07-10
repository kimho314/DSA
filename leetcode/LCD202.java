package leetcode;

import java.util.*;

public class LCD202 {
    public static void main(String[] args) {
        LCD202 sol = new LCD202();
        System.out.println(sol.isHappy(19));
        System.out.println(sol.isHappy(2));
    }

    public boolean isHappy(int n) {
        HashSet<Integer> visit = new HashSet<>();
        while (!visit.contains(n)) {
            visit.add(n);
            n = getNextNumber(n);
            if (n == 1) {
                return true;
            }
        }
        return false;
    }

    private int getNextNumber(int n) {
        int output = 0;
        while (n > 0) {
            int digit = n % 10;
            output += digit * digit;
            n /= 10;
        }
        return output;
    }
}
