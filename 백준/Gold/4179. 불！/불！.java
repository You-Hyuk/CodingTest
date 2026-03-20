import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int r;
    static int c;
    static char[][] array;
    static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        r = Integer.parseInt(stringTokenizer.nextToken());
        c = Integer.parseInt(stringTokenizer.nextToken());

        array = new char[r][c];
        isVisited = new boolean[r][c];
        Node startNode = new Node(0, 0, 0);
        List<Node> fireNodes = new ArrayList<>();

        for (int i = 0; i < r; i++) {
            String line = bufferedReader.readLine();
            for (int j = 0; j < c; j++) {
                char input = line.charAt(j);
                array[i][j] = input;

                if (input == 'J') {
                    startNode = new Node(i, j, 0);
                }
                if (input == 'F') {
                    fireNodes.add(new Node(i, j, 0));
                }
            }
        }

        int result = bfs(startNode, fireNodes);

        if (result == 0) {
            bufferedWriter.write("IMPOSSIBLE");
        } else {
            bufferedWriter.write(String.valueOf(result));
        }

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }

    static int bfs(Node startNode, List<Node> fireNodes) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(startNode);
        isVisited[startNode.x][startNode.y] = true;

        for (Node fireNode : fireNodes) {
            queue.add(fireNode);
            isVisited[fireNode.x][fireNode.y] = true;
        }

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int result = 0;

        while (!queue.isEmpty() && result == 0) {
            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int x = node.x + dx[i];
                int y = node.y + dy[i];

                char beforeState = array[node.x][node.y];

                if (x < 0 || x >= r || y < 0 || y >= c) {
                    if (beforeState == 'J') {
                        result = node.distance + 1;
                        break;
                    } else {
                        continue;
                    }
                }

                if (array[x][y] == 'F' || array[x][y] == '#') {
                    continue;
                }

                if (beforeState == 'J' && isVisited[x][y]) {
                    continue;
                }

                array[x][y] = beforeState;

                if (beforeState == 'J') {
                    isVisited[x][y] = true;
                }

                queue.add(new Node(x, y, node.distance + 1));
            }
        }

        return result;
    }

    static class Node {
        int x;
        int y;
        int distance;

        public Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}