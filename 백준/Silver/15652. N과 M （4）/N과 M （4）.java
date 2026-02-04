import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static int n;
    static int m;
    static int[] array;
    static StringBuilder stringBuilder;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        stringBuilder = new StringBuilder();
        String[] split = bufferedReader.readLine().split(" ");

        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);

        array = new int[10];
        max = 0;

        func(0);

        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.close();
        bufferedReader.close();
    }

    static void func(int k) {
        if (k == m) {
            for (int i = 0; i < m; i++) {
                stringBuilder.append(array[i]).append(" ");
            }
            stringBuilder.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (i >= max) {
                max = i;
                array[k] = i;
                func(k + 1);
                max = 0;
                array[k] = 0;
            }
        }
    }
}