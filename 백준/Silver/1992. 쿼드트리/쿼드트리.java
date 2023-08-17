
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {  
	static int N;
	static int[][] map;
	static String[] str;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());   // 사진의 크기 입력
		map = new int[N][N];
		str = new String[N];
		
		for(int i = 0; i < N; i++) {
			str = br.readLine().split("");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		QuadTree(0, 0, N);
		System.out.println(sb);
	}
	
	public static void QuadTree(int x, int y, int size) {
		if (isPossible(x, y, size)) {
			sb.append(map[x][y]);    
			return;
		}
		
		int newSize = size/2;
		
		sb.append("(");
		
		QuadTree(x, y, newSize);
		QuadTree(x, y+newSize, newSize);
		QuadTree(x+newSize, y, newSize);
		QuadTree(x+newSize, y+newSize, newSize);
		
		sb.append(")");
	}
	
	// 압축 가능한지 
	public static boolean isPossible(int x, int y, int size) {   
		int value = map[x][y];
		
		for (int i = x; i < x+size; i++) {
			for (int j = y; j < y+size; j++) {
				if (value != map[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
