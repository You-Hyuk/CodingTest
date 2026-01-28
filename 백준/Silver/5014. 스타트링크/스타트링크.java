import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int f;
    static int s;
    static int g;
    static int u;
    static int d;
    static int[] array;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        f = Integer.parseInt(stringTokenizer.nextToken());
        s = Integer.parseInt(stringTokenizer.nextToken());
        g = Integer.parseInt(stringTokenizer.nextToken());
        u = Integer.parseInt(stringTokenizer.nextToken());
        d = Integer.parseInt(stringTokenizer.nextToken());

        array = new int[f + 1];
        array[s] = 0;
        isVisited = new boolean[f + 1];
        isVisited[s] = true;
        isVisited[0] = true;

        int result = bfs();

        if (result == -1) {
            bufferedWriter.write("use the stairs");
        } else {
            bufferedWriter.write(String.valueOf(result));
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    static int bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(s);

        int[] moves = {u, -1 * d};

        while (!queue.isEmpty()) {
            Integer currentPosition = queue.poll();

            if (currentPosition == g) {
                return array[currentPosition];
            }

            for (int move : moves) {
                int position = currentPosition + move;

                if (position < 1 || position > f) {
                    continue;
                }

                if (isVisited[position]) {
                    continue;
                }

                array[position] = array[currentPosition] + 1;
                isVisited[position] = true;
                queue.offer(position);
            }
        }

        return -1;
    }
}