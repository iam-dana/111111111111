import java.io.*;
import java.util.*;

public class Main {
    static int N, M, T, ans=Integer.MAX_VALUE;
    static int nx, ny, gram;
    static int[][] map;
    static boolean[][][] visited;
    static Deque<Node> q;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static class Node {
        int x, y, time;
        boolean gram;
        public Node(int x, int y, int time, boolean gram) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.gram = gram;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();
        if (ans == Integer.MAX_VALUE) System.out.println("Fail");
        else System.out.println(ans);

    }
    static void bfs() {
        q = new LinkedList<>();
        visited = new boolean[N][M][2];
        q.add(new Node(0, 0, 0, false));
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();
            if (now.x == N-1 && now.y == M-1 && now.time <= T) {
                ans = Math.min(ans, now.time);
            }
            for (int i=0; i<4; i++) {
                nx = now.x+dx[i]; ny = now.y+dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (!now.gram) {
                    if (map[nx][ny] == 0 && !visited[nx][ny][0]) {
                        visited[nx][ny][0] = true;
                        q.add(new Node(nx, ny, now.time+1, now.gram));
                    } else if (map[nx][ny] == 2 && !visited[nx][ny][0]) {
                        gram = 1;
                        visited[nx][ny][0] = true;
                        q.add(new Node(nx, ny, now.time+1, true));
                    }
                } else {
                    if (!visited[nx][ny][1]) {
                        visited[nx][ny][1] = true;
                        q.add(new Node(nx, ny, now.time+1, now.gram));
                    }
                }
            }
        }
    }
}
