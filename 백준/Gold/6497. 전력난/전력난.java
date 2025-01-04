import java.io.*;
import java.util.*;


public class Main {
    static int m, n, x, y, z, ans;
    static Queue<Node> q;
    static int[] parents;
    static class Node implements Comparable<Node> {
        int start, end, dist;
        public Node(int start, int end, int dist) {
            this.start = start;
            this.end = end;
            this.dist = dist;
        }
        @Override
        public int compareTo(Node o) {
            return this.dist-o.dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            if (m == 0 && n == 0) break;

            parents = new int[m+1];
            for (int i=1; i<=m; i++) parents[i] = i;

            q = new PriorityQueue<>();
            ans = 0;
            for (int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                z = Integer.parseInt(st.nextToken());
                q.add(new Node(x, y, z));
                ans += z;
            }
            while (!q.isEmpty()) {
                Node now = q.poll();
                if (find(now.start) != find(now.end)) {
                    union(now.start, now.end);
                    ans -= now.dist;
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }

    static int find(int x) {
        if (parents[x] != x) {
            parents[x] = find(parents[x]);
        }
        return parents[x];
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x > y) parents[x] = parents[y];
        else parents[y] = parents[x];
    }
}
