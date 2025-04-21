import java.io.*;
import java.util.*;

public class Main {
    static int V, E, P, a, b, c;
    static int[] distance;
    static List<Node>[] graph;
    static Queue<Node> q;
    static class Node implements Comparable<Node> {
        int to, cost;
        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node o) {
            return this.cost-o.cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        graph = new ArrayList[V+1];
        for (int i=0; i<=V; i++) graph[i] = new ArrayList<>();

        for (int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        System.out.println(dijkstra(1)[P]+dijkstra(P)[V] <= dijkstra(1)[V] ? "SAVE HIM" : "GOOD BYE");

    }
    static int[] dijkstra(int start) {
        distance = new int[V+1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        q = new PriorityQueue<>();
        q.add(new Node(start, 0));
        distance[start] = 0;

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (distance[now.to] < now.cost) continue;

            for (Node next : graph[now.to]) {
                if (next.cost+now.cost < distance[next.to]) {
                    distance[next.to] = next.cost+now.cost;
                    q.add(new Node(next.to, next.cost+now.cost));
                }
            }
        }
        return distance;
    }
}
