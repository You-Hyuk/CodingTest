package barkingdog.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

class Number {
    int value;
    int index;

    public Number(int value, int index) {
        this.value = value;
        this.index = index;
    }
}
public class BOJ17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(br.readLine());
        Stack<Number> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] result = new int[count];
        StringBuilder sb = new StringBuilder();

        for (int index = 0; index < count; index++) {
            int num = Integer.parseInt(st.nextToken());

            Number number = new Number(num, index);

            // 자신의 오큰수를 찾은 경우 리스트에 자신의 인덱스에 해당하는 오큰수를 추가한 뒤 POP 한다.
            while (!stack.isEmpty()) {
                if (stack.peek().value >= num) {
                    stack.push(number);
                    break;
                } else {
                    result[stack.pop().index] = num;
                }
            }

            if (stack.isEmpty()) {
                stack.push(number);
            }
        }

        for (Integer i : result) {
            if (i == 0) {
                i = -1;
            }
            sb.append(i).append(" ");
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
