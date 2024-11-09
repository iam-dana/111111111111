import java.io.*;
import java.util.*;

public class Main {
    static int V, E, A, B, C, ans=0;
    static int[] parents;
    static Queue<Node> q;
    static class Node implements Comparable<Node> {
        int start, end, cost;
        public Node(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node o) {
            return this.cost-o.cost;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        parents = new int[V+1];
        for (int i=1; i<=V; i++) parents[i] = i;

        q = new PriorityQueue<>();
        for (int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            q.add(new Node(A, B, C));
        }

        while(!q.isEmpty()) {
            Node now = q.poll();
            if (find(now.start) != find(now.end)) {
                union(now.start, now.end);
                ans += now.cost;
            }
        }
        System.out.println(ans);
    }

    static int find(int a) {
        if (parents[a] != a) {
            parents[a] = find(parents[a]);
        }
        return parents[a];
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a > b) parents[a] = parents[b];
        else parents[b] = parents[a];
    }
}
