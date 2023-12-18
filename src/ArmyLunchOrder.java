import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ArmyLunchOrder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        Queue<String> sergeantQueue = new LinkedList<>();
        Queue<String> corporalQueue = new LinkedList<>();
        Queue<String> privateQueue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String soldier = sc.next();
            char rank = soldier.charAt(0);

            switch (rank) {
                case 'S':
                    sergeantQueue.add(soldier);
                    break;
                case 'C':
                    corporalQueue.add(soldier);
                    break;
                case 'P':
                    privateQueue.add(soldier);
                    break;
            }
        }

        while (!sergeantQueue.isEmpty()) {
            System.out.print(sergeantQueue.poll() + " ");
        }

        while (!corporalQueue.isEmpty()) {
            System.out.print(corporalQueue.poll() + " ");
        }

        while (!privateQueue.isEmpty()) {
            System.out.print(privateQueue.poll() + " ");
        }
    }
}
