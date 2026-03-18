import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] a;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder stringBuilder = new StringBuilder();

        n = Integer.parseInt(bufferedReader.readLine());
        a = new int[n];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(a);

        int m = Integer.parseInt(bufferedReader.readLine());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < m; i++) {
            stringBuilder.append(function(Integer.parseInt(stringTokenizer.nextToken()))).append("\n");
        }

        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }

    static int function(int target) {
        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int index = (start + end) / 2;
            int search = a[index];

            if (target < search) {
                end = index - 1;
            }
            if (target > search) {
                start = index + 1;
            }
            if (target == search) {
                return 1;
            }
        }

        return 0;
    }
}