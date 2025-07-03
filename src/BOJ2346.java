import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            deque.addLast(i + 1);
            list.add(Integer.parseInt(st.nextToken()));
        }

        bw.write(deque.pollFirst() + " ");
        int num = list.get(0);

        while (!deque.isEmpty()) {
            if (num > 0) {
                for (int j = 0; j < num - 1; j++) {
                    deque.addLast(deque.pollFirst());
                }
                num = list.get(deque.getFirst() - 1);
                bw.write(deque.pollFirst() + " ");

            } else if (num < 0) {
                for (int j = 0; j < (-1 * num) - 1; j++) {
                    deque.addFirst(deque.pollLast());
                }
                num = list.get(deque.getLast() - 1);
                bw.write(deque.pollLast() + " ");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
