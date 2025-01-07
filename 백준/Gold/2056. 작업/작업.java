import java.io.*;
import java.util.*;

public class Main {
    static int N, t, n, prev, ans=0;
    static List<Integer>[] list;
    static Queue<Integer> q;
    static int[][] indegree;
    static int[] result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        for (int i=0; i<=N; i++) list[i] = new ArrayList<>();
        indegree = new int[N+1][2];
        result = new int[N+1];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            t = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            indegree[i+1][0] = t;
            for (int j = 0; j < n; j++) {
                prev = Integer.parseInt(st.nextToken());
                indegree[i+1][1]++;
                list[prev].add(i+1);
            }
        }
        topologicalSort();
        System.out.println(ans);
    }
    static void topologicalSort() {
        q = new LinkedList<>();
        for (int i=1; i<=N; i++) {
            result[i] = indegree[i][0];
            if (indegree[i][1] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : list[now]) {
                indegree[next][1]--;
                result[next] = Math.max(result[next], result[now] + indegree[next][0]);
                if (indegree[next][1] == 0) {
                    q.offer(next);
                }
            }
        }
        ans = Arrays.stream(result).max().getAsInt();
    }
}
