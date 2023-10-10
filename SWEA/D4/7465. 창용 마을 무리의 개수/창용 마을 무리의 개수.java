import java.util.Scanner;
import java.util.Stack;

public class Solution{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            int[][] people = new int[N + 1][N + 1];
            int groupNum = 0;
            boolean[] visited = new boolean[N + 1];
            visited[0] = true;
            
            for (int j = 0; j < M; j++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                people[a][b] = 1;
                people[b][a] = 1;
            }
            
            for (int m = 1; m <= N; m++) {
				if(!visited[m]) {
                    groupNum++;
                    visited[m] = true;
                    dfs(people, visited, m);
             	}	
        	}
       		System.out.println("#" + (i + 1) + " " + groupNum);
    	}
    }
    
    public static void dfs(int[][] people, boolean[] visited, int index){
        for (int k = 1; k < people.length; k++) {
            if (people[index][k] == 1 && !visited[k]) {
                visited[k] = true;
                dfs(people, visited, k);
            }
        }
    }
    
}