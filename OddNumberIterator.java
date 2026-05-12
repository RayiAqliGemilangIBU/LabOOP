import java.util.Iterator;
import java.util.NoSuchElementException;

public class OddNumberIterator implements Iterator<Integer> {
    private int[] numbers;
    private int index = 0;

    public OddNumberIterator(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean hasNext() {
        while (index < numbers.length) {
            if (numbers[index] > 0 && numbers[index] % 2 != 0) return true;
            index++;
        }
        return false;
    }

    @Override
    public Integer next() {
        if (!hasNext()) throw new NoSuchElementException();
        return numbers[index++];
    }

    public static void main(String[] args) {
        int[] data = {1, -3, 2, 5, 0, 8, 7, -9, 11, 14};
        OddNumberIterator it = new OddNumberIterator(data);
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
