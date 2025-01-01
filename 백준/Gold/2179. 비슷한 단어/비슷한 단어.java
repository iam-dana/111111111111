import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        String S = "";
        String T = "";
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        for (int i = 0; i < N - 1; i++) {
            String s1 = arr[i];
            for (int j = i + 1; j < N; j++) {
                String s2 = arr[j];
                int len = Math.min(s1.length(), s2.length());
                int cnt = 0;
                for (int k = 0; k < len; k++) {
                    if (s1.charAt(k) == s2.charAt(k)) cnt++;
                    else break;
                }
                if (max < cnt) {
                    max = cnt;
                    S = s1;
                    T = s2;
                }
            }
        }
        System.out.println(S);
        System.out.println(T);
    }
}