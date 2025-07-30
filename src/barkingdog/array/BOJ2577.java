package barkingdog.array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int result = 1;
        int[] array = new int[10];

        for (int i = 0; i < 3; i++) {
            result *= Integer.parseInt(br.readLine());
        }

        while (result / 10 != 0) {
            int num = result % 10;
            array[num] += 1;
            result = result / 10;
        }

        array[result] += 1;

        for (int i : array) {
            bw.write(String.valueOf(i));
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
