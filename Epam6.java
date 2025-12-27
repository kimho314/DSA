import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Epam6 {
    static void main() {
        String[] input = {"cloud", "aws", "azure", "gcp", "docker"};
        Map<Integer, List<String>> output = groupWordsByTheirLength(input);
        IO.println(output);
    }

    private static Map<Integer, List<String>> groupWordsByTheirLength(String[] input) {
        return Arrays.stream(input)
                .collect(Collectors.groupingBy(String::length));
    }
}
