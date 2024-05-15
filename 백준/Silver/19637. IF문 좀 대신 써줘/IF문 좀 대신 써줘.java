import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder ans = new StringBuilder();
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] name = new String[N];
        int[] limit = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            name[i] = st.nextToken();
            limit[i] = Integer.parseInt(st.nextToken());
        }

        int power, left, right, mid=0;
        while (M-- > 0) {
            power = Integer.parseInt(br.readLine());
            left = 0;
            right = N-1;

            while (left <= right) {
                mid = (left + right) / 2;
                if (limit[mid] < power) left = mid + 1;
                else right = mid - 1;
            }
            ans.append(name[left]).append("\n");
        }
        System.out.println(ans);
    }
}
