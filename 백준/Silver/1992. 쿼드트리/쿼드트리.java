import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static int[][] array;
    static StringBuilder result;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bufferedReader.readLine());

        array = new int[n][n];
        result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String line = bufferedReader.readLine();
            for (int j = 0; j < n; j++) {
                array[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }

        recursive(n, 0, 0);

        bufferedWriter.write(result.toString());
        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }

    static void recursive(int n, int x, int y) {
        int init = array[x][y];
        boolean hasDifferent = false;

        if (n == 0) {
            result.append(init);
            return;
        }

        for (int i = x; i < n + x; i++) {
            for (int j = y; j < n + y; j++) {
                if (array[i][j] != init) {
                    hasDifferent = true;
                    break;
                }
            }

            if (hasDifferent) {
                break;
            }
        }

        // 4등분 후 각각 재귀
        if (hasDifferent) {
            result.append("(");
            recursive(n / 2, x, y);
            recursive(n / 2, x , y + (n / 2));
            recursive(n / 2, x + (n / 2), y);
            recursive(n / 2, x + (n / 2), y + (n / 2));
            result.append(")");
            return;
        }

        result.append(init);
    }
}