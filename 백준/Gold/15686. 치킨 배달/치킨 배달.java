import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[][] array;
    static List<Home> homes;
    static List<ChickenStore> chickenStores;
    static boolean[] issued;
    static int minDistance;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());

        array = new int[n][n];
        homes = new ArrayList<>();
        chickenStores = new ArrayList<>();
        minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < n; j++) {
                int number = Integer.parseInt(stringTokenizer.nextToken());

                if (number == 1) {
                    homes.add(new Home(i, j));
                }

                if (number == 2) {
                    chickenStores.add(new ChickenStore(i, j));
                }

                array[i][j] = number;
            }
        }

        issued = new boolean[chickenStores.size()];

        dfs(0, 0);
        bufferedWriter.write(String.valueOf(minDistance));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    static void dfs(int start, int k) {
        if (k == m) {
            int sum = 0;

            for (Home home : homes) {
                int temp = Integer.MAX_VALUE;

                for (int i = 0; i < chickenStores.size(); i++) {
                    if (issued[i]) {
                        int distance = Math.abs(home.getX() - chickenStores.get(i).getX())
                                + Math.abs(home.getY() - chickenStores.get(i).getY());

                        temp = Math.min(temp, distance);
                    }
                }
                sum += temp;
            }

            minDistance = Math.min(minDistance, sum);
            return;
        }

        for (int i = start; i < chickenStores.size(); i++) {
            if (!issued[i]) {
                issued[i] = true;
                dfs(i + 1, k + 1);
                issued[i] = false;
            }
        }
    }

    static class Home {
        int x;
        int y;

        public Home(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    static class ChickenStore {
        int x;
        int y;

        public ChickenStore(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
