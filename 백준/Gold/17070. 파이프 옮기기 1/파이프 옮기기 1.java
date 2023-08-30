import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[][] house = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                house[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][][] dp = new int[N][N][3];  // 0: 세로 1: 가로 2: 대각선

        for (int i = 1; i < N; i++) {  // 처음 상태 초기화
            if (house[0][i] == 0) {  // 가로를 계속 놓을 수 있으므로
                dp[0][i][1] = 1;
            } else {   // 벽을 만나면 빠져나옴
                break;
            }
        }

        for (int x = 1; x < N; x++) {
            for (int y = 1; y < N; y++) {
                if (house[x][y] == 0) {
                    dp[x][y][0] = dp[x - 1][y][0] + dp[x - 1][y][2];  // 세로를 놓을 때 직전 위치의 세로와 대각선 경우를 담음
                    dp[x][y][1] = dp[x][y - 1][1] + dp[x][y - 1][2];  // 가로를 놓을 때 직전 위치의 가로와 대각선의 경우 담음
                    if (house[x - 1][y] == 0 && house[x][y - 1] == 0) {  // 대각선을 놓을 때, 빈 칸 확인 후 직전 위치의 세로 가로 대각선 경우를 담음
                        dp[x][y][2] = dp[x - 1][y - 1][0] + dp[x - 1][y - 1][1] + dp[x - 1][y - 1][2];
                    }
                }
            }
        }

        int result = dp[N - 1][N - 1][0] + dp[N - 1][N - 1][1] + dp[N - 1][N - 1][2];
        sb.append(result);

        System.out.println(sb.toString());
    }
}