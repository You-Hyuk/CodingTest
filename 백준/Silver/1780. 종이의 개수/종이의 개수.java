import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int[][] array;
    static Map<Integer, Integer> result = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer;

        array = new int[n][n];

        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < n; j++) {
                array[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        recursion(n, 0, 0);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(result.getOrDefault(-1, 0))
                .append("\n")
                .append(result.getOrDefault(0, 0))
                .append("\n")
                .append(result.getOrDefault(1, 0));

        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }

    static void recursion(int size, int x, int y) {
        int initValue = array[x][y];
        boolean hasDifferent = false;

        // 배열에 다른 값이 있는 경우 검증
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (initValue != array[i][j]) {
                    hasDifferent = true;
                    break;
                }
            }
            if (hasDifferent) {
                break;
            }
        }

        if (!hasDifferent || size == 1) {
            result.put(initValue, result.getOrDefault(array[x][y], 0) + 1);
            return;
        }

        // 다른 값이 있는 경우 9등분 후 재귀
        for (int i = 0; i < size; i += size / 3) {
            for (int j = 0; j < size; j += size / 3) {
                recursion(size / 3, x + i, y + j);
            }
        }
    }
}