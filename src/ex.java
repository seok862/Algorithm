import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class ex {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder output;
    static int plainLength;
    static LinkedList<Integer> ll;
    static int commandSize;

    public static void main(String[] args) throws IOException {
        for (int test_case = 1; test_case <= 10; test_case++) {
            // 원본 암호문 길이, 원본 암호문, 명령어 개수, 명령어
            // x y z -> x 위치 바로 다음에 y개 숫자 삽입, z : 숫자
            br = new BufferedReader(new InputStreamReader(System.in));
            plainLength = Integer.parseInt(br.readLine());
            output = new StringBuilder();
            output.append("#").append(test_case).append(" ");
            
            ll = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < plainLength; i++) {
                ll.add(Integer.parseInt(st.nextToken()));
            }

            commandSize = Integer.parseInt(br.readLine());
             
            st = new StringTokenizer(br.readLine());
            int place = 0;
            int size = 0;
            for (int i = 0; i < commandSize;) {
                if (st.nextToken().equals("I")) {
                    place = Integer.parseInt(st.nextToken());
                    size = Integer.parseInt(st.nextToken());
                    for (int insertSize = 0; insertSize < size; insertSize++) {
                        ll.add(place, Integer.parseInt(st.nextToken()));
                        place++;
                    }
                    i++;
                }
            }
            
            for (int idx = 0; idx < 10; idx++) {
                output.append(ll.get(idx));
                if (idx != 9)
                    output.append(" ");
            }
            output.append("\n");
        }
        System.out.println(output);
    }
}
