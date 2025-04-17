public class CircularBuffer {
    int[] buffer;
    int head = 0;
    int tail = 0;
    int size = 0;
    int capacity;

    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        buffer = new int[capacity];
    }

    public void insert(int value) {
        buffer[tail] = value;
        tail = (tail + 1) % capacity;

        if (size < capacity) {
            size++;
        } else {
            head = (head + 1) % capacity;
        }
    }

    public void display() {
        System.out.print("Buffer: [");
        for (int i = 0; i < size; i++) {
            int index = (head + i) % capacity;
            System.out.print(buffer[index]);
            if (i != size - 1)
                System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);

        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        cb.display();

        cb.insert(4);
        cb.display();

        cb.insert(5);
        cb.display();
    }
}
