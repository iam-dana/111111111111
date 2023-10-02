import java.io.*;
import java.util.*;

public class Main {
    static int dist, n, i, tmpX, tmpY, homeX, homeY, destX, destY, s;
    static boolean visited[];
    static List<int[]> node;
    static ArrayList <ArrayList<Integer>> graph;
    static ArrayDeque<Integer> q;
    static String ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            node = new ArrayList<>();
            n = Integer.parseInt(br.readLine());
            ans = "sad";

            st = new StringTokenizer(br.readLine());
            homeX = Integer.parseInt(st.nextToken());
            homeY = Integer.parseInt(st.nextToken());
            node.add(new int[]{homeX, homeY});

            for (i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                tmpX = Integer.parseInt(st.nextToken());
                tmpY = Integer.parseInt(st.nextToken());
                node.add(new int[]{tmpX, tmpY});
            }

            st = new StringTokenizer(br.readLine());
            destX = Integer.parseInt(st.nextToken());
            destY = Integer.parseInt(st.nextToken());
            node.add(new int[]{destX, destY});

            graph = new ArrayList<>();
            for (int i = 0; i < n+2; i++){
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < node.size() - 1; i++) {
                for (int j = i+1; j < node.size(); j++) {
					dist = Math.abs(node.get(i)[0]-node.get(j)[0]) + Math.abs(node.get(i)[1]-node.get(j)[1]);
                    if (dist <= 1000){
                        graph.get(i).add(j);
                        graph.get(j).add(i);
                    }
                }
            }

            q = new ArrayDeque<>();
            q.add(0);
            visited = new boolean[n+2];
            visited[0] = true;
            while (!q.isEmpty()){
                s = q.pollFirst();
                if (s == n+1){
                    ans = "happy";
                    break;
                }
                for (int next: graph.get(s)){
                    if (!visited[next]){
                        q.add(next);
                        visited[next]= true;
                    }
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }

}
