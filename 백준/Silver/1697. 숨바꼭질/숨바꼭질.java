import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static boolean[] isVisited;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());

        distance = new int[200000];
        isVisited = new boolean[200000];
        Arrays.fill(distance, -1);

        bfs(n, m);

        bw.write(String.valueOf(distance[m + 1]));
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int start, int end) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        distance[start + 1] = 0;

        while (distance[end + 1] == -1) {
            Integer node = queue.poll();
            int[] move = {node + 1, node - 1, node * 2};

            for (int x : move) {
                if (x < 0 || x > 100000 || isVisited[x + 1]) {
                    continue;
                }

                distance[x + 1] = distance[node + 1] + 1;
                isVisited[x + 1] = true;
                queue.offer(x);
            }
        }
    }

}