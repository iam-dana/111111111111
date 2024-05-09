import java.io.*;
import java.util.*;

public class Main {


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder ans = new StringBuilder();
		String line = br.readLine();
		String bomb = br.readLine();
		Stack<Character> stack = new Stack<>();
		int size = bomb.length();

		for (int i=0; i<line.length(); i++) {
			stack.push(line.charAt(i));
			if (stack.size() >= size) {
				boolean flag = true;
				for (int j=0; j<size; j++) {
					if (stack.get(stack.size()-size+j)!=(bomb.charAt(j))) {
						flag = false;
						break;
					}
				}
				if (flag) {
					for(int k=0; k<size; k++) stack.pop();
				}
			}
		}
		for (Character s : stack) {
			ans.append(s);
		}
		if (ans.length() == 0)
			System.out.println("FRULA");
		else System.out.println(ans);
	}
}
