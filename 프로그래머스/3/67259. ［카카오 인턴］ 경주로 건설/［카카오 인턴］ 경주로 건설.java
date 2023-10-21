import java.util.*;

class Solution {
    public static int bfs(int N, int[][] board){
        int ans = Integer.MAX_VALUE;
        
        int dx[] = {1, -1, 0, 0};
        int dy[] = {0, 0, 1, -1};
        
        boolean[][][] visited = new boolean[N][N][4];
        // System.out.println(Arrays.deepToString(visited));
        int x = 0;
        int y = 0;
        int cost = 0;
        int dir = -1;
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x, y, cost, dir});
        
        while(!q.isEmpty()){
            x = q.peekFirst()[0];
            y = q.peekFirst()[1];
            cost = q.peekFirst()[2];
            dir = q.peekFirst()[3];
            q.poll();
            
            if (x==N-1 && y==N-1){
                ans = Math.min(ans, cost);
            }
            
            for (int i = 0; i < 4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                
                if(nx < 0 || nx >= N || ny < 0 || ny >= N || board[nx][ny] == 1){
                    continue;
                }
                
                int nextCost = cost;
                
                if (dir == -1 || dir == i){
                    nextCost += 100;
                } else {
                    nextCost += 600;
                }
                
                if (!visited[nx][ny][i] || board[nx][ny] >= nextCost){
                    visited[nx][ny][i] = true;
                    board[nx][ny] = nextCost;
                    q.add(new int[]{nx, ny, nextCost, i});
                }
                
            }
        }
        return ans;
    }
    
    public int solution(int[][] board) {

        return bfs(board.length, board);
    }
}