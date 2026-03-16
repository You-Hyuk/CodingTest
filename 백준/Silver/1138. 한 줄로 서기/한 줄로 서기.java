import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder stringBuilder = new StringBuilder();
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] array = new int[n + 1];
        int[] result = new int[n + 1];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 1; i <= n; i++) {
            array[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            //i번째 사람의 왼쪽에 있는 수
            int num = array[i];
            int count = 0;

            //왼쪽에 있어야 하는 사람 수 만큼 0을 할당한 뒤에 가장 왼쪽에 있는 곳에 들어간다
            for (int j = 1; j <= n; j++) {
                if (count < num && result[j] == 0) {
                    count++;
                } else if (count == num && result[j] == 0) {
                    result[j] = i;
                    break;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            stringBuilder.append(result[i]).append(" ");
        }

        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}
