import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ28279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Integer> deque = new LinkedList<>();

        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            if (op == 1){
                deque.addFirst(Integer.parseInt(st.nextToken()));
            }
            if (op == 2){
                deque.addLast(Integer.parseInt(st.nextToken()));
            }
            if (op == 3){
                if (deque.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(deque.pollFirst() + "\n");
                }
            }
            if (op == 4){
                if (deque.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(deque.pollLast() + "\n");
                }
            }
            if (op == 5){
                bw.write(deque.size() + "\n");
            }
            if (op == 6){
                if (deque.isEmpty()) {
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }
            }
            if (op == 7){
                if (deque.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(deque.peekFirst() + "\n");
                }
            }
            if (op == 8){
                if (deque.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(deque.peekLast() + "\n");
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();

    }
}