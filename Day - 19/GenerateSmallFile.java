import java.io.*;

public class GenerateSmallFile {
    public static void main(String[] args) {
        String fileName = "sampleFile.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("hello world hello java hello openai\n");
            writer.write("java openai java programming hello world\n");
            writer.write("world hello java hello openai\n");
            writer.write("java openai world hello\n");
            System.out.println("Small file generated: " + fileName);
        } catch (IOException e) {
            System.out.println("Error generating file: " + e.getMessage());
        }
    }
}
