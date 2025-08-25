package barkingdog.bracket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BOJ3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i = 0; i < count; i++) {
            String str = br.readLine();
            Stack<Character> stack = new Stack<>();

            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);

                if (stack.isEmpty()) {
                    stack.push(c);
                    continue;
                }

                if (stack.peek() == 'A' && c == 'A') {
                    stack.pop();
                } else if (stack.peek() == 'B' && c == 'B') {
                    stack.pop();
                } else if (stack.peek() == 'A' && c == 'B') {
                    stack.push(c);
                } else if (stack.peek() == 'B' && c == 'A') {
                    stack.push(c);
                }
            }

            if (stack.empty()) {
                result++;
            }
        }

        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
        br.close();
    }
}
