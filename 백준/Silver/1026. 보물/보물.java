import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer;
        int[] a = new int[n];
        int[] b = new int[n];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(a);
        Arrays.sort(b);

        int result = 0;

        for (int i = 0; i < n; i++) {
            result += a[i] * b[n - i - 1];
        }

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}