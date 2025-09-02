package barkingdog.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ1926 {

    static int[][] array;
    static boolean[][] isVisited;
    static int n;
    static int m;
    static int count = 0;
    static int max = 0;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        array = new int[n][m];
        isVisited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (array[i][j] == 1 && !isVisited[i][j]) {
                    max = Math.max(max, bfs(i, j, array, isVisited));
                    count++;
                }
            }
        }

        bw.write(String.valueOf(count));
        bw.write("\n");
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
        br.close();
    }

    static int bfs(int cx, int cy, int[][] array, boolean[][] isVisited) {
        Queue<int[]> queue = new ArrayDeque<>();
        int[] startNode = {cx, cy};
        int size = 1;
        isVisited[cx][cy] = true;

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        queue.offer(startNode);

        while (!queue.isEmpty()) {
            int[] node = queue.poll();

            for (int i = 0; i < 4; i++) {

                int x = node[0] + dx[i];
                int y = node[1] + dy[i];

                int[] newNode = {x, y};

                if (x < 0 || x >= n || y < 0 || y >= m) {
                    continue;
                }

                if (isVisited[x][y]) {
                    continue;
                }

                if (array[x][y] == 1) {
                    size++;
                    isVisited[x][y] = true;
                    queue.offer(newNode);
                }
            }
        }

        return size;
    }
}
