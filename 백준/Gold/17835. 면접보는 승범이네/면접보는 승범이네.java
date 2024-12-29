import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static int U, V, C;
    static int tmp;
    static long ans=Long.MIN_VALUE;
    static int ansNum;
    static List<Node>[] list;
    static Queue<Node> q;
    static boolean[] visited;
    static long[] distance;
    static class Node implements Comparable<Node> {
        int end;
        long cost;
        public Node(int end, long cost) {
            this.end=end;
            this.cost=cost;
        }
        @Override
        public int compareTo(Node o1) {
            return Long.compare(this.cost, o1.cost);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        q = new PriorityQueue<>();
        distance = new long[N+ 1];
        Arrays.fill(distance, Long.MAX_VALUE);

        list = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            U = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            list[V].add(new Node(U, C));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            tmp = Integer.parseInt(st.nextToken());
            q.offer(new Node(tmp, 0));
            distance[tmp] = 0;
        }

        dijkstra();
        for (int i=1; i<=N; i++) {
            if (ans < distance[i]) {
                ans = distance[i];
                ansNum = i;
            }
        }
        System.out.println(ansNum);
        System.out.println(ans);
    }

    static void dijkstra() {
        visited = new boolean[N+1];
        while (!q.isEmpty()) {
            Node now = q.poll();

            if (visited[now.end]) continue;
            if (distance[now.end] < now.cost) continue;
            visited[now.end] = true;

            for (Node next : list[now.end]) {
                if (now.cost+next.cost < distance[next.end]) {
                    distance[next.end] = now.cost+next.cost;
                    q.offer(new Node(next.end, now.cost+next.cost));
                }
            }
        }
    }

}
