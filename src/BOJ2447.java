import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ2447 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        char[][] star = new char[size][size];

        recursive(star, size, 0, 0);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                bw.write(star[i][j]);
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void recursive(char[][] star, int size, int x, int y) {
        if (size == 1){
            star[x][y] = '*';
            return;
        }

        int step = size / 3;
        for (int dx = 0; dx < 3; dx++) {
            for (int dy = 0; dy < 3; dy++) {
                int nx = x + dx * step;
                int ny = y + dy * step;

                if (dx == 1 && dy == 1) {
                    for (int i = 0; i < step; i++) {
                        for (int j = 0; j < step; j++) {
                            star[nx + i][ny + j] = ' ';
                        }
                    }
                } else {
                    recursive(star, step, nx, ny);
                }
            }
        }

    }
}
