import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Person> dataPool = new ArrayList<>();

        dataPool.add(new Teacher("Adilet Duman", "Discrete math", 10));
        dataPool.add(new Teacher("Orazova Arailym", "OOP", 5));
        dataPool.add(new Student("Toretay Ali", 18, 1.7));
        dataPool.add(new Student("Mukhamedsharip Aibyn", 19, 3.5));

        Institution i1 = new Institution("AITU", "Astana");
        i1.display();

        System.out.println("\n--- Sorted by name ---");
        dataPool.sort(Comparator.comparing(Person::getName));
        dataPool.forEach(Person::display);

        System.out.println("\n--- Filtering (GPA > 2.0) ---");
        dataPool.stream()
                .filter(p -> p instanceof Student && ((Student) p).getGpa() > 2.0)
                .forEach(Person::display);

        System.out.println("\n--- Searching (Teacher Adilet) ---");
        dataPool.stream()
                .filter(p -> p instanceof Teacher && p.getName().contains("Adilet"))
                .forEach(Person::display);
    }
}