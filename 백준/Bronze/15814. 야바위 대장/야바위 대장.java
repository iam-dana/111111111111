import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str = br.readLine();
        char[] arr = new char[str.length()];
        for (int i = 0; i < str.length();i++){
            arr[i] = str.charAt(i);
        }

        int T = Integer.parseInt(br.readLine());
        int a, b;
        char tmp;
        for (int i = 0; i < T ;i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            tmp = arr[a];
            arr[a] = arr[b];
            arr[b] = tmp;
        }
        for (char c : arr) System.out.print(c);
    }
}
