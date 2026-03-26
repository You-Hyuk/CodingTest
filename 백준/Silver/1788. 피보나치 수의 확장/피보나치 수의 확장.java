import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] dp = new int[1000001];

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= Math.abs(n); i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000000;
        }

        int abs = 0;
        int result = 0;

        if (n >= 1) {
            abs = 1;
            result = dp[n];
        } else if (n <= -1) {
            if (Math.abs(n) % 2 == 0) {
                abs = -1;
            } else {
                abs = 1;
            }
            result = dp[Math.abs(n)];
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(abs).append("\n").append(result);

        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}