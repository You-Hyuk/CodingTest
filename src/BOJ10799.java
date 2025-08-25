import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BOJ10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        int lazerCount = 0;
        boolean isLazer = false;
        int result = 0;

        for (int i = 0; i < str.length(); i++) {
            char first = str.charAt(i);


            //괄호쌍인 경우
            if (first == '(') {
                char second = str.charAt(i + 1);

                if (second == ')') {
                    result += stack.size();
                    i++;
                } else {
                    stack.push(first);
                }
            }
            else if (first == ')') {
                result++;
                stack.pop();
            }

        }

        bw.write(String.valueOf(result));


        bw.flush();
        bw.close();
        br.close();
    }
}
