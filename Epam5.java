import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Epam5 {
    static void main() {
        String input = "aaaabbccbdd";
        Character output = find2ndMostRepeatedCharacter(input);
        IO.println(output); //"b"
    }

    private static Character find2ndMostRepeatedCharacter(String input) {
        char[] arr = input.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : arr) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> collect = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .toList();
        IO.println(collect);
        return collect.get(1).getKey();
    }

}
