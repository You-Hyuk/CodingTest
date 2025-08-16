package barkingdog.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BOJ6198 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Long count = Long.parseLong(br.readLine());
        Stack<Long> stack = new Stack<>();
        Long result = 0L;

        for (int i = 1; i <= count; i++) {
            Long h = Long.parseLong(br.readLine());

            while (!stack.isEmpty()) {
                // Peek 값이 입력보다 더 큰 경우, 스택의 크기만큼 Result를 더한다.
                if (stack.peek() > h) {
                    result += stack.size();
                    stack.push(h);
                    break;
                }
                // Peek 값이 입력보다 작거나 같은 경우 POP 한다. 즉 스택 가장 아래에 있는 숫자가 제일 큰 숫자이다.
                else {
                    stack.pop();
                }
            }

            if (stack.isEmpty()) {
                stack.push(h);
            }
        }

        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
        br.close();
    }
}
