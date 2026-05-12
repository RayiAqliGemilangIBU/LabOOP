import java.io.*;
import java.util.*;

public class GradeProcessor {
    private static final String FILE = "grades.txt";

    public void printValidGrades() {
        processFile(line -> {
            String[] parts = line.split(",");
            if (parts.length == 2) {
                try {
                    int grade = Integer.parseInt(parts[1]);
                    if (grade >= 0 && grade <= 100) System.out.println(parts[0] + ": " + grade);
                } catch (NumberFormatException ignored) {}
            }
        });
    }

    public double calculateAverage() {
        List<Integer> grades = new ArrayList<>();
        processFile(line -> {
            String[] parts = line.split(",");
            try {
                int g = Integer.parseInt(parts[1]);
                if (g >= 0 && g <= 100) grades.add(g);
            } catch (Exception ignored) {}
        });
        return grades.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }

    private void processFile(java.util.function.Consumer<String> action) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
            String line;
            while ((line = br.readLine()) != null) action.accept(line);
        } catch (IOException e) { System.out.println("File Error."); }
    }
}
