import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BOJ4949{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true) {
            String str = br.readLine();
            if(str.equals(".")) {
                break;
            } else {
                bw.write(validate(str) + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static String validate(String str) {
        boolean hasError = false;
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '(') {
                stack.push('(');
            }

            if (c == '[') {
                stack.push('[');
            }

            if (c == ')') {
                if(stack.empty() || stack.peek() == '[') {
                    hasError = true;
                    break;
                } else {
                    stack.pop();
                }
            }

            if (c == ']') {
                if(stack.empty() || stack.peek() == '(') {
                    hasError = true;
                    break;
                } else {
                    stack.pop();
                }
            }
        }

        if (!stack.empty() || hasError) {
            return "no";
        } else {
            return "yes";
        }
    }
}
