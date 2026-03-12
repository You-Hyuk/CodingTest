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
        int[] coins = new int[n];
        int endIndex = 0;
        int result = 0;

        for (int i = 0; i < n; i++) {
            int coin = Integer.parseInt(bufferedReader.readLine());
            if (coin > k) {
                break;
            }
            coins[i] = coin;
            endIndex++;
        }

        endIndex--;

        while (k != 0) {
            int num = k / coins[endIndex];
            if (num > 0) {
                result += num;
                k %= coins[endIndex];
            }
            endIndex--;
        }

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}