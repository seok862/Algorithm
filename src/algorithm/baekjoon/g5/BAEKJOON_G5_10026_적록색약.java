package algorithm.baekjoon.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [키워드]
 * 
 * [풀이과정]
 * 1. R,G,B를 입력받는 arr 배열 생성
 * 2. 방문을 확인하는 check배열을 같은 크기로 생성
 * 3. arr를 돌면서 check가 false인 위치에서 dfs 호출
 * 4. dfs를 돌면서 하나의 구역은 한번에 다 방문하기 때문에 호출할 때마다 cnt+1
 * 5. dfs를 통해 다음에 arr배열에서 다음 방문하는 값과 같을 경우 방문, check를 true로 바꾸고 다음 dfs호출 
 * 6. 적록색약인 사람은 빨간색과 초록색을 구분하지 못하기 때문에 arr배열의 R을 모두 G로 교체
 * 7. 2,3,4,5번
 * 
 * [입력]
 * 1. R,G,B를 표시해주는 arr 배열의 크기인 N
 * 2. arr배열의 데이터
 * 
 * [출력] 
 * 1. 기본 arr배열에서의 색깔별 구역 갯수
 * 2. arr배열에서 R을 모두 G로 바꾼 후의 색깔별 구역 갯수
 * 
 * @author seok
 * @since 2023.02.24
 * @see https://www.acmicpc.net/problem/10026
 * @performance 12504 kb	92 ms
 * @category # dfs
 * @note
 */

public class BAEKJOON_G5_10026_적록색약{
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static char[][] arr;
	static int ans1;
	static int ans2;
	static int N;
	static boolean[][] check;
	static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());
		arr = new char[N][N];
		ans1 = 0;
		ans2 = 0;
		check = new boolean[N][N];
		for(int i=0; i<N; i++) {
			String st = input.readLine();
			for(int j=0; j<N; j++) {
				arr[i][j] = st.charAt(j);
			}
		}
				
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!check[i][j]) {
					dfs(i,j);
					ans1++;
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i][j] == 'R') arr[i][j] = 'G';
			}
		}
		
		check = new boolean[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!check[i][j]) {
					dfs(i,j);
					ans2++;
				}
			}
		}
		
		
		System.out.println(ans1+" "+ans2);
	}
	
	public static void dfs(int x, int y) {
		check[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int nx = x+deltas[i][0];
			int ny = y+deltas[i][1];
			
			if(isIn(nx,ny) && !check[nx][ny] && arr[nx][ny]==arr[x][y]) {
				check[nx][ny] = true;
				dfs(nx,ny);
			}
		}
	}
	
	public static boolean isIn(int x, int y) {
		return 0<=x && x<N && 0<=y && y<N;
	}
}