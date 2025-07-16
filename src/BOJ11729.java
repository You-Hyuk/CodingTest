import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ11729 {

    static int count = 0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        recursive(n, 1, 3, 2);

        bw.write(String.valueOf(count));
        bw.write("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    // num개의 원반을 start로부터 end까지 옮긴다.
    static void recursive(int num, int start, int end, int sub) {
        count++;

        if (num == 1) {
            sb.append(start).append(" ").append(end).append("\n");
            return;
        }

        recursive(num - 1, start, sub, end);
        sb.append(start).append(" ").append(end).append("\n");
        recursive(num - 1, sub, end, start);

    }
}
