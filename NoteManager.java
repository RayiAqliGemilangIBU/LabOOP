import java.io.*;

public class NoteManager {
    private static final String FILE_NAME = "notes.txt";

    private boolean isValid(String note) {
        if (note == null) return false;
        String trimmed = note.trim();
        return trimmed.length() >= 3 && trimmed.length() <= 100;
    }

    public void saveNote(String note) {
        if (!isValid(note)) return;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            bw.write(note);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error saving note: " + e.getMessage());
        }
    }

    public void saveAllNotes(String[] notes) {
        if (notes == null) {
            System.out.println("The notes array is empty. Nothing to save.");
            return;
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (String note : notes) {
                if (isValid(note)) {
                    bw.write(note);
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Error saving notes: " + e.getMessage());
        }
    }

    public void printAllNotes() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("No notes file found.");
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            int count = 1;
            while ((line = br.readLine()) != null) {
                System.out.println(count++ + ". " + line);
            }
        } catch (IOException e) {
            System.out.println("Error reading notes: " + e.getMessage());
        }
    }

    public int countNotes() {
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            while (br.readLine() != null) count++;
        } catch (IOException e) {
            return 0;
        }
        return count;
    }

    public static void main(String[] args) {
        NoteManager nm = new NoteManager();
        nm.saveNote("Valid Note");
        nm.saveNote("no"); // Too short
        nm.saveNote(null);

        String[] notes = {"Study Java iterators", "", null, "Read file manipulation chapter", "  ", "Prepare JUnit tests"};
        nm.saveAllNotes(notes);
        nm.printAllNotes();
        System.out.println("Total notes: " + nm.countNotes());
    }
}
