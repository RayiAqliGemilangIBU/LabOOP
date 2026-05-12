import java.io.*;

public class SafeFileReader {
    public void printFirstLine(String filePath) {
        if (filePath == null) {
            System.out.println("Error: File path is null.");
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            System.out.println(br.readLine());
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        } catch (IOException e) {
            System.out.println("General I/O error occurred.");
        }
    }

    public void printAllLines(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int count = 0;
            while ((line = br.readLine()) != null) {
                System.out.println(++count + ". " + line);
            }
            if (count == 0) System.out.println("File is empty.");
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }

    public void printLength(String input) {
        if (input == null) System.out.println("Cannot calculate length of null input.");
        else System.out.println("Length: " + input.length());
    }

    public void printWordCount(String input) {
        if (input == null || input.trim().isEmpty()) {
            System.out.println("Word count: 0");
            return;
        }
        System.out.println("Word count: " + input.trim().split("\\s+").length);
    }
}
