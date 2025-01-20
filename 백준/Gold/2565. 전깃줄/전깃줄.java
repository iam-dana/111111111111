import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        List<Integer> list = new ArrayList<>();

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (o1, o2)->{return o1[0]-o2[0];});

        list.add(arr[0][1]);
        for (int i=1; i<N; i++) {
            if (list.get(list.size()-1) < arr[i][1]) list.add(arr[i][1]);
            else {
                int left = 0;
                int right = list.size()-1;
                while (left < right) {
                    int mid = (left+right)/2;
                    if (list.get(mid) < arr[i][1]) {
                        left = mid+1;
                    } else {
                        right = mid;
                    }
                }
                list.set(right, arr[i][1]);
            }
        }
        System.out.println(N-list.size());
    }
}
