import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeSerializationDemo {
    private static final String FILE_NAME = "employees.ser";

    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1, "Alice", "HR", 50000));
        employeeList.add(new Employee(2, "Bob", "IT", 65000));
        employeeList.add(new Employee(3, "Charlie", "Finance", 55000));

        serializeEmployees(employeeList);
        System.out.println("Employees serialized to " + FILE_NAME);

        List<Employee> deserializedList = deserializeEmployees();
        System.out.println("Deserialized Employees:");
        for (Employee emp : deserializedList) {
            System.out.println(emp);
        }
    }

    public static void serializeEmployees(List<Employee> employees) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(employees);
        } catch (IOException e) {
            System.out.println("Serialization error: " + e.getMessage());
        }
    }

    public static List<Employee> deserializeEmployees() {
        List<Employee> employees = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            employees = (List<Employee>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Deserialization error: " + e.getMessage());
        }
        return employees;
    }
}
public class Employee implements Serializable {
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee [ID=" + id +
                ", Name=" + name +
                ", Department=" + department +
                ", Salary=" + salary + "]";
    }
}
