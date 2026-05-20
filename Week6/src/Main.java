import java.util.ArrayList;

public class Main {
    static void main() {
        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student(105, "Liam", "Yuba City"));
        students.add(new Student(101, "Emma", "Sacramento"));
        students.add(new Student(110, "Noah", "Marysville"));
        students.add(new Student(103, "Olivia", "Chico"));
        students.add(new Student(108, "Ava", "Stockton"));
        students.add(new Student(102, "Elijah", "Modesto"));
        students.add(new Student(107, "Sophia", "Fresno"));
        students.add(new Student(104, "James", "Davis"));
        students.add(new Student(109, "Isabella", "Woodland"));
        students.add(new Student(106, "Lucas", "Roseville"));

        System.out.println("Original List:");
        printStudents(students);

        SelectionSort.selectionSort(students, new NameComparator());
        System.out.println("\nSorted by Name:");
        printStudents(students);

        SelectionSort.selectionSort(students, new RollNoComparator());
        System.out.println("\nSorted by Roll No:");
        printStudents(students);
    }

    public static void printStudents(ArrayList<Student> students) {
        for (Student s : students) {
            System.out.println(s);
        }
    }
}