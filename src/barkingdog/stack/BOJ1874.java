package barkingdog.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BOJ1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        stack.push(0);
        int  j = 1;
        boolean flag = false;

        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(br.readLine());

            while (stack.peek() != num) {
                if (j > n) {
                    flag = true;
                    break;
                }
                sb.append("+").append("\n");
                stack.push(j);
                j++;
            }

            sb.append("-").append("\n");
            stack.pop();
        }

        if (stack.peek() != 0 || flag) {
            bw.write("NO");
        } else {
            bw.write(sb.toString());
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
