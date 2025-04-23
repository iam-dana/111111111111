import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static List<Integer> chickens;
    static Queue<Cow> q;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        chickens = new ArrayList<>();
        q = new PriorityQueue<>();

        for (int i = 0; i < C; i++) {
            chickens.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(chickens);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            q.add(new Cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int answer = 0;
        while (!q.isEmpty()) {
            Cow now = q.poll();
            for (int chicken : chickens) {
                if (now.start <= chicken && chicken <= now.end) {
                    answer++;
                    chickens.remove(Integer.valueOf(chicken));
                    break;
                }
            }
        }
        System.out.println(answer);
    }

    static class Cow implements Comparable<Cow> {
        int start, end;

        public Cow(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Cow o) {
            if (this.start < o.start) {
                if (this.end < o.end) return -1;
                else return 1;
            } else if (this.start > o.start){
                if (this.end <= o.end) return -1;
                else return 1;
            } else return 0;
        }

        @Override
        public String toString() {
            return start + " " + end;
        }
    }
}
