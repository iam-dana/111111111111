import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        long[] min = new long[101];
        Arrays.fill(min, Long.MAX_VALUE);
        min[2] = 1;
        min[3] = 7;
        min[4] = 4;
        min[5] = 2;
        min[6] = 6;
        min[7] = 8;
        min[8] = 10;

        int[] count = {1, 7, 4, 2, 0, 8}; 
        for (int i=9; i<=100; i++) {
            for (int j=2; j<=7; j++) {
                min[i] = Math.min(min[i-j]*10 + count[j-2], min[i]);
            }
        }

        String[] max = new String[101];
        max[0] = "";
        max[1] = "";
        for (int i=2; i<=100; i++) {
            if (i % 2 == 0) {
                max[i] = '1'+max[i-2];
            } else {
                max[i] = '7'+max[i-3];
            }
        }

        for (int t=0; t<T; t++) {
            int input = Integer.parseInt(br.readLine());
            sb.append(min[input]).append(" ").append(max[input]).append("\n");
        }

        bw.write(String.valueOf(sb));
        bw.close();
    }
}

