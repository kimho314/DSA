package leetcode;

import java.util.HashMap;

public class RomanToInteger {
    public static void main(String[] args) {
        String[] in = {"III", "LVIII", "MCMXCIV"};
        Integer[] out = {3, 58, 1994};
        RomanToInteger romanToInteger = new RomanToInteger();

        for (int i = 0; i < in.length; i++) {
            // int res = romanToInteger.romanToInt1(in[i]);
            int res = romanToInteger.romanToInt2(in[i]);
            System.out.println(res);
        }
    }

    public int romanToInt1(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        s = s.replace("IV", "IIII");
        s = s.replace("IX", "VIIII");
        s = s.replace("XL", "XXXX");
        s = s.replace("XC", "LXXXX");
        s = s.replace("CD", "CCCC");
        s = s.replace("CM", "DCCCC");

        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += map.get(s.charAt(i));
        }

        return sum;
    }

    public int romanToInt2(String s) {
        int n = s.length();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            char ch1 = s.charAt(i);
            if ((i + 1) < n && getVal(ch1) < getVal(s.charAt(i + 1))) {
                sum = sum - getVal(ch1);
            } else {
                sum = sum + getVal(ch1);
            }
        }
        return sum;
    }

    public int getVal(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
