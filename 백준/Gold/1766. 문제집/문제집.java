import java.io.*;
import java.util.*;

public class Main {
    static int N, M, a, b;
    static int[] indegree;
    static StringBuilder sb;
    static List<Integer>[] list;
    static Queue<Integer> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        indegree = new int[N+1];
        list = new ArrayList[N+1];
        for (int i=0; i<=N;  i++) list[i] = new ArrayList<>();

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            indegree[b]++;
        }

        topologicalSort();
        System.out.println(sb);
    }
    static void topologicalSort() {
        q = new PriorityQueue<>();

        for (int i=1; i<=N; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i : list[now]) {
                indegree[i]--;
                if (indegree[i] == 0) {
                    q.offer(i);
                }
            }
            sb.append(now).append(" ");
        }
    }
}
