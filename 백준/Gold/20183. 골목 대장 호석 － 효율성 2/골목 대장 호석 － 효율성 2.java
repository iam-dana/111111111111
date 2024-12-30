import java.io.*;
import java.util.*;

public class Main {
    static int N, M, A, B;
    static long C;
    static int a, b, c;
    static long max = Long.MIN_VALUE, ans = -1;
    static long left, right, mid;
    static long[] distance;
    static List<Node>[] list;
    static Queue<Node> q;
    static class Node implements Comparable<Node> {
        int end;
        long cost;

        public Node(int end, long cost) {
            this.end = end;
            this.cost = cost;
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
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Long.parseLong(st.nextToken());
        distance = new long[N+1];

        list = new ArrayList[N+1];
        for (int i=0; i<=N; i++) list[i] = new ArrayList<>();

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            max = Math.max(max, c);

            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        left = 0; right = max;
        while (left <= right) {
            mid = (left+right)/2;
            if (!dijkstra(A, mid)) {
                left = mid+1;
            } else {
                ans = mid;
                right = mid-1;
            }
        }
        System.out.println(ans);
    }
    static boolean dijkstra(int start, long cost) {
        q = new PriorityQueue<>();
        Arrays.fill(distance, Long.MAX_VALUE);
        distance[start] = 0;
        q.add(new Node(start, 0));

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (distance[now.end] < now.cost) continue;

            for (Node next : list[now.end]) {
                if (cost >= next.cost && distance[next.end] > now.cost+next.cost) {
                    distance[next.end] = now.cost+next.cost;
                    q.add(new Node(next.end, distance[next.end]));
                }
            }
        }
        return distance[B] <= C;
    }
}
