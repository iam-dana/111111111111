import java.io.*;
import java.util.*;

public class Main {
    static int T, N, K, X, Y, W;
    static List<Integer>[] list;
    static Queue<Integer> q;
    static int[] time, indegree, result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            time = new int[N+1];
            st = new StringTokenizer(br.readLine());
            for (int i=1; i<=N; i++) time[i] = Integer.parseInt(st.nextToken());

            indegree = new int[N+1];
            list = new ArrayList[N+1];
            for(int i=0; i<=N; i++) list[i] = new ArrayList<>();
            for (int i=0; i<K; i++) {
                st = new StringTokenizer(br.readLine());
                X = Integer.parseInt(st.nextToken());
                Y = Integer.parseInt(st.nextToken());
                list[X].add(Y);
                indegree[Y]++;
            }
            W = Integer.parseInt(br.readLine());
            topologicalSort();
            sb.append(result[W]).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
    }

    static void topologicalSort() {
        q = new LinkedList<>();
        result = new int[N+1];

        for (int i=1; i<=N; i++) {
            result[i] = time[i];
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : list[now]) {
                indegree[next]--;
                result[next] = Math.max(result[next], result[now]+time[next]);
                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }
    }
}
