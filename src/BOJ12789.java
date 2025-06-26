import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ12789 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int lastIndex = 1;
        boolean flag = false;

        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            while (true) {
                // 첫 대기중인 줄에서 순서가 일치하는 경우
                if (num == lastIndex) {
                    lastIndex++;
                    break;
                }
                // 사이 대기 줄에서 순서가 일치하는 경우
                else if (!stack.empty() && stack.peek() == lastIndex) {
                    stack.pop();
                    lastIndex++;
                } else {
                    stack.push(num);
                    break;
                }
            }
        }

        while (!stack.empty()) {
            if (stack.peek() == lastIndex) {
                stack.pop();
                lastIndex++;
            } else {
                flag = true;
                break;
            }
        }

        if(flag) {
            bw.write("Sad");
        } else {
            bw.write("Nice");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}