import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Integer>[] list;
    static String[] input;
    static int[] time, indegree, result;
    static Queue<Integer> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        time = new int[N+1];
        indegree = new int[N+1];
        result = new int[N+1];
        list = new ArrayList[N+1];
        for (int i=0; i<=N; i++) list[i] = new ArrayList<>();

        for (int i=1; i<=N; i++) {
            input = br.readLine().split(" ");
            time[i] = Integer.parseInt(input[0]);
            if (input.length >= 3) {
                for (int j=1; j<input.length-1; j++) {
                    indegree[i]++;
                    list[Integer.parseInt(input[j])].add(i);
                }
            }
        }
        topologicalSort();
        for (int i=1; i<=N; i++) sb.append(result[i]).append("\n");
        bw.write(sb.toString());
        bw.close();
    }

    static void topologicalSort() {
        q = new LinkedList<>();
        for (int i=1; i<=N; i++) {
            if (indegree[i] == 0) {
                result[i] = time[i];
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : list[now]) {
                indegree[next]--;
                result[next] = Math.max(result[next], result[now]+time[next]);
                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }
    }
}
