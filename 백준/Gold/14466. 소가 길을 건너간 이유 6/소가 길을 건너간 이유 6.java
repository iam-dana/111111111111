import java.io.*;
import java.util.*;

public class Main {
    static int N, K, R, r1, c1, r2, c2, x, y, nx, ny;
    static int[][] tmp;
    static List<Integer>[][] map;
    static List<Node> cows;
    static boolean[][] visited;
    static Deque<Node> q;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new ArrayList[N][N];
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                map[i][j] = new ArrayList<>();
                for (int k=0; k<4; k++) map[i][j].add(k);
            }
        }

        for (int i=1; i<=R; i++) {
            st = new StringTokenizer(br.readLine());
            r1 = Integer.parseInt(st.nextToken())-1;
            c1 = Integer.parseInt(st.nextToken())-1;
            r2 = Integer.parseInt(st.nextToken())-1;
            c2 = Integer.parseInt(st.nextToken())-1;

            if (r1 == r2 && c1 > c2) {
                map[r1][c1].remove(Integer.valueOf(3));
                map[r2][c2].remove(Integer.valueOf(2));
            } else if (r1 == r2 && c1 < c2) {
                map[r1][c1].remove(Integer.valueOf(2));
                map[r2][c2].remove(Integer.valueOf(3));
            } else if (r1 > r2 && c1 == c2) {
                map[r1][c1].remove(Integer.valueOf(1));
                map[r2][c2].remove(Integer.valueOf(0));
            } else if (r1 < r2 && c1 == c2) {
                map[r1][c1].remove(Integer.valueOf(0));
                map[r2][c2].remove(Integer.valueOf(1));
            }
        }

        cows = new ArrayList<>();
        for (int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken())-1;
            y = Integer.parseInt(st.nextToken())-1;
            cows.add(new Node(x, y));
        }

        int answer = 0;
        for (int i=0; i<K-1; i++) {
            tmp = new int[N][N];
            bfs(cows.get(i));
            for (int j=i+1; j<K; j++) {
                if (tmp[cows.get(j).x][cows.get(j).y] == 0) answer++;
            }
        }
        System.out.println(answer);
    }

    static void bfs(Node start) {
        visited = new boolean[N][N];
        q = new LinkedList<>();
        q.add(start);
        visited[start.x][start.y] = true;
        tmp[start.x][start.y] = 1;

        while (!q.isEmpty()) {
            Node now = q.poll();
            for (int i : map[now.x][now.y]) {
                nx = now.x+dx[i];
                ny = now.y+dy[i];
                if (0 > nx || nx >= N || 0 > ny || ny >= N) continue;
                if (!visited[nx][ny]) {
                    tmp[nx][ny] = 1;
                    visited[nx][ny] = true;
                    q.add(new Node(nx, ny));
                }
            }
        }
    }
}
