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

        long[][] dp = new long[95][2];
        dp[1][0] = 1;
        dp[1][1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i][1] = dp[i - 1][0];
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
        }

        bufferedWriter.write(String.valueOf(dp[n][1]));
        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}