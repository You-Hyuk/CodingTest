package barkingdog.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2178 {

    static int n;
    static int m;
    static int[][] array;
    static boolean[][] isVisited;
    static int[][] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        array = new int[n][m];
        isVisited = new boolean[n][m];
        distance = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            for (int j = 0; j < m; j++) {
                array[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }

        bfs(array, isVisited);
        int result = distance[n - 1][m - 1];

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();

    }

    static void bfs(int[][] array, boolean[][] isVisited) {
        Queue<int[]> queue = new ArrayDeque<>();

        isVisited[0][0] = true;
        queue.add(new int[]{0, 0});

        distance[0][0] = 1;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            int[] node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = node[0] + dx[i];
                int ny = node[1] + dy[i];

                int[] newNode = {nx, ny};

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (array[nx][ny] == 0 || isVisited[nx][ny]) {
                    continue;
                }

                isVisited[nx][ny] = true;

                int newDistance = distance[node[0]][node[1]] + 1;

                if (distance[nx][ny] == 0) {
                    distance[nx][ny] = newDistance;
                } else if (distance[nx][ny] > newDistance && newDistance != 0) {
                    distance[nx][ny] = newDistance;
                }

                queue.add(newNode);
            }
        }

    }
}
