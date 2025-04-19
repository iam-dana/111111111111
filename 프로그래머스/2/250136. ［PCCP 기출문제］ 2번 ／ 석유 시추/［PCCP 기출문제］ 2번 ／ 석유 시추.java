import java.io.*;
import java.util.*;

class Solution {
    static int N, M;
    static Set<Integer> set;
    static Queue<Node> q; 
    static int[] ground;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static class Node {
        int x, y;
        public Node(int x, int y) {
            this.x=x;
            this.y=y;
        }
    }

    public int solution(int[][] land) {
        map = land;
        N = land.length;
        M = land[0].length;
        int answer = Integer.MIN_VALUE;
        ground = new int[500*500+3];
        // System.out.println(Arrays.deepToString(land));
        
        bfs();
        // System.out.println(Arrays.deepToString(map));
        // System.out.println(Arrays.toString(ground));
        
        for (int y=0; y<M; y++) {
            set = new HashSet<>();
            int tmp = 0;
            for (int x=0; x<N; x++) {
                if (map[x][y] != 0) {
                    set.add(map[x][y]);
                }
            }
            for (int ele : set) {
                tmp += ground[ele];
            }
            answer = Math.max(tmp, answer);
        }
        
        return answer;
    }
    
    public void bfs() {
        visited = new boolean[N][M];
        q = new ArrayDeque<>();
        int count = 2;
        for (int x=0; x<N; x++) {
            for (int y=0; y<M; y++) {
                if (map[x][y] == 1 && !visited[x][y]) {
                    q.offer(new Node(x, y));
                    ground[count]++;
                    visited[x][y] = true;
                    map[x][y] = count;
                    while (!q.isEmpty()) {
                        Node now = q.poll();
                        for (int i=0; i<4; i++) {
                            int nx = now.x+dx[i];
                            int ny = now.y+dy[i];
                            if (0 > nx || nx >= N || 0 > ny || ny >= M) continue;
                            if (map[nx][ny] == 1 && !visited[nx][ny]) {
                                q.add(new Node(nx, ny));
                                map[nx][ny] = count;
                                ground[count]++;
                            }
                        }
                    }
                    count++;
                }
            }
        }
    }
}