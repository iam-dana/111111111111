import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static double x, y, dist, ans=0;
    static int[] parents;
    static List<double[]> stars;
    static Queue<Node> q;
    static class Node implements Comparable<Node> {
        int start, end;
        double cost;

        public Node(int x, int y, double cost) {
            this.start = x;
            this.end = y;
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

        n = Integer.parseInt(br.readLine());
        parents = new int[n+1];
        for (int i=1; i<=n; i++) parents[i] = i;
        stars = new ArrayList<>();
        q = new PriorityQueue<>();

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            x = Double.parseDouble(st.nextToken());
            y = Double.parseDouble(st.nextToken());
            stars.add(new double[]{x, y});
        }

       for (int i=0; i<stars.size()-1; i++) {
           for (int j=i+1; j<stars.size(); j++) {
               dist = Math.sqrt(Math.pow((stars.get(i)[0]-stars.get(j)[0]), 2) + Math.pow((stars.get(i)[1]-stars.get(j)[1]), 2));
               q.add(new Node(i, j, dist));
           }
       }

       while(!q.isEmpty()) {
           Node now = q.poll();
           if (find(now.start) != find(now.end)) {
               union(now.start, now.end);
               ans += now.cost;
           }
       }
        System.out.printf("%.2f", ans);
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
