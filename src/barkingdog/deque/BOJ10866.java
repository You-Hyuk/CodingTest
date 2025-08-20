package barkingdog.deque;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push_front":
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    break;

                    case "push_back":
                    deque.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    if (deque.isEmpty()) {
                        sb.append(-1);
                    } else {
                        sb.append(deque.pollFirst());
                    }
                    sb.append("\n");
                    break;
                    case "pop_back":
                    if (deque.isEmpty()) {
                        sb.append(-1);
                    } else {
                        sb.append(deque.pollLast());
                    }
                    sb.append("\n");
                    break;
                case "size":
                    sb.append(deque.size());
                    sb.append("\n");
                    break;
                case "empty":
                    if (deque.isEmpty()) {
                        sb.append(1);
                    } else {
                        sb.append(0);
                    }
                    sb.append("\n");
                    break;
                case "front":
                    if (deque.isEmpty()) {
                        sb.append(-1);
                    } else {
                        sb.append(deque.peek());
                    }
                    sb.append("\n");
                    break;
                case "back":
                    if (deque.isEmpty()) {
                        sb.append(-1);
                    } else {
                        sb.append(deque.peekLast());
                    }
                    sb.append("\n");
                    break;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
