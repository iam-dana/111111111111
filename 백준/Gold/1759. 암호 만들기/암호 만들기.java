
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int L = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        String[] a = br.readLine().split(" ");
        List<String> V = new ArrayList<>();
        List<String> CList = new ArrayList<>();
        
        for (String tmp : a) {
            if (tmp.equals("a") || tmp.equals("e") || tmp.equals("i") || tmp.equals("o") || tmp.equals("u")) {
                CList.add(tmp);
            } else {
                V.add(tmp);
            }
        }
        
        Collections.sort(CList);
        Collections.sort(V);
        
        List<String[]> ans = new ArrayList<>();
        
        for (int i = 2; i < L; i++) {
            List<String[]> tmpV = combine(V.toArray(new String[0]), i);
            for (String[] t : tmpV) {
                List<String[]> tmpC = combine(CList.toArray(new String[0]), L - i);
                for (String[] c : tmpC) {
                    String[] newStr = Stream.concat(Arrays.stream(t), Arrays.stream(c))
                                            .sorted()
                                            .toArray(String[]::new);
                    ans.add(newStr);
                }
            }
        }
        
        Collections.sort(ans, new Comparator<String[]>() {
            @Override
            public int compare(String[] arr1, String[] arr2) {
                for (int i = 0; i < arr1.length; i++) {
                    if (!arr1[i].equals(arr2[i])) {
                        return arr1[i].compareTo(arr2[i]);
                    }
                }
                return 0;
            }
        });
        
        for (String[] a1 : ans) {
            for (String b : a1) {
                System.out.print(b);
            }
            System.out.println();
        }
    }
    
    public static List<String[]> combine(String[] arr, int r) {
        List<String[]> result = new ArrayList<>();
        boolean[] visited = new boolean[arr.length];
        combinationUtil(arr, visited, 0, arr.length - 1, 0, r, result);
        return result;
    }
    
    public static void combinationUtil(String[] arr, boolean[] visited, int start, int end, int index, int r, List<String[]> result) {
        if (index == r) {
            String[] combination = new String[r];
            int j = 0;
            for (int i = 0; i < arr.length; i++) {
                if (visited[i]) {
                    combination[j++] = arr[i];
                }
            }
            result.add(combination);
            return;
        }
        
        for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
            visited[i] = true;
            combinationUtil(arr, visited, i + 1, end, index + 1, r, result);
            visited[i] = false;
        }
    }
}