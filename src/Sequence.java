import java.util.Scanner;
public class Sequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int k = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);
        System.out.println(findMemberN(k, n));
    }
    private static int findMemberN(int k, int n) {
        int memberN = 0;
        if (n == 1 || n == 0){
            return memberN += k;
        }
        if (n % 3 == 0){
            memberN += (2 * findMemberN(k, n / 3)) + 1;
        }
        if (n % 3 == 1){
            memberN += findMemberN(k, n / 3) + 2;
        }
        if (n % 3 == 2){
            memberN+= findMemberN(k, ((n / 3) + 1)) + 1;
        }
        return memberN;
    }
}
 