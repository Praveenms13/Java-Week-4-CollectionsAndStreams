import java.io.*;
import java.util.*;

public class CountWordsInFile {
    public static void main(String[] args) {
        String fileName = "sampleFile.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            Map<String, Integer> wordCount = new HashMap<>();

            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    word = word.toLowerCase();
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }

            List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(wordCount.entrySet());
            sortedList.sort((entry1, entry2) -> entry2.getValue() - entry1.getValue());

            System.out.println("Top 5 most frequent words:");
            for (int i = 0; i < 5 && i < sortedList.size(); i++) {
                System.out.println(sortedList.get(i).getKey() + ": " + sortedList.get(i).getValue());
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
