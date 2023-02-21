package algorithm.beakjoon.g2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON_G2_3109_빵집 {

	/*
	 * 1. r*c map생성
	 * 2. 위의 r순서로 dfs 탐색, 파이프가 겹칠거나 접할 수 없기 때문에 위쪽으로 진행하는 경우가 가장 많은 경우 
	 * 3. r이 바뀔때마다 c를 dfs를 돌려 방문 한 위치를 표시해 바로 다음 r가 해당 지점을 방문할 수 없게 함
	 * 4. deltas 배열을 통해 오른쪽 위, 오른쪽, 오른쪽 아래 순서로 세 방향으로 탐색
	 * 5. c가 최대일 때 끝까지 연결된 점들의 갯수를 확인 후 출력
	 * 
	 */
	
	/**
	 * @author seok
	 * @since 2023.02.21
	 * @see https://www.acmicpc.net/problem/3109
	 * @performance 42244 kb	344 ms
	 * @category # dfs
	 * @note
	 */
	
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int R, C, ans;
	static char[][] map;
	static boolean[][] visited;
	static int[][] deltas = {{-1,1},{0,1},{1,1}};
	public static void main(String[] arg) throws IOException {
		
		tokens = new StringTokenizer(input.readLine());
		
		R= Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		
		map = new char[R][C];
		visited = new boolean[R][C];
		for(int r=0; r<R; r++) {
			String st = input.readLine();
			for(int c=0; c<C; c++) {
				char tmp = st.charAt(c);
				map[r][c] = tmp;
				if(tmp == 'x') visited[r][c] = true;
			}
		}
		
		
		for(int r=0; r<R; r++) {
			dfs(0,r,0);
		}
		
		System.out.println(ans);
	}
	
	public static boolean dfs(int lv, int row, int col) {
		if(lv==C-1) {
			ans++;
			return true;
		}
		
		for(int i=0; i<3; i++) {
			int nx = row + deltas[i][0];
			int ny = col + deltas[i][1];
			
			if(check(nx,ny) && !visited[nx][ny]) {
				visited[nx][ny] = true;
				if(dfs(lv+1,nx,ny)) return true;
			}
		}
		return false;
	}
	
	public static boolean check(int x, int y) {
		return 0<=x && x < R && 0 <= y && y<C;
	}
}
