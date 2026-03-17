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

        bufferedWriter.write(countPrime(
                        Integer.parseInt(stringTokenizer.nextToken()),
                        Integer.parseInt(stringTokenizer.nextToken())
                ));
        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }

    static String countPrime(int start, int end) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean[] states = new boolean[end + 1];
        for (int i = 0; i <= end; i++) {
            states[i] = true;
        }
        states[1] = false;

        for (int i = 2; i * i <= end; i++) {
            if (!states[i]) {
                continue;
            }

            for (int j = i * i; j <= end; j += i) {
                states[j] = false;
            }
        }

        for (int i = start; i <= end; i++) {
            if (states[i]) {
                stringBuilder.append(i).append("\n");
            }
        }

        return stringBuilder.toString();
    }
}