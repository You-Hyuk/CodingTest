package barkingdog.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

class Num {
    long value;
    long cnt;

    public Num(long value, long cnt) {
        this.value = value;
        this.cnt = cnt;
    }
}
public class BOJ3015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(br.readLine());
        long result = 0L;
        Stack<Num> stack = new Stack<>();

        for (int i = 0; i < count; i++) {
            long h = Long.parseLong(br.readLine());
            Num num = new Num(h, 1);

            while (!stack.isEmpty()) {
                if (stack.peek().value < num.value) {
                    result += stack.peek().cnt;
                    stack.pop();
                } else if (stack.peek().value == num.value) {
                    result += stack.peek().cnt;
                    stack.peek().cnt++;
                    num = stack.pop();
                } else {
                    result++;
                    break;
                }
            }

            stack.push(num);

        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}
