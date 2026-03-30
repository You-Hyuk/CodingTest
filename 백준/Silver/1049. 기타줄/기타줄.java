import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int result = 0;
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        int minBundlePrice = Integer.MAX_VALUE;
        int minSinglePrice = Integer.MAX_VALUE;

        for (int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            minBundlePrice = Math.min(minBundlePrice, Integer.parseInt(stringTokenizer.nextToken()));
            minSinglePrice = Math.min(minSinglePrice, Integer.parseInt(stringTokenizer.nextToken()));
        }

        while (n > 0) {
            int bundleSize = n / 6;
            if (bundleSize > 0) {
                result += Math.min(minSinglePrice * 6 * bundleSize, minBundlePrice * bundleSize);
                n -= 6 * bundleSize;
            } else {
                int reminder = n % 6;
                result += Math.min(minSinglePrice * reminder, minBundlePrice);
                break;
            }
        }

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }

}