import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int m;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];
        boolean isPossible = true;
        Queue<int[]> queue = new ArrayDeque<>();
        int maxDays = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());

                if (num == 1) {
                    queue.add(new int[]{i, j});
                }
                board[i][j] = num;
            }
        }

        bfs(queue, board);

        for (int[] ints : board) {
            for (int anInt : ints) {
                if (anInt == 0) {
                    isPossible = false;
                    break;
                }
                if (maxDays < anInt) {
                    maxDays = anInt;
                }
            }
        }

        if (isPossible) {
            bw.write(String.valueOf(maxDays - 1));
        } else {
            bw.write("-1");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(Queue<int[]> queue, int[][] board) {

        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};

        while (!queue.isEmpty()) {
            int[] node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = node[0] + dx[i];
                int ny = node[1] + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (board[nx][ny] == 0) {
                    board[nx][ny] = board[node[0]][node[1]] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }
}
