import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        Stack<String> stack = new Stack<>();
        boolean flag = false;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            int size = input.length();

            for (int j = 0; j < size; j++) {
                if (input.charAt(j) == '(') {
                    stack.push("(");
                } else {
                    if (stack.empty()) {
                        bw.write("NO\n");
                        flag = true;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }

            if (!flag) {
                if (stack.empty()) {
                    bw.write("YES\n");
                } else {
                    bw.write("NO\n");
                }
            }
            stack.clear();
            flag = false;
        }

        bw.flush();
        bw.close();

    }
}
