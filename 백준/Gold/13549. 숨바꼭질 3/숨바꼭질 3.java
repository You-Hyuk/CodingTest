import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        array = new int[200000];

        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());

        int result = bfs();

        if (n == m) {
            result = 0;
        }

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }

     static int bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(n);

        int[] dx = {-1, 0, 1};

        while (!queue.isEmpty()) {
            Integer number = queue.poll();

            for (int i = 0; i < 3; i++) {
                int move = number + dx[i];

                if (i == 1) {
                    move = 2 * number;
                }

                if (move < 0 || move > 100005 || array[move] > 0) {
                    continue;
                }

                if (i == 1) {
                    array[move] = array[number];
                } else {
                    array[move] = array[number] + 1;
                }

                if (move == m) {
                    return array[m];
                }

                queue.add(move);
            }
        }
        return -1;
    }
}