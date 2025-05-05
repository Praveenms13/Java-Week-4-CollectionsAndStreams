import java.util.*;
import java.util.regex.*;

public class RepeatingWordsFinder {
    public static void main(String[] args) {
        String text = "This is is a repeated repeated word test.";
        Pattern pattern = Pattern.compile("\\b(\\w+)\\b");
        Matcher matcher = pattern.matcher(text);

        Set<String> words = new HashSet<>();
        Set<String> repeatingWords = new HashSet<>();

        while (matcher.find()) {
            String word = matcher.group(1);
            if (!words.add(word)) {
                repeatingWords.add(word);
            }
        }

        System.out.println(String.join(", ", repeatingWords));
    }
}
