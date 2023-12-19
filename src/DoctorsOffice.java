import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DoctorsOffice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Queue<String> doctorQueue = new LinkedList<>();

        while (true) {
            String command = scanner.nextLine();
            if (command.equals("End")) {
                break;
            }

            processCommand(command, doctorQueue);
        }
    }

    private static void processCommand(String command, Queue<String> doctorQueue) {
        String[] splitter = command.split(" ");

        switch (splitter[0]) {
            case "Append":
                append(splitter[1], doctorQueue);
                break;
            case "Insert":
                insert(Integer.parseInt(splitter[1]), splitter[2], doctorQueue);
                break;
            case "Find":
                find(splitter[1], doctorQueue);
                break;
            case "Examine":
                examine(Integer.parseInt(splitter[1]), doctorQueue);
                break;
        }
    }

    private static void append(String name, Queue<String> doctorQueue) {
        doctorQueue.add(name);
        System.out.println("OK");
    }

    private static void insert(int position, String name, Queue<String> doctorQueue) {
        if (position >= 0 && position <= doctorQueue.size()) {
            int index = Math.min(position, doctorQueue.size());
            ((LinkedList<String>) doctorQueue).add(index, name);
            System.out.println("OK");
        } else {
            System.out.println("Error");
        }
    }

    private static void find(String name, Queue<String> doctorQueue) {
        long count = doctorQueue.stream().filter(patient -> patient.equals(name)).count();
        System.out.println(count);
    }

    private static void examine(int count, Queue<String> doctorQueue) {
        if (count >= 1 && count <= doctorQueue.size()) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < count; i++) {
                result.append(doctorQueue.poll()).append(" ");
            }
            System.out.println(result.toString().trim());
        } else {
            System.out.println("Error");
        }
    }
}