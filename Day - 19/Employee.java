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
        ObjectOutputStream oos = null;
        try {
            FileOutputStream fos = new FileOutputStream(FILE_NAME);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(employees);
        } catch (IOException e) {
            System.out.println("Serialization error: " + e.getMessage());
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    System.out.println("Error closing stream: " + e.getMessage());
                }
            }
        }
    }

    public static List<Employee> deserializeEmployees() {
        List<Employee> employees = new ArrayList<>();
        ObjectInputStream ois = null;
        try {
            FileInputStream fis = new FileInputStream(FILE_NAME);
            ois = new ObjectInputStream(fis);
            employees = (List<Employee>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Deserialization error: " + e.getMessage());
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    System.out.println("Error closing stream: " + e.getMessage());
                }
            }
        }
        return employees;
    }
}

class Employee implements Serializable {
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
