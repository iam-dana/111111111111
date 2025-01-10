import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        List<Integer> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++) arr[i] = Integer.parseInt(st.nextToken());

        list.add(arr[1]);
        for (int i=2; i<=N; i++) {
            if (list.get(list.size()-1) < arr[i]) list.add(arr[i]);
            else {
                int left = 0;
                int right = list.size()-1;
                while (left < right) {
                    int mid = (right+left)/2;
                    if (list.get(mid) < arr[i]) {
                        left = mid+1;
                    } else {
                        right = mid;
                    }
                }
                list.set(right, arr[i]);
            }
        }
        System.out.println(list.size());
    }
}
