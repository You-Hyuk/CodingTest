import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder stringBuilder = new StringBuilder();

        int n = Integer.parseInt(bufferedReader.readLine());

        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                stringBuilder.append(i).append("\n");
                n /= i;
            }
        }

        if (n != 1) {
            stringBuilder.append(n);
        }

        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}