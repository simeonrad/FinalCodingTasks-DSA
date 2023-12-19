import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SmallWorld {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        int[][] matrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            String row = sc.nextLine();
            for (int j = 0; j < M; j++) {
                matrix[i][j] = row.charAt(j) - '0';
            }
        }

        List<Integer> conquestSizes = findConquestSizes(matrix);
        for (int size : conquestSizes) {
            System.out.println(size);
        }
    }

    private static List<Integer> findConquestSizes(int[][] matrix) {
        List<Integer> conquestSizes = new ArrayList<>();

        int N = matrix.length;
        int M = matrix[0].length;

        boolean[][] visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix[i][j] == 1 && !visited[i][j]) {
                    int size = dfs(matrix, visited, i, j);
                    conquestSizes.add(size);
                }
            }
        }

        conquestSizes.sort(Collections.reverseOrder());

        return conquestSizes;
    }

    private static int dfs(int[][] matrix, boolean[][] visited, int row, int col) {
        int N = matrix.length;
        int M = matrix[0].length;

        if (row < 0 || row >= N || col < 0 || col >= M || matrix[row][col] == 0 || visited[row][col]) {
            return 0;
        }

        visited[row][col] = true;
        int size = 1;

        size += dfs(matrix, visited, row - 1, col); // Up
        size += dfs(matrix, visited, row + 1, col); // Down
        size += dfs(matrix, visited, row, col - 1); // Left
        size += dfs(matrix, visited, row, col + 1); // Right

        return size;
    }
}