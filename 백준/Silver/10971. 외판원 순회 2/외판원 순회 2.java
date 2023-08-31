
import java.util.Scanner;

public class Main {
    static int ans = Integer.MAX_VALUE;
    static int[][] board;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        board = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
        	boolean[] visited = new boolean[N];
        	visited[i] = true;
            dfs(i, i, 0, visited, 1);
        }

        System.out.println(ans);
    }

    static void dfs(int start, int next, int cost, boolean[] visited, int cnt) {
        if (cnt == N) {
            if (board[next][start] != 0) {
                ans = Math.min(ans, cost + board[next][start]);
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (board[next][i] != 0 && !visited[i] && !(ans < cost)) {
                visited[i] = true;
                dfs(start, i, cost + board[next][i], visited, cnt+1);
                visited[i] = false;
            }
        }
    }
}
