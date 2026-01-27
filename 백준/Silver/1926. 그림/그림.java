import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[][] array;
    static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        StringTokenizer stringTokenizer = new StringTokenizer(input);

        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());

        array = new int[n][m];
        isVisited = new boolean[n][m];

        ArrayList<Integer> size = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                array[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (array[i][j] == 1 && !isVisited[i][j])
                    size.add(bfs(i, j));
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(size.size())
                .append("\n")
                .append(size.stream().max(Comparator.naturalOrder()).orElse(0));

        bw.write(stringBuilder.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    static int bfs(int startX, int startY) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<int[]> queue = new ArrayDeque<>();
        int[] startNode = {startX, startY};
        queue.offer(startNode);
        isVisited[startX][startY] = true;

        int size = 1;

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = node[0] + dx[i];
                int y = node[1] + dy[i];

                if (x < 0 || x >= n || y < 0 || y >= m) {
                    continue;
                }

                if (array[x][y] == 0 || isVisited[x][y]) {
                    continue;
                }

                isVisited[x][y] = true;
                size++;
                queue.add(new int[]{x, y});
            }
        }

        return size;
    }
}
