import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ28278 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int i = 0;
        Stack<Integer> stack = new Stack<Integer>();

        while (i < n) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            switch (num) {
                case 1 :
                    int input = Integer.parseInt(st.nextToken());
                    stack.push(input);
                    break;
                case 2:
                    if (!stack.empty()) {
                        bw.write(String.valueOf(stack.pop()));
                        bw.write("\n");
                    } else {
                        bw.write(String.valueOf(-1));
                        bw.write("\n");

                    }
                    break;
                case 3:
                    bw.write(String.valueOf(stack.size()));
                    bw.write("\n");

                    break;
                case 4:
                    if (stack.isEmpty()) {
                        bw.write(String.valueOf(1));
                        bw.write("\n");

                    } else {
                        bw.write(String.valueOf(0));
                        bw.write("\n");

                    }
                    break;
                case 5:
                    if (!stack.isEmpty()) {
                        bw.write(String.valueOf(stack.peek()));
                        bw.write("\n");

                    }else {
                        bw.write(String.valueOf(-1));
                        bw.write("\n");

                    }
                    break;
            }
            i++;
        }

        bw.flush();
        bw.close();
    }

}

