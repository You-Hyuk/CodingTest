package barkingdog.deque;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Node{

    long value;
    int index;

    public Node(long value, int index) {
        this.value = value;
        this.index = index;
    }
}

public class BOJ11003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Deque<Node> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        long min = 0;

        Node init = new Node(Long.parseLong(st.nextToken()), 1);
        deque.addLast(init);
        sb.append(init.value).append(" ");

        for (int i = 2; i <= n; i++) {
            long input = Long.parseLong(st.nextToken());
            Node node = new Node(input, i);

            while (true) {

                if (deque.isEmpty()) {
                    deque.addLast(node);
                    break;
                }
                else if (deque.peekLast().value > input) {
                    deque.pollLast();
                } else if (deque.peekLast().value == input) {
                    deque.peekLast().index = i;
                    break;
                } else {
                    deque.addLast(node);
                    break;
                }
            }

            if (deque.peekFirst().index < i - l + 1) {
                deque.pollFirst();
            }

            sb.append(deque.peekFirst().value).append(" ");

        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
