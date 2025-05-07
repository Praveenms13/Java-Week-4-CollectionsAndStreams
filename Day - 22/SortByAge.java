import java.util.*;

class Person {
    String name;
    int age;
    double salary;

    public Person(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("Person{name='%s', age=%d, salary=%.2f}", name, age, salary);
    }
}

public class SortByAge {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Alice", 30, 50000),
                new Person("Bob", 25, 60000),
                new Person("Charlie", 35, 55000),
                new Person("David", 28, 52000)
        );

        people.sort((p1, p2) -> Integer.compare(p1.age, p2.age));

        System.out.println("Sorted by age:");
        people.forEach(System.out::println);
    }
}
