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
    static int k;
    static int[][] array;
    static List<Sticker> stickers;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());
        k = Integer.parseInt(stringTokenizer.nextToken());

        stickers = new ArrayList<>();

        array = new int[n][m];

        for (int i = 0; i < k; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int r = Integer.parseInt(stringTokenizer.nextToken());
            int c = Integer.parseInt(stringTokenizer.nextToken());

            int[][] shape = new int[r][c];

            for (int j = 0; j < r; j++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                for (int l = 0; l < c; l++) {
                    shape[j][l] = Integer.parseInt(stringTokenizer.nextToken());
                }
            }
            stickers.add(new Sticker(r, c, shape));
        }

        function();

        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (array[i][j] == 1) {
                    result++;
                }
            }
        }

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    static void function() {
        for (Sticker sticker : stickers) {
            for (int r = 0; r < 4; r++) {
                for (int i = 0; i < n - sticker.r + 1; i++) {
                    for (int j = 0; j < m - sticker.c + 1; j++) {
                        if (!sticker.isAttached && isMatch(i, j, sticker)) {
                            attach(i, j, sticker);
                        }
                    }
                }
                if (sticker.isAttached) {
                    break;
                }
                sticker.rotate();
            }
        }
    }

    static boolean isMatch(int x, int y, Sticker sticker) {
        for (int i = 0; i < sticker.r; i++) {
            for (int j = 0; j < sticker.c; j++) {
                if (sticker.shape[i][j] == 1 && array[i + x][j + y] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    static void attach(int x, int y, Sticker sticker) {
        for (int i = 0; i < sticker.r; i++) {
            for (int j = 0; j < sticker.c; j++) {
                if (sticker.shape[i][j] == 1) {
                    array[i + x][j + y] = 1;
                }
            }
        }
        sticker.setAttach();
    }

    static class Sticker {
        int r;
        int c;
        int[][] shape;
        boolean isAttached;

        public Sticker(int r, int c, int[][] shape) {
            this.r = r;
            this.c = c;
            this.shape = shape;
            this.isAttached = false;
        }

        void rotate() {
            int[][] newShape = new int[c][r];
            for (int i = 0; i < c; i++) {
                for (int j = 0; j < r; j++) {
                    newShape[i][j] = shape[r - 1 - j][i];
                }
            }
            int temp = c;
            this.c = r;
            this.r = temp;
            this.shape = newShape;
        }

        void setAttach() {
            this.isAttached = true;
        }
    }
}