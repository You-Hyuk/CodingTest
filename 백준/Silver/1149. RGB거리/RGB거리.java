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
        StringTokenizer stringTokenizer;

        int n = Integer.parseInt(bufferedReader.readLine());
        int[][] cost = new int[1001][3];
        int[][] min = new int[1001][3];

        for (int i = 1; i <= n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        min[1][0] = cost[1][0];
        min[1][1] = cost[1][1];
        min[1][2] = cost[1][2];

        for (int i = 2; i <= n; i++) {
            min[i][0] = Math.min(min[i - 1][1], min[i - 1][2]) + cost[i][0];
            min[i][1] = Math.min(min[i - 1][0], min[i - 1][2]) + cost[i][1];
            min[i][2] = Math.min(min[i - 1][0], min[i - 1][1]) + cost[i][2];
        }

        bufferedWriter.write(String.valueOf(Math.min(Math.min(min[n][0], min[n][1]), min[n][2])));
        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}