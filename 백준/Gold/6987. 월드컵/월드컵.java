import java.util.Scanner;

public class Main {
    static int[] team1 = { 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4 };
    static int[] team2 = { 1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5 };
    static int[] answer = new int[4];
    static int[][] match = new int[6][3];
    static int[][] result = new int[6][3];

    static void DFS(int tc, int round) {
        if (round == 15) {
            if (answer[tc] != 0) return;

            for (int r = 0; r < 6; r++) {
                for (int c = 0; c < 3; c++) {
                    if (match[r][c] != result[r][c]) return;
                }
            }

            answer[tc] = 1;
            return;
        }

        int t1 = team1[round];
        int t2 = team2[round];

        result[t1][0]++;
        result[t2][2]++;
        DFS(tc, round + 1);
        result[t1][0]--;
        result[t2][2]--;

        result[t1][1]++;
        result[t2][1]++;
        DFS(tc, round + 1);
        result[t1][1]--;
        result[t2][1]--;

        result[t1][2]++;
        result[t2][0]++;
        DFS(tc, round + 1);
        result[t1][2]--;
        result[t2][0]--;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int TC = 0; TC < 4; ++TC) {
            for (int r = 0; r < 6; ++r) {
                for (int c = 0; c < 3; c++) {
                    match[r][c] = scanner.nextInt();
                }
            }
            DFS(TC, 0);
        }

        for (int i = 0; i < 4; i++) {
            System.out.print(answer[i] + " ");
        }
        System.out.println();
    }
}