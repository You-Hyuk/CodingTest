import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {

    static int n;
    static char[][] array;
    static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(bufferedReader.readLine());

        array = new char[n][n];
        isVisited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String string = bufferedReader.readLine();
            for (int j = 0; j < n; j++) {
                array[i][j] = string.charAt(j);
            }
        }

        int result1 = 0;
        int result2 = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!isVisited[i][j]) {
                    result1++;
                }
                bfs(i, j);
            }
        }

        isVisited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (array[i][j] == 'G') {
                    array[i][j] = 'R';
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!isVisited[i][j]) {
                    result2++;
                }
                bfs(i, j);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(result1).append(" ").append(result2);
        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    static void bfs(int startX, int startY) {
        Queue<Integer[]> queue = new ArrayDeque<>();
        queue.offer(new Integer[]{startX, startY});
        isVisited[startX][startY] = true;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            Integer[] node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = node[0] + dx[i];
                int y = node[1] + dy[i];

                if (x < 0 || x >= n || y < 0 || y >= n) {
                    continue;
                }

                if (array[node[0]][node[1]] != array[x][y] || isVisited[x][y]) {
                    continue;
                }

                isVisited[x][y] = true;
                queue.offer(new Integer[]{x, y});
            }
        }
    }
}