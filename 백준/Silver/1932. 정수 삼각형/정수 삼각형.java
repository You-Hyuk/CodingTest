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
        StringTokenizer stringTokenizer;

        int n = Integer.parseInt(bufferedReader.readLine());
        int[][] num = new int[n + 1][n + 1];
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 1; j <= i; j++) {
                num[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        dp[1][1] = num[1][1];

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                // 좌측
                if (j == 1) {
                    dp[i][j] = dp[i - 1][1] + num[i][1];
                    continue;
                }
                // 우측
                if (i == j) {
                    dp[i][j] = dp[i - 1][i - 1] + num[i][j];
                    continue;
                }
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + num[i][j];
            }
        }

        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (dp[n][i] > result) {
                result = dp[n][i];
            }
        }

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}