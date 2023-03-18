package algorithm.baekjoon.g5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.02.27
 * @see https://www.acmicpc.net/problem/7511
 * @performance 164448 kb	708 ms
 * @category # 서로소 집합
 * @note
 */

public class BAEKJOON_G5_7511_소셜네트워킹어플리케이션 {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer tokens;
    static int[] repres;
    static int N, K;

    public static void main(String[] args) throws NumberFormatException, IOException {
        int test_case = Integer.parseInt(input.readLine());
        for (int t = 1; t <= test_case; t++) {
            sb.append("Scenario ").append(t).append(":").append("\n");
            N = Integer.parseInt(input.readLine()); // 사람 수 입력

            makeSet();

            // 친구 관계 입력
            int friend = Integer.parseInt(input.readLine());
            for (int i = 0; i < friend; i++) {
                tokens = new StringTokenizer(input.readLine());
                int f1 = Integer.parseInt(tokens.nextToken());
                int f2 = Integer.parseInt(tokens.nextToken());
                union(f1, f2);
            }

            // 친구인지 확인하고자 하는 경우 입력
            int problem = Integer.parseInt(input.readLine());
            for (int i = 0; i < problem; i++) {
                tokens = new StringTokenizer(input.readLine());
                int f1 = Integer.parseInt(tokens.nextToken());
                int f2 = Integer.parseInt(tokens.nextToken());
                // a, b의 대표자를 물어보고 같으면 같은 그룹, 아니면 다른 그룹
                sb.append(findSet(f1) == findSet(f2) ? 1 : 0).append("\n");
            }
            sb.append("\n");
        }
        output.write(sb.toString());
        output.flush();
        output.close();
    }

    // 각 그룹의 대표자를 자기로 하는 집합을 만든다.
    static void makeSet() {
        repres = new int[N];
        for (int n = 0; n < N; n++) {
            repres[n] = n; // 자기 자신이 대표자!!!
        }
    }

    
    // findSet : 각 요소가 속한 그룹의 대표자를 반환한다.
    static int findSet(int a) {
        if (repres[a] == a) {// 스스로가 대표자
            return a;
        } else {
            // path compression: a의 대표자를 a가 속한 그룹의 대표자로 변경해버리기!!
            return repres[a] = findSet(repres[a]);
        }
    }

    // union : 두 조직의 대표자를 합하기
    // 반환 : 합하기 동작이 성공했나?
    static boolean union(int a, int b) {
        // a와 b가 속한 그룹의 대표자를 데려오기
        a = findSet(a);
        b = findSet(b);
        // 대표자가 이미 같다!
        if (a == b) {
            return false;
        } else {
            repres[a] = b;
            return true;
        }
    }

}