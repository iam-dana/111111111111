import java.io.*;
import java.util.*;

public class Main {
    static int N, Q, p, q, r, k, v, answer;
    static boolean[] visited;
    static List<Node>[] list;
    static Queue<Integer> queue;

    static class Node implements Comparable<Node> {
        int end, usado;

        public Node(int end, int usado) {
            this.end = end;
            this.usado = usado;
        }

        @Override
        public String toString() {
            return end + " " + usado;
        }

        @Override
        public int compareTo(Node o) {
            return this.usado - o.usado;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) list[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            p = Integer.parseInt(st.nextToken());
            q = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            list[p].add(new Node(q, r));
            list[q].add(new Node(p, r));
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            visited = new boolean[N + 1];
            answer = 0;
            queue = new LinkedList<>();

            visited[v] = true;
            queue.add(v);

            while (!queue.isEmpty()) {
                int now = queue.poll();
                for (Node next : list[now]) {
                    if (!visited[next.end] && next.usado >= k) {
                        queue.add(next.end);
                        visited[next.end] = true;
                        answer++;
                    }
                }
            }
            System.out.println(answer);
        }
    }
}
