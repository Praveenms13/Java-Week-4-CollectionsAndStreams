import java.util.*;

class Patient {
    String name;
    int severity;

    Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }
}

public class HospitalSystem {
    public static void main(String[] args) {
        PriorityQueue<Patient> queue = new PriorityQueue<>((p1, p2) -> p2.severity - p1.severity);
        queue.add(new Patient("John", 3));
        queue.add(new Patient("Alice", 5));
        queue.add(new Patient("Bob", 2));

        System.out.println("Order of Treatment:");
        while (!queue.isEmpty()) {
            Patient patient = queue.poll();
            System.out.println(patient.name + " (Severity: " + patient.severity + ")");
        }
    }
}
