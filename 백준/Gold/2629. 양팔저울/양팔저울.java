import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr, ball;
    static boolean[][] result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());
        ball = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<M; i++) ball[i] = Integer.parseInt(st.nextToken());

        result = new boolean[N+1][40001];

        dfs(0, 0);

        for (int i=0; i<M; i++) {
            boolean flag = false;
            for(int j=0; j<=N; j++) {
                if (result[j][ball[i]]) {
                    flag = true;
                    break;
                }
            }
            if (flag) sb.append("Y").append(" ");
            else sb.append("N").append(" ");
        }
        bw.write(String.valueOf(sb));
        bw.close();
    }

    static void dfs(int n, int weight) {
        if (weight < 0 || weight > 40000) return;
        if (result[n][weight]) return;
        result[n][weight] = true;
        if (n == N) return;

        dfs(n+1, weight+arr[n]);
        dfs(n+1, weight);
        dfs(n+1, (weight < arr[n]) ? arr[n]-weight : weight-arr[n]);
    }
}
