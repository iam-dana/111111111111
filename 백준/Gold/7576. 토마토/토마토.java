import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int nx, ny;
    static int white, ans=-1;
    static int[][] box;
    static boolean[][] visited;
    static Queue<Node> red, newRed;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static class Node {
        int x, y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        box = new int[N][M];
        visited = new boolean[N][M];
        red = new ArrayDeque<>();

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    red.offer(new Node(i, j));
                    visited[i][j] = true;
                } else if (box[i][j] == 0) {
                    white++;
                }
            }
        }
        tomato();
    }
    static void tomato() {
        if (white == 0) {
            System.out.println(0);
            return;
        }

        while (true) {
            newRed = new ArrayDeque<>();
            ans++;
            while (!red.isEmpty()) {
                Node now = red.poll();
                for (int i=0; i<4; i++) {
                    nx = now.x+dx[i]; ny = now.y+dy[i];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                    if (box[nx][ny] == 0 && !visited[nx][ny]) {
                        box[nx][ny] = 1;
                        visited[nx][ny] = true;
                        newRed.add(new Node(nx, ny));
                        white--;
                    }
                }
            }
            if (newRed.isEmpty()) break;
            red = newRed;
        }

        if (white==0) System.out.println(ans);
        else System.out.println(-1);
    }
}
