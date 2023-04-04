import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Floyd{
	private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	private static int N;
	private static int[][] graph;
	private static StringTokenizer tokens;
	private static int INF = 987_654_321;
	
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(instr));
		N = Integer.parseInt(input.readLine());
		graph = new int[N][N];
		// 비 연결 간선에 대한 INF 초기화
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c=0; c<N; c++) {
				graph[r][c] = Integer.parseInt(tokens.nextToken());
				if(r!=c && graph[r][c] == 0) {
					graph[r][c] = INF;
				}
			}
		}
		
		// floyd 돌리기 : 경출도
		for(int v=0; v<N; v++) {
			for(int s=0; s<N; s++) {
				if(v==s) continue;
				for(int e=0; e<N; e++) {
					if(v==e || s==e) {
						continue;
					}
					// 기존 경로가 v를 통해서 온 경로보다 길다면 업데이트!!
					if(graph[s][e] > graph[s][v] + graph[v][e]){
						graph[s][e] = graph[s][v] + graph[v][e];
					}
				}
			}
		}
		
		for(int[] row:graph) {
			System.out.println(Arrays.toString(row));
		}
	
	}
	
	private static String instr = "4\r\n" + 
			"0 2 0 15\r\n" + 
			"0 0 10 4\r\n" + 
			"3 0 0 0\r\n" + 
			"0 0 7 0";
}