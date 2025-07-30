package practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();

        int k = Integer.parseInt(st.nextToken());
        int i = 0;
        while (i < k){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            if (num != 0) {
                stack.push(num);
            } else {
                stack.pop();
            }
            i++;
        }

        int sum = 0;
        for (Integer integer : stack) {
            sum += integer;
        }

        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}
