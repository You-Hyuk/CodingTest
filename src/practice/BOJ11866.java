package practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= k; i++) {
            queue.add(i);
        }

        bw.write("<");

        while (queue.size() != 1) {
            for (int j = 1; j < n; j++) {
                int temp = queue.poll();
                queue.add(temp);
            }
            bw.write(queue.poll() + ", ");
        }

        bw.write(queue.poll() + ">");
        bw.flush();
        bw.close();
        br.close();

    }

}