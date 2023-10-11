import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static int[] parents;
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			parents = new int[n+1];
			for(int j=0;j<=n;j++) {
				parents[j] = j;
			}
			for(int j=0;j<m;j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				if(a==0) {
					union(b,c);
				}
				if(a==1) {
					if(find(b) ==find(c)){
						System.out.println("YES");
					}
					else {
						System.out.println("NO");
					}
				}
				
			}
	}
	private static void union(int a, int b) {
		a =find(a);
		b = find(b);
		
		if(a>b) {
			parents[a] = b;
		}else {
			parents[b] = a;
		}
	}
	private static int find(int a) {
		if(parents[a] <a) {
			parents[a] = find(parents[a]); 
		}
		return parents[a];
	}
}