package boj;

public class BOJ10101 {
    static FastReader SC = new FastReader();
    static int[] ANGLES = new int[3];

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            ANGLES[i] = SC.nextInt();
        }


        boolean isEquilateral = isEquilateral();
        if (isEquilateral) {
            System.out.println("Equilateral");
            return;
        }
        boolean isIsosceles = isIsosceles();
        if (isIsosceles) {
            System.out.println("Isosceles");
            return;
        }
        boolean isScalene = isScalene();
        if (isScalene) {
            System.out.println("Scalene");
            return;
        }
        System.out.println("Error");
    }

    private static boolean isEquilateral() {
        return ANGLES[0] == 60 && ANGLES[1] == 60 && ANGLES[2] == 60;
    }

    private static boolean isIsosceles() {
        boolean isMatch1 = (ANGLES[0] + ANGLES[1] + ANGLES[2]) == 180;
        boolean isMatch2 = (ANGLES[0] == ANGLES[1]) || (ANGLES[0] == ANGLES[2]) || (ANGLES[1] == ANGLES[2]);
        return isMatch1 && isMatch2;
    }

    private static boolean isScalene() {
        boolean isMatch1 = (ANGLES[0] + ANGLES[1] + ANGLES[2]) == 180;
        boolean isMatch2 = ANGLES[0] != ANGLES[1] && ANGLES[1] != ANGLES[2] && ANGLES[0] != ANGLES[2];
        return isMatch1 && isMatch2;
    }
}
