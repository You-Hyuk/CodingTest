import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int k = Integer.parseInt(stringTokenizer.nextToken());

        bufferedWriter.write(String.valueOf(combination(n, k)));
        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }

    static int combination(int n, int k) {
        int up = 1;
        int down = 1;

        if (n == k || k == 0) {
            return 1;
        }

        for (int i = n - k + 1; i <= n; i++) {
            up *= i;
        }

        for (int i = 1; i <= k; i++) {
            down *= i;
        }

        return up / down;
    }
}