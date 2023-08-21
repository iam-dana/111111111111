import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {   // main 시작
		Scanner sc = new Scanner(System.in);   // 입력을 받기 위한 scanner

		int N = sc.nextInt();   // 분기를 나타내는 N 입력
		int score = 0;   // 점수 저장을 위한 score

		Stack<int[]> s = new Stack<>();   // 주어진 업무를 저장할 stack

		for (int i = 0; i < N; i++) {   // 이번 분기의 N분만큼 반복
			int w = sc.nextInt();  // w 업무가 주어졌는지 확인

			if (w == 1) {   // 업무가 주어졌다면
				int A = sc.nextInt();  // 업무의 점수 입력
				int T = sc.nextInt();  // 업무 해결까지 걸리는 시간

				s.add(new int[] {A, T});  // stack 에 저장.
			}
			
			if (!s.isEmpty()) {   // 스택이 비어있지 않았을 때 업무 처리
				if(s.peek()[1] == 1) {   // 제일 나중에 들어온 업무를 끝낼 수 있을 때
					score += s.peek()[0];  // 업무 평가 점수 저장.
					s.pop();  // 업무를 stack 에서 뺌.
				}
				else {   // 업무를 마칠 수 없을 때
					s.peek()[1]--;  // 걸리는 시간 1분 빼줌.
				}
			}

		}
		System.out.println(score);   // 정답 출력
	}

}
