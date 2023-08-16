import java.util.*;
import java.io.*;

/*
 * 가능할 수 없는 조건
 * 1. 승/ 패 개수가 다름
 * 2. 무승부가 분배되지 않음
*/

public class Main {
	static List<int[]> list;
	static List<int[]> game;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		game = new ArrayList<>();
		
		// 2개 팀을 선택하기 위한 조합(total 15)
		int[] p = new int[6];
		int cnt = 5; // 2개 팀 선택
		while(cnt >= 4) p[cnt--] = 1;
		
		do {
			int[] tempGame = new int[2];
			int index = 0;
			for(int i=0; i<6; i++) {
				if(p[i] == 1) {
					tempGame[index++] = i;
				}
			}
			game.add(tempGame);
		} while(NP(p));
		
		// 조합 확인
//		for(int i=0; i<game.size(); i++){
//			System.out.println(Arrays.toString(game.get(i)));
//		}
		
		for(int i=0; i<4; i++) {  // 4개의 대전표
			list = new ArrayList<>();  // 대전표
//			int winCnt=0, loseCnt=0;
//			boolean flag = false;
			
			// 대전표 입력 받기
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<6; j++) {
				int[] temp = new int[3];
				for(int k=0; k<3; k++) {
					temp[k] = Integer.parseInt(st.nextToken());
//					if(k == 0)
//						winCnt += temp[k];
//					if(k == 2)
//						loseCnt += temp[k];
				}
				list.add(temp);
			}
			
			// 승/패 개수가 다름
			if(!worldCup(0)) {  // winCnt != loseCnt | 
				sb.append(0).append("\n");
				continue;
			} else {
				sb.append(1).append("\n");
			}
			
//			// 대전표 확인
//			for(int j=0; j<6; j++)
//				System.out.println(Arrays.toString(list.get(j)));
//			System.out.println();
//			
//			sb.append(flag ? 0 : 1).append("\n");
		}
		
		System.out.println(sb);
	}
	
	private static boolean worldCup(int cnt) {  // cnt : 몇 번의 경기를 진행했는지 & 몇번째 경기 진행할지 정보
		if(cnt == 15) {  // 15번의 경기
			int sum = 0;
			for(int i=list.size()-1; i>=0; i--) {
				for(int j=2; j>=0; j--)
					sum += list.get(i)[j];
			}
			
			return sum == 0 ? true : false;
		}
		if(list.get(game.get(cnt)[0])[0] > 0 && list.get(game.get(cnt)[1])[2] > 0) {  // 승 - 패
			list.get(game.get(cnt)[0])[0]--;
			list.get(game.get(cnt)[1])[2]--;
			if(worldCup(cnt+1)) return true;
			list.get(game.get(cnt)[0])[0]++;
			list.get(game.get(cnt)[1])[2]++;
		}
		if(list.get(game.get(cnt)[0])[1] > 0 && list.get(game.get(cnt)[1])[1] > 0) {  // 무 - 무
			list.get(game.get(cnt)[0])[1]--;
			list.get(game.get(cnt)[1])[1]--;
			if(worldCup(cnt+1)) return true;
			list.get(game.get(cnt)[0])[1]++;
			list.get(game.get(cnt)[1])[1]++;
		}
		if(list.get(game.get(cnt)[0])[2] > 0 && list.get(game.get(cnt)[1])[0] > 0) {  // 패 - 승
			list.get(game.get(cnt)[0])[2]--;
			list.get(game.get(cnt)[1])[0]--;
			if(worldCup(cnt+1)) return true;
			list.get(game.get(cnt)[0])[2]++;
			list.get(game.get(cnt)[1])[0]++;
		}
		return false;
	}
	
	//NP 조합
	private static boolean NP(int[] p) {
		int i = 5; // 0~5
		while(i>0 && p[i-1] >= p[i]) i--;
		if(i == 0)
			return false;
		
		int j = 5;
		while(p[i-1] >= p[j]) j--;
		swap(p, i-1, j);
		
		int k = 5;
		while(k > i)
			swap(p, i++, k--);
		
		return true;
	}
	
	private static void swap(int[] p, int i, int j) {
		int temp = p[i];
		p[i] = p[j];
		p[j] = temp;
	}

}
