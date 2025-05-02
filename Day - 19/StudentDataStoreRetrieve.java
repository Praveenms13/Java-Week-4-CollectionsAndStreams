import java.io.*;

public class StudentDataStoreRetrieve {
    public static void main(String[] args) {
        String fileName = "studentData.dat";

        try {
            writeStudentData(fileName);
            System.out.println("Student data file generated: " + fileName);

            readStudentData(fileName);
        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        }
    }

    public static void writeStudentData(String fileName) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            dos.writeInt(101);
            dos.writeUTF("Alice");
            dos.writeDouble(3.8);
            dos.writeInt(102);
            dos.writeUTF("Bob");
            dos.writeDouble(3.5);
            dos.writeInt(103);
            dos.writeUTF("Charlie");
            dos.writeDouble(3.9);
        }
    }

    public static void readStudentData(String fileName) throws IOException {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            while (dis.available() > 0) {
                int rollNumber = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.println("Roll Number: " + rollNumber + ", Name: " + name + ", GPA: " + gpa);
            }
        }
    }
}
