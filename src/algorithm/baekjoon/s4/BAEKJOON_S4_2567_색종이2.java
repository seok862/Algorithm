package algorithm.baekjoon.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * @author seok
 * @since 2023.02.27
 * @see https://www.acmicpc.net/problem/2567
 * @performance 11632 kb	84 ms
 * @category # 구현
 * @note
 */
/*
1. 흰색 스카프의 배열 크기가 101인 map을 생성(0번인덱스 사용 x)
2. 검은색 스카프 영역을 1로 채움
3. map의 1행1열부터 완전탐색을 해 1이 들어가 있는 배열의 위치 탐색
4. 해당 위치에서 deltas배열을 통해 상,하,좌,우를 확인
5. 0이 하나라도 있는 경우 사각형의 외각에 있다고 판단
6. 둘레에 +1
7. 모서리 부분에 있을 경우 둘레는 +2이기 때문에 상,하,좌,우를 돌때마다 0을 만나면 카운트해야함
8. map의 가장 바깥쪽이 1인 경우 무조건+1
*/
public class BAEKJOON_S4_2567_색종이2 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	static int[][] map;
	static int ans;
	
	// 상,하,좌,우 확인용 deltas배열
	static int[][] deltas = {{1,0},{-1,0},{0,-1},{0,1}};
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());
		
		map = new int[101][101];
		
		for(int t=0; t<N; t++) {
			tokens = new StringTokenizer(input.readLine());
			int R = Integer.parseInt(tokens.nextToken());
			int C = Integer.parseInt(tokens.nextToken());
			
			// 흰색 스카프 map배열에 주어진 r,c에서 10을 더한만큼 1로 변경
			for(int r=R; r<R+10; r++) {
				for(int c=C; c<C+10; c++) {
					map[r][c] = 1;
				}
			}
		}
	
		// 둘레를 0으로 초기화
		ans = 0;
		
		// map배열을 완탐
		for(int r=1; r<101; r++) {
			for(int c=1; c<101; c++) {
				// 해당 구역이 검은색 스카프일 경우
				if(map[r][c] == 1) {
					
					// 상,하,좌,우를 확인
					for(int i=0; i<4; i++) {
						int nr = r+deltas[i][0];
						int nc = c+deltas[i][1];
						
						// 가장 바깥쪽이면 무조건 +1
						if(side(nr,nc)) ans+=1;
						
						// 가장 바깥쪽이 아니고 배열 안에 있으면서 0을 만나는 경우 +1
						if(isIn(nr,nc) && map[nr][nc] == 0 && !side(nr,nc)) ans+=1;
					}
				}
			}
		}
		
		System.out.println(ans);
		
	}
	
	// 4방향 탐색을 할 때 배열을 벗어나는지 확인
	public static boolean isIn(int x, int y) {
		return 1<= x && x<101 && 1<=y && y< 101;
	}
	
	// 배열의 가장 바깥쪽일 경우
	public static boolean side(int x, int y) {
		return x==0 || y==0 || x==100 || y==100;
	}
}
