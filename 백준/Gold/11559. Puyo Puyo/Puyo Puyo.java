import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Main {

    static char[][] array;
    static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        array = new char[12][6];

        for (int i = 0; i < 12 ; i++) {
            String line = bufferedReader.readLine();
            for (int j = 0; j < 6; j++) {
                array[i][j] = line.charAt(j);
            }
        }

        List<Integer[]> puyos;
        int result = 0;

        while (true) {
            puyos = new ArrayList<>();
            isVisited = new boolean[12][6];
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (array[i][j] != '.' && !isVisited[i][j]) {
                        puyos.addAll(dfs(i, j));
                    }
                }
            }

            if (puyos.isEmpty()) {
                break;
            }

            remove(puyos);
            result++;
        }

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }

    static List<Integer[]> dfs(int startX, int startY) {
        Queue<Integer[]> queue = new ArrayDeque<>();
        queue.add(new Integer[]{startX, startY});
        char beforePuyo = array[startX][startY];
        List<Integer[]> puyos = new ArrayList<>();

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            Integer[] node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = node[0] + dx[i];
                int y = node[1] + dy[i];

                if (x < 0 || x >= 12 || y < 0 || y >= 6) {
                    continue;
                }

                if (array[x][y] == '.' || isVisited[x][y] || array[x][y] != beforePuyo) {
                    continue;
                }

                puyos.add(new Integer[]{x, y});
                isVisited[x][y] = true;
                queue.add(new Integer[]{x, y});
            }
        }

        if (puyos.size() < 4) {
            return List.of();
        }

        return puyos;
    }

    static void remove(List<Integer[]> pop) {
        for (Integer[] node : pop) {
            array[node[0]][node[1]] = '.';
        }

        for (int i = 0; i < 6; i++) {
            Stack<Character> stack = new Stack<>();
            for (int j = 11; j >= 0; j--) {
                char puyo = array[j][i];

                if (puyo == '.') {
                    continue;
                }

                stack.push(puyo);
            }

            int size = stack.size();

            while (stack.size() != 12) {
                stack.push('.');
            }

            for (int j = 0; j < 12; j++) {
                array[j][i] = stack.pop();
            }
        }
    }
}