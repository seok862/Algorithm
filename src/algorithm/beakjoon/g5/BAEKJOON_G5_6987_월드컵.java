package algorithm.beakjoon.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1. 2중for문으로 각 나라끼리의 매치를 만듦
// 2. i번 나라가 승이 있을 경우 i번째 나라의 승과 j번째 나라의 패를 -1씩 함
// 3. i번 나라가 패가 있을 경우 i번째 나라의 패와 j번째 나라의 승을 -1씩 함
// 4. 끝까지 돌았을 때 i번째 나라의 승과 패가 0이 아닌 경우 false
// 5. d를 가지고 있는 팀의 수가 홀수이면 false
public class BAEKJOON_G5_6987_월드컵 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N,M,cnt;
	static int W,D,L,drawCount;
	static country[] arr;
	public static void main(String[] args) throws IOException {
		for(int t=0; t<4; t++) {
			tokens = new StringTokenizer(input.readLine());
			arr = new country[6];
			drawCount = 0;
			for(int i=0; i<6; i++) {
				int w = Integer.parseInt(tokens.nextToken());
				int d = Integer.parseInt(tokens.nextToken());
				int l = Integer.parseInt(tokens.nextToken());
				
				arr[i] = new country(w,d,l);
			}
			boolean check = true;
			
			for(int i=0; i<arr.length-1; i++) {
				for(int j=i+1; j<arr.length; j++) {
					if(arr[i].win != 0 && arr[j].lose != 0) {
						arr[i].win--;
						arr[j].lose--;
					}else if(arr[i].lose != 0 && arr[j].win != 0) {
						arr[i].lose--;
						arr[j].win--;
					}
				}
				
				if(arr[i].draw != 0) {
					drawCount++;
				}
				
				System.out.println("i:"+i+":"+arr[i].win+":"+arr[i].lose+" : "+drawCount);
				if(arr[i].win != 0 || arr[i].lose != 0 || drawCount%2 != 1) {
					check = false;
					break;
				}
			}
			
			
			if(check) output.append("1").append(" ");
			else output.append("0").append(" ");
		}
//		System.out.println(output.toString());
	}
	
	public static class country{
		int win;
		int draw;
		int lose;
		
		public country(int win, int draw, int lose) {
			this.win = win;
			this.draw = draw;
			this.lose = lose;
		}
	}
}
