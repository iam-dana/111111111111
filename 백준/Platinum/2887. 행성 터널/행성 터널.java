import java.io.*;
import java.util.*;

public class Main {
    static int N, idx, ans=0;
    static int x, y, z;
    static int[] parents;
    static List<int[]> planets;
    static Queue<Node> q;
    static class Node implements Comparable<Node> {
        int from, to, cost;

        public Node(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            if (this.cost > o.cost) return 1;
            else if (this.cost < o.cost) return -1;
            return 0;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        parents = new int[N+1];
        for(int i=1; i<=N; i++) parents[i] = i;

        planets = new ArrayList<>();
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            z = Integer.parseInt(st.nextToken());
            planets.add(new int[]{i, x, y, z});
        }

        q = new PriorityQueue<>();
        for (int i=0; i<3; i++) {
            idx = i+1;
            planets.sort(Comparator.comparing((int[] planet)->planet[idx]));
            for (int j=0; j<planets.size()-1; j++) {
                q.add(new Node(planets.get(j)[0], planets.get(j+1)[0], Math.abs(planets.get(j)[idx]-planets.get(j+1)[idx])));
            }
        }

        while (!q.isEmpty()) {
            Node now = q.poll();
            if (find(now.from) != find(now.to)) {
                ans += now.cost;
                union(now.from, now.to);
            }
        }

        System.out.println(ans);
    }

    static int find(int x) {
        if (parents[x] != x) {
            parents[x] = find(parents[x]);
        }
        return parents[x];
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a > b) parents[a] = parents[b];
        else parents[b] = parents[a];
    }
}
