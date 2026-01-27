import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCount = Integer.parseInt(br.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < testCount; i++) {
            int size = Integer.parseInt(br.readLine());
            int[][] array = new int[size][size];
            boolean[][] isVisited = new boolean[size][size];
            int[][] distance = new int[size][size];

            String string = br.readLine();
            String[] split = string.split(" ");
            int startX = Integer.parseInt(split[0]);
            int startY = Integer.parseInt(split[1]);

            string = br.readLine();
            split = string.split(" ");
            int targetX = Integer.parseInt(split[0]);
            int targetY = Integer.parseInt(split[1]);

            int count = bfs(array, isVisited, startX, startY, targetX, targetY, size, distance);
            stringBuilder.append(count).append("\n");
        }

        bw.write(stringBuilder.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static int bfs(int[][] array, boolean[][] isVisited, int startX, int startY, int targetX, int targetY, int size, int[][] distance) {
        if (startX == targetX && startY == targetY) {
            return 0;
        }

        Queue<Integer[]> queue = new ArrayDeque<>();
        queue.offer(new Integer[]{startX, startY});
        isVisited[startX][startY] = true;
        int[] dx = {-2, -1, -2, -1, 1, 2, 1, 2};
        int[] dy = {-1, -2, 1, 2, -2, -1, 2, 1};

        distance[startX][startY] = 0;

        while (distance[targetX][targetY] == 0) {
            if (queue.isEmpty()) {
                break;
            }

            Integer[] node = queue.poll();

            for (int i = 0; i < 8; i++) {
                int x = node[0] + dx[i];
                int y = node[1] + dy[i];

                if (x == targetX && y == targetY) {
                    distance[x][y] = distance[node[0]][node[1]] + 1;
                    break;
                }

                if (x < 0 || x >= size || y < 0 || y >= size) {
                    continue;
                }

                if (isVisited[x][y]) {
                    continue;
                }

                isVisited[x][y] = true;
                distance[x][y] = distance[node[0]][node[1]] + 1;
                queue.offer(new Integer[]{x, y});
            }
        }

        return distance[targetX][targetY];
    }
}