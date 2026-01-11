import java.util.List;

public class Epam7 {
    static void main() {
        // 2 4 6 8 10
        // 4 8 12 16 20
        // 60
        int res = sum(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 2);
        IO.println(res);
        assert res == 60;
    }

    private static int sum(List<Integer> list, int constatnt) {
        return list.stream()
                .filter(it -> it % 2 == 0)
                .mapToInt(it -> it * constatnt)
                .sum();
    }
}
