import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] ropes = new int[n];
        int result = 0;

        for (int i = 0; i < n; i++) {
            ropes[i] = Integer.parseInt(bufferedReader.readLine());
        }

        Arrays.sort(ropes);

        for (int i = 1; i <= n; i++) {
            result = Math.max(result, ropes[n - i] * i);
        }

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}
