import java.util.ArrayList;
import java.util.Comparator;

public class SelectionSort {
    public static void selectionSort(ArrayList<Student> list, Comparator<Student> comparator) {
        for (int i = 0; i < list.size(); i++) {
            int min = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (comparator.compare(list.get(j), list.get(min)) < 0) {
                    min = j;
                }
            }

            Student temp = list.get(i);
            list.set(i, list.get(min));
            list.set(min, temp);
        }
    }
}
