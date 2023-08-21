import java.util.Scanner;

public class Main {

	public static void main(String[] args) {   // main 시작
		Scanner sc = new Scanner(System.in);   // 입력을 위한 Scanner 선언

		int T = sc.nextInt();  // 요리시간 T를 입력 받음.
		int a = 0, b = 0, c = 0;   // 300초, 60초, 10초 횟수를 저장할 변수

		while (true) {   // T 를 줄여가며 반복함.
			if (T == 0) {   // T 가 0 이 됐을 때 정답
				System.out.println(a + " " + b + " " + c);   // 해당 횟수를 각각 출력.
				return;  // 메인 종료
			}
			
			if (T < 0) {  // T가 0이 되지 못했을 때
				System.out.println(-1);  // -1 을 출력함
				return;  // main 종료
			}
			
			if (T > 300) {   // T가 300보다 클 때
				T -= 300;    // 300초 버튼을 누르고 그 만큼 T에서 빼줌
				a++;  // 300초에 대한 횟수 카운트 +1
				continue;  // while 문 다시 반복
			}
			
			if (T >= 60) {   // T 가 60보다 클 때
				T -= 60;     // 60초 버튼을 누르고 그 만큼 T에서 빼줌
				b++;		 // 60초에 대한 횟수 카운트 +1
				continue;    // while 문 다시 반복
			}
			
			T -= 10;   // T에서 10초 빼줌
			c++;       // 10초에 대한 횟수 카운트 +1
		}
		
	}

}
