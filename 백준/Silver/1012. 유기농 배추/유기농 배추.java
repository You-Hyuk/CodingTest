import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    static int m;
    static int n;
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        int testCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCount; i++) {
            String str = br.readLine();
            String[] split = str.split(" ");
            int count = 0;

            //열 개수
            m = Integer.parseInt(split[0]);

            //행 개수
            n = Integer.parseInt(split[1]);

            //배추 위치 개수
            k = Integer.parseInt(split[2]);

            int[][] array = new int[m][n];
            boolean[][] isVisited = new boolean[m][n];

            for (int j = 0; j < k; j++) {
                str = br.readLine();
                split = str.split(" ");

                int x = Integer.parseInt(split[0]);
                int y = Integer.parseInt(split[1]);

                array[x][y] = 1;
            }

            for (int x = 0; x < m; x++) {
                for (int y = 0; y < n; y++) {
                    if (array[x][y] == 1 && !isVisited[x][y]) {
                        count++;
                        bfs(array, isVisited, x, y);
                    }
                }
            }

            result.append(count).append("\n");
            count = 0;
        }

        bw.write(result.toString());
        bw.close();
        br.close();
    }

    static void bfs(int[][] array, boolean[][] isVisited, int currentX, int currentY) {
        Queue<Integer[]> queue = new ArrayDeque<>();
        queue.add(new Integer[]{currentX, currentY});
        isVisited[currentX][currentY] = true;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            Integer[] node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int x = node[0] + dx[i];
                int y = node[1] + dy[i];

                if (x < 0 || x >= m || y < 0 || y >= n) {
                    continue;
                }

                if (array[x][y] == 0 || isVisited[x][y]) {
                    continue;
                }

                isVisited[x][y] = true;
                queue.add(new Integer[]{x, y});
            }
        }
    }
}