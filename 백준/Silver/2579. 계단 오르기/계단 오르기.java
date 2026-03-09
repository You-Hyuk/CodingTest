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
        int[] stairs = new int[305];
        int[][] scores = new int[305][3];

        for (int i = 1; i <= n; i++) {
            stairs[i] = Integer.parseInt(bufferedReader.readLine());
        }

        stairs[0] = 0;
        scores[0][1] = 0;
        scores[0][2] = 0;
        scores[1][1] = stairs[1];
        scores[1][2] = 0;
        scores[2][1] = stairs[2];
        scores[2][2] = scores[1][1] + stairs[2];

        if (n >= 3) {
            for (int i = 3; i <= n; i++) {
                scores[i][1] = Math.max(scores[i - 2][1], scores[i - 2][2]) + stairs[i];
                scores[i][2] = scores[i - 1][1] + stairs[i];
            }
        }

        bufferedWriter.write(String.valueOf(Math.max(scores[n][1], scores[n][2])));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
