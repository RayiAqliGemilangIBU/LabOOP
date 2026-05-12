import java.util.Iterator;
import java.util.NoSuchElementException;

public class StudentNameIterator implements Iterator<String> {
    private String[] names;
    private int index = 0;

    public StudentNameIterator(String[] names) { this.names = names; }

    @Override
    public boolean hasNext() {
        while (index < names.length) {
            String name = names[index];
            if (name != null && !name.trim().isEmpty() && name.matches("[a-zA-Z\\s]+")) return true;
            index++;
        }
        return false;
    }

    @Override
    public String next() {
        if (!hasNext()) throw new NoSuchElementException();
        return names[index++].trim().toUpperCase();
    }

    public static void main(String[] args) {
        String[] names = {"Amir", "", null, "Emina", "Sara2", "  Kerim  ", "Lejla"};
        StudentNameIterator it = new StudentNameIterator(names);
        while (it.hasNext()) System.out.println(it.next());
    }
}
