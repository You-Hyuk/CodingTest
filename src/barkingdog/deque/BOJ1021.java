package barkingdog.deque;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int pick = Integer.parseInt(st.nextToken());
        Deque<Integer> deque = new ArrayDeque<>();
        int result = 0;

        for (int i = 1; i <= size; i++) {
            deque.add(i);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < pick; i++) {
            int num = Integer.parseInt(st.nextToken());
            int resultFirst = 0;
            int resultLast = 0;

            //덱을 한 쪽으로만 돌려도 앞에서 뺏을 경우와 뒤에서 뺏을 경우의 횟수를 찾을 수 있음
            //앞에서 찾는 것으로 횟수 측정 (최종 찾는 값은 맨 앞에 있는 상태)
            while (deque.peekFirst() != num) {
                deque.addLast(deque.pollFirst());
                resultFirst++;
            }

            resultLast = deque.size() - resultFirst;

            if (resultFirst < resultLast) {
                result += resultFirst;
            } else {
                result += resultLast;
            }

            deque.pollFirst();

        }

        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
        br.close();
    }
}
