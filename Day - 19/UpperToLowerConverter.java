import java.io.*;

public class UpperToLowerConverter {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), "UTF-8"));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile), "UTF-8"))) {

            int ch;
            while ((ch = reader.read()) != -1) {
                writer.write(Character.toLowerCase(ch));
            }

            System.out.println("Conversion complete. Output written to " + outputFile);

        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        }
    }
}
