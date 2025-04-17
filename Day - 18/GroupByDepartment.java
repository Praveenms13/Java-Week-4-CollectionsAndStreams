import java.util.*;

class Employee {
    String name;
    String department;

    Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class GroupByDepartment {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR"),
                new Employee("Bob", "IT"),
                new Employee("Carol", "HR"));

        Map<String, List<Employee>> groupedByDepartment = new HashMap<>();

        for (Employee employee : employees) {
            String department = employee.getDepartment();
            if (!groupedByDepartment.containsKey(department)) {
                groupedByDepartment.put(department, new ArrayList<>());
            }
            groupedByDepartment.get(department).add(employee);
        }

        // Display grouped employees by department
        for (Map.Entry<String, List<Employee>> entry : groupedByDepartment.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
