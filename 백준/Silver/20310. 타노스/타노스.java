import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split("");
		StringBuilder ans = new StringBuilder();

		int cnt0 = Collections.frequency(Arrays.asList(line), "0")/2;
		int cnt1 = Collections.frequency(Arrays.asList(line), "1")/2;


		for (int i=0; i<line.length; i++) {
			if (cnt1 == 0) break;
			if (line[i].equals("1") && cnt1 >= 1) {
				line[i] = "2";
				cnt1 -= 1;
			}
		}

		for (int i=line.length-1; i>=0; i--) {
			if (cnt0 == 0) break;
			if (line[i].equals("0") && cnt0 >= 1) {
				line[i] = "2";
				cnt0 -= 1;
			}
		}

		for (String l : line) if (!l.equals("2")) ans.append(l);

		System.out.println(ans);

	}
}
