import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
import org.w3c.dom.Node;

public class Main {

    static int m;
    static int n;
    static int h;
    static int[][][] array;
    static Queue<Node> queue;
    static boolean[][][] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        m = Integer.parseInt(stringTokenizer.nextToken());
        n = Integer.parseInt(stringTokenizer.nextToken());
        h = Integer.parseInt(stringTokenizer.nextToken());
        array = new int[h][n][m];
        isVisited = new boolean[h][n][m];
        queue = new ArrayDeque<>();

        // z
        for (int i = 0; i < h; i++) {
            // x
            for (int j = 0; j < n; j++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                // y
                for (int k = 0; k < m; k++) {
                    int number = Integer.parseInt(stringTokenizer.nextToken());
                    array[i][j][k] = number;

                    if (number == 1) {
                        queue.add(new Node(j, k, i, 0));
                        isVisited[i][j][k] = true;
                    }
                }
            }
        }

        int result = bfs();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (array[i][j][k] == 0) {
                        result = -1;
                        break;
                    }
                }
            }
        }

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }

    static int bfs() {
        int[] dx = {-1, 0, 1, 0, 0, 0};
        int[] dy = {0, 1, 0, -1, 0, 0};
        int[] dz = {0, 0, 0, 0, 1, -1};

        int max = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < 6; i++) {
                int x = node.x + dx[i];
                int y = node.y + dy[i];
                int z = node.z + dz[i];

                if (x < 0 || x >= n || y < 0 || y >= m || z < 0 || z >= h) {
                    continue;
                }

                if (array[z][x][y] == -1) {
                    isVisited[z][x][y] = true;
                    continue;
                }

                if (isVisited[z][x][y]) {
                    continue;
                }

                array[z][x][y] = 1;
                isVisited[z][x][y] = true;
                queue.add(new Node(x, y, z, node.distance + 1));

                if (node.distance + 1 > max) {
                    max = node.distance + 1;
                }
            }
        }

        return max;
    }

    static class Node {
        int x;
        int y;
        int z;
        int distance;

        public Node(int x, int y, int z, int distance) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.distance = distance;
        }
    }
}