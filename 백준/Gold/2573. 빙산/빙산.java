import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[][] array;
    static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());
        array = new int[n][m];

        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < m; j++) {
                array[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        int year = 0;

        while (true) {
            isVisited = new boolean[n][m];
            int count = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    // bfs가 새롭게 호출 -> 빙산이 나누어져 있음
                    if (array[i][j] != 0 && !isVisited[i][j]) {
                        bfs(new Node(i, j));
                        count++;
                    }
                }
            }

            if (count == 0) {
                year = 0;
                break;
            } else if (count >= 2) {
                break;
            }

            year++;
        }

        bufferedWriter.write(String.valueOf(year));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    // 0이 아닌 경우에만 큐에 넣고 상하좌우로 이동했을 때 0이라면 이전 노드 -1
    static void bfs(Node startNode) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(startNode);
        isVisited[startNode.x][startNode.y] = true;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int x = node.x + dx[i];
                int y = node.y + dy[i];

                if (x < 0 || x >= n || y < 0 || y >= m) {
                    continue;
                }

                if (isVisited[x][y]) {
                    continue;
                }

                // 현재 노드가 0인 경우, 이전 빙산의 값을 -1
                if (array[x][y] == 0) {
                    array[node.x][node.y] = Math.max(0, array[node.x][node.y] - 1);
                    continue;
                }

                queue.add(new Node(x, y));
                isVisited[x][y] = true;
            }
        }
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}