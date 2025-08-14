package barkingdog.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();
        int count = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int peekIndex = 0;
        boolean isPushed = false;

        Stack<Integer> indexStack = new Stack<>();

        stack.push(0);
        indexStack.push(0);

        for (int i = 1; i <= count; i++) {
            int num = Integer.parseInt(st.nextToken());

            while (stack.size() > 1) {
                if (stack.peek() > num) {
                    stack.push(num);
                    sb.append(indexStack.peek()).append(" ");
                    indexStack.push(i);
                    break;
                } else {
                    stack.pop();
                    indexStack.pop();
                }
            }

            if (stack.peek() == 0) {
                sb.append(0).append(" ");
                indexStack.push(i);
                stack.push(num);
            }
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
