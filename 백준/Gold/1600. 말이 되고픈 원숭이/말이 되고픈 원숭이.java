import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int[] dxK = {-2, -1, -2, -1, 1, 2, 1, 2};
    static int[] dyK = {-1, -2, 1, 2, -2, -1, 2, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][] board = new int[H][W];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][][] visited = new int[31][H][W];
        System.out.println(bfs(K, W, H, board, visited));
    }

    static int bfs(int K, int W, int H, int[][] board, int[][][] visited) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0, 0, 0});  // x좌표, y좌표, 거리, 대각선으로 움직인 수
        visited[0][0][0] = 1;

        while (!q.isEmpty()) {
            int[] s = q.poll();
            int x = s[0];
            int y = s[1];
            int dist = s[2];
            int k = s[3];

            if (x == H - 1 && y == W - 1) {
                return dist;
            }

            if (k < K) {
                for (int i = 0; i < 8; i++) {
                    int nx = x + dxK[i];
                    int ny = y + dyK[i];
                    if (0 <= nx && nx < H && 0 <= ny && ny < W) {
                        if (visited[k + 1][nx][ny] == 0 && board[nx][ny] == 0) {
                            q.offer(new int[]{nx, ny, dist + 1, k + 1});
                            visited[k + 1][nx][ny] = 1;
                        }
                    }
                }
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0 <= nx && nx < H && 0 <= ny && ny < W) {
                    if (visited[k][nx][ny] == 0 && board[nx][ny] == 0) {
                        q.offer(new int[]{nx, ny, dist + 1, k});
                        visited[k][nx][ny] = 1;
                    }
                }
            }
        }

        return -1;
    }
}