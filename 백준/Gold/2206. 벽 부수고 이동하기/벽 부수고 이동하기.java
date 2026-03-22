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

    static int n;
    static int m;
    static int[][] array;
    static int[][] state;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());

        array = new int[n][m];
        state = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = bufferedReader.readLine();
            for (int j = 0; j < m; j++) {
                array[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }

        int result = bfs();

        if (n == 1 && m == 1) {
            result = 1;
        }

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    static int bfs() {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0, 0, 1, false));

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int x = node.x + dx[i];
                int y = node.y + dy[i];
                boolean destroy = node.destroy;

                if (x < 0 || x >= n || y < 0 || y >= m) {
                    continue;
                }

                if (x == n - 1 && y == m - 1) {
                    return node.distance + 1;
                }

                // 부순 적 없이 방문한 경우 1, 부순 적 있는 경우 -1, 자니지 않은 경우 0
                if (state[x][y] == -1) {
                    if (!destroy) {
                        state[x][y] = 1;
                    } else {
                        continue;
                    }
                } else if (state[x][y] == 1) {
                    continue;
                } else if (state[x][y] == 0) {
                    if (destroy) {
                        state[x][y] = -1;
                    } else {
                        state[x][y] = 1;
                    }
                }

                if (array[x][y] == 1) {
                    if (destroy) {
                        continue;
                    } else {
                        destroy = true;
                    }
                }

                queue.add(new Node(x, y, node.distance + 1, destroy));
            }
        }

        return -1;
    }

    static class Node {
        int x;
        int y;
        int distance;
        boolean destroy;

        public Node(int x, int y, int distance, boolean destroy) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.destroy = destroy;
        }
    }
}