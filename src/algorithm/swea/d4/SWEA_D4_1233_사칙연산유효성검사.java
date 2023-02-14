package algorithm.swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * @author seok
 * @since 2023.02.14
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14eWb6AAkCFAYD&categoryId=AV14eWb6AAkCFAYD&categoryType=CODE&problemTitle=%EA%B4%84%ED%98%B8&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * @performance 18,496 kb	127 ms
 * @category #bfs인데 배열로품
 * @note
 */
public class SWEA_D4_1233_사칙연산유효성검사 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static char[] arr;
	static int N;

	public static void main(String[] args) throws IOException {
		for (int t = 1; t <= 10; t++) {
			output.append("#").append(t).append(" ");
			N = Integer.parseInt(input.readLine());
			arr = new char[N + 1];
			boolean check = true;
			int num = 0;
			for (int i = 1; i < N + 1; i++) {
				tokens = new StringTokenizer(input.readLine());
				int n = Integer.parseInt(tokens.nextToken());
				char c = tokens.nextToken().charAt(0);

				arr[n] = c;
			}
			if(N%2==0) {
				check = false;
			}else {
				num = N/2;
			}
			
			for (int j = num+1; j < N + 1; j++) {
				if (arr[j] - 0 < 49 || arr[j] - 0 > 57) {
					check = false;
				}
			}
			
			for (int j = 1; j <= num; j++) {
				if (arr[j] - 0 >= 49 && arr[j] - 0 <= 57) {
					check = false;
				}
			}
			if (!check) {
				output.append(0);
			}
			else {
				output.append(1);
			}
			output.append("\n");
		}
		System.out.println(output.toString());
	}

}
