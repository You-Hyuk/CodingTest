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

        int a = Integer.parseInt(stringTokenizer.nextToken());
        int b = Integer.parseInt(stringTokenizer.nextToken());
        int c = Integer.parseInt(stringTokenizer.nextToken());

        bufferedWriter.write(String.valueOf(fun(a, b, c)));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    static long fun(int a, int b, int c) {
        if (b == 1) {
            return a % c;
        }
        long value = fun(a, b / 2, c);
        value = value * value % c;
        if (b % 2 == 0) {
            return value;
        }
        return value * a % c;
    }
}