import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ24511 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> deque = new ArrayDeque<>();

        //크기 (1번째 줄)
        int n = Integer.parseInt(br.readLine());

        //큐스택 정보 (2번째 줄)
        StringTokenizer st = new StringTokenizer(br.readLine());

        //내부값 (3번째 줄)
        StringTokenizer str = new StringTokenizer(br.readLine());
        for (int i = 0; i <n; i++){
            int num = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(str.nextToken());
            if (num == 0 ) {
                deque.offer(value);
            }
        }

        //입력값 크기 (4번째 줄)
        int m = Integer.parseInt(br.readLine());

        //입력값
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < m; j++){
            int input = Integer.parseInt(st.nextToken());
            // 입력이 들어오면 맨 앞에 넣고, 맨 뒤의 값을 리턴
            deque.addFirst(input);
            sb.append(deque.pollLast()).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
