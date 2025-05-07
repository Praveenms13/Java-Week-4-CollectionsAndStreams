import java.util.*;
import java.util.stream.Collectors;

class Employee {
    int id;
    String name;
    String department;
    double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("Employee{id=%d, name='%s', department='%s', salary=%.2f}",
                id, name, department, salary);
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
}

public class EmployeeProcessor {

    public static Map<String, Double> processEmployees(List<Employee> employees) {
        List<Employee> filteredSorted = employees.stream()
                .filter(e -> e.getDepartment().equalsIgnoreCase("Engineering") && e.getSalary() > 80000)
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .collect(Collectors.toList());

        System.out.println("Filtered and Sorted Employees:");
        filteredSorted.forEach(System.out::println);

        return filteredSorted.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ));
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", "Engineering", 90000),
                new Employee(2, "Bob", "Engineering", 85000),
                new Employee(3, "Charlie", "HR", 70000),
                new Employee(4, "David", "Engineering", 78000),
                new Employee(5, "Eve", "Marketing", 82000)
        );

        Map<String, Double> result = processEmployees(employees);

        System.out.println("\nAverage Salary by Department:");
        result.forEach((dept, avgSal) ->
                System.out.println(dept + ": $" + String.format("%.2f", avgSal)));
    }
}
