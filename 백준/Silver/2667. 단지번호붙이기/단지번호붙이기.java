import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class Main {

    static int n;
    static int[][] array;
    static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(bufferedReader.readLine());
        array = new int[n][n];
        isVisited = new boolean[n][n];

        int total = 0;
        List<Integer> counts = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = bufferedReader.readLine();
            for (int j = 0; j < n; j++) {
                array[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (array[i][j] == 1 && !isVisited[i][j]) {
                    total++;
                    counts.add(bfs(i, j));
                }
            }
        }

        String countString = counts.stream()
                .sorted(Comparator.naturalOrder())
                .map(String::valueOf)
                .collect(Collectors.joining("\n"));

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(total).append("\n").append(countString);
        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    static int bfs(int startX, int startY) {
        Queue<Integer[]> queue = new ArrayDeque<>();
        isVisited[startX][startY] = true;
        queue.offer(new Integer[]{startX, startY});

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int size = 1;

        while (!queue.isEmpty()) {
            Integer[] node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int x = node[0] + dx[i];
                int y = node[1] + dy[i];

                if (x < 0 || x >= n || y < 0 || y >= n) {
                    continue;
                }

                if (array[x][y] == 0 || isVisited[x][y]) {
                    continue;
                }

                size++;
                isVisited[x][y] = true;
                queue.add(new Integer[]{x, y});
            }
        }

        return size;
    }
}