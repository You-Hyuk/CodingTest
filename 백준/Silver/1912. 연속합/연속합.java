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
        int n = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int[] numbers = new int[n + 1];
        int[] dp = new int[n + 1];

        int max = Integer.parseInt(stringTokenizer.nextToken());
        numbers[1] = max;

        for (int i = 2; i <= n; i++) {
            int number = Integer.parseInt(stringTokenizer.nextToken());
            numbers[i] = number;

            if (number > max) {
                max = number;
            }
        }

        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            int sum = numbers[i] + dp[i - 1];

            dp[i] = Math.max(sum, 0);

            if (sum > max) {
                max = sum;
            }
        }

        bufferedWriter.write(String.valueOf(max));
        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}