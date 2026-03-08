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
        int[] array = new int[1000001];
        array[1] = 0;

        for (int i = 2; i <= n; i++) {
            array[i] = array[i - 1] + 1;
            if (i % 2 == 0) {
                array[i] = Math.min(array[i], array[i / 2] + 1);
            }
            if (i % 3 == 0) {
                array[i] = Math.min(array[i], array[i / 3] + 1);
            }
        }

        bufferedWriter.write(String.valueOf(array[n]));
        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}