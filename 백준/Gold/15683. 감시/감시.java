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
    static int[][] copyArray;
    static List<CCTV> cctvs;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());
        result = n * m;

        array = new int[n][m];
        cctvs = new ArrayList<>();
        copyArray = new int[n][m];

        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < m; j++) {
                array[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                if (array[i][j] != 0 && array[i][j] != 6) {
                    cctvs.add(new CCTV(i, j, array[i][j]));
                }
            }
        }

        function();

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    static void function() {
        for (int i = 0; i < (int) Math.pow(4, cctvs.size()); i++) {
            int temp = i;

            for (int l = 0; l < array.length; l++) {
                System.arraycopy(array[l], 0, copyArray[l], 0, array[l].length);
            }

            for (int j = 0; j < cctvs.size(); j++) {
                CCTV cctv = cctvs.get(j);
                int direction = temp % 4;
                temp = temp / 4;
                function2(cctv, direction);
            }

            int count = 0;

            for (int x = 0; x < n; x++) {
                for (int y = 0; y < m; y++) {
                    if (copyArray[x][y] == 0) {
                        count++;
                    }
                }
            }

            if (count < result) {
                result = count;
            }
        }
    }

    static void function2(CCTV cctv, int direction) {
        if (cctv.number == 1) {
            watch(cctv, direction);
        }
        if (cctv.number == 2) {
            if (direction % 2 == 1) {
                watch(cctv, 1);
                watch(cctv, 3);
            } else {
                watch(cctv, 0);
                watch(cctv, 2);
            }
        }
        if (cctv.number == 3) {
            watch(cctv, direction);
            watch(cctv, (direction + 1) % 4);
        }
        if (cctv.number == 4) {
            watch(cctv, direction);
            watch(cctv, (direction + 1) % 4);
            watch(cctv, (direction + 3) % 4);
        }
        if (cctv.number == 5) {
            watch(cctv, 0);
            watch(cctv, 1);
            watch(cctv, 2);
            watch(cctv, 3);
        }
    }

    static void watch(CCTV cctv, int direction) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int x = cctv.n;
        int y = cctv.m;

        while (true) {
            x += dx[direction];
            y += dy[direction];

            if (x < 0 || x >= n || y < 0 || y >= m || copyArray[x][y] == 6) {
                break;
            }

            if (copyArray[x][y] != 0) {
                continue;
            }

            copyArray[x][y] = 7;
        }
    }

    static class CCTV{
        int n;
        int m;
        int number;

        public CCTV(int n, int m, int number) {
            this.n = n;
            this.m = m;
            this.number = number;
        }
    }
}