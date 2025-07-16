import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Epam4 {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("1", Arrays.asList("a", "b", "c", "a")),
                new User("2", Arrays.asList("a", "b")),
                new User("3", Arrays.asList("c", "d"))
        );

        List<Map.Entry<String, Long>> top3Companies = findTop3Companies(users);
        System.out.println(top3Companies);
    }

    public static List<Map.Entry<String, Long>> findTop3Companies(List<User> users) {
        List<Map.Entry<String, Long>> top3 = users.stream()
                .flatMap(user -> user.getCertifications().stream())
                .collect(Collectors.groupingBy(
                        cert -> cert,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .toList();

        return top3;
    }

    public static class User {
        private final String name;
        private final List<String> certifications;

        public User(String name, List<String> certifications) {
            this.name = name;
            this.certifications = certifications;
        }

        public String getName() {
            return name;
        }

        public List<String> getCertifications() {
            return certifications;
        }
    }
}


