import java.io.*;

public class LargeFileHandler {
    public static void main(String[] args) {
        String fileName = "largeFile.txt";
        int numLines = 500000;

        try {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                for (int i = 0; i < numLines; i++) {
                    String line = "This is line " + (i + 1) + " with the word error somewhere.\n";
                    writer.write(line);
                }
                System.out.println("Large file generated: " + fileName);
            }

            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.toLowerCase().contains("error")) {
                        System.out.println(line);
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
