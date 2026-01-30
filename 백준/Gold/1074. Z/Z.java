import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int[][] array;
    static int r;
    static int c;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        r = Integer.parseInt(stringTokenizer.nextToken());
        c = Integer.parseInt(stringTokenizer.nextToken());

        bufferedWriter.write(String.valueOf(recursive(n, r, c)));
        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }

    static int recursive(int n, int r, int c) {
        if (n == 0) {
            return 0;
        }

        int half = (int) Math.pow(2, n - 1);

        if (r < half && c < half) {
            return recursive(n - 1, r, c);
        }

        if (r < half && c >= half) {
           return half * half + recursive(n - 1, r, c - half);
        }

        if (r >= half && c < half) {
            return 2 * half * half + recursive(n - 1, r - half, c);
        }

        return 3 * half * half + recursive(n - 1, r - half, c - half);
    }
}