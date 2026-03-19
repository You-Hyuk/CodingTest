import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int l;
    static int r;
    static int c;
    static char[][][] array;
    static boolean[][][] isVisited;
    static int[][][] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder stringBuilder = new StringBuilder();
        StringTokenizer stringTokenizer;

        while (true) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            l = Integer.parseInt(stringTokenizer.nextToken());
            r = Integer.parseInt(stringTokenizer.nextToken());
            c = Integer.parseInt(stringTokenizer.nextToken());

            if (l == 0 && r == 0 && c == 0) {
                break;
            }
            array = new char[l][r][c];
            isVisited = new boolean[l][r][c];
            distance = new int[l][r][c];

            Node startNode = new Node(0, 0, 0);

            for (int k = 0; k < l; k++) {
                for (int i = 0; i < r; i++) {
                    String line = bufferedReader.readLine();
                    for (int j = 0; j < c; j++) {
                        char input = line.charAt(j);
                        array[k][i][j] = input;
                        if (input == 'S') {
                            startNode = new Node(i, j, k);
                        }
                    }
                }
                String temp = bufferedReader.readLine();
            }

            int result = bfs(startNode);

            if (result == 0) {
                stringBuilder.append("Trapped!").append("\n");
            } else {
                stringBuilder.append("Escaped in ").append(result).append(" minute(s).").append("\n");
            }
        }
        
        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }

    static int bfs(Node startNode) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(startNode);
        int result = 0;

        int[] dx = {-1, 0, 1, 0, 0, 0};
        int[] dy = {0, -1, 0, 1, 0, 0};
        int[] dz = {0, 0, 0, 0, 1, -1};

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    int x = node.x + dx[i];
                    int y = node.y + dy[i];
                    int z = node.z + dz[i];

                    if (x < 0 || x >= r || y < 0 || y >= c || z < 0 || z >= l) {
                        continue;
                    }

                    if (array[z][x][y] == '#' || isVisited[z][x][y]) {
                        continue;
                    }

                    isVisited[z][x][y] = true;
                    distance[z][x][y] = distance[node.z][node.x][node.y] + 1;

                    if (array[z][x][y] == 'E') {
                        result = distance[z][x][y];
                        break;
                    }

                    queue.add(new Node(x, y, z));
                }
            }
        }

        return result;
    }

    static class Node {
        int x;
        int y;
        int z;

        public Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}