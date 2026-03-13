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
        Item[] items = new Item[n + 1];

        int[][] dp = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int w = Integer.parseInt(stringTokenizer.nextToken());
            int v = Integer.parseInt(stringTokenizer.nextToken());
            items[i] = new Item(w, v);
        }

        // i -> 아이템 인덱스
        for (int i = 1; i <= n; i++) {
            Item item = items[i];
            for (int j = 1; j <= k; j++) {
                if (item.w > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - item.w] + item.v);
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (dp[i][k] > max) {
                max = dp[i][k];
            }
        }

        bufferedWriter.write(String.valueOf(max));
        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }

    static class Item {
        int w;
        int v;

        public Item(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }
}
