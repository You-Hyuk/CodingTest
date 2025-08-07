package barkingdog.linkedlist;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            deque.add(i + 1);
        }
        bw.write("<");

        while (deque.size() != 1) {
            for (int i = 0; i < m - 1; i++) {
                deque.addLast(deque.pollFirst());
            }
            bw.write(String.valueOf(deque.pollFirst()));
            bw.write(", ");
        }

        bw.write(String.valueOf(deque.pollFirst()));
        bw.write(">");

        bw.flush();
        bw.close();
        br.close();
    }
}
