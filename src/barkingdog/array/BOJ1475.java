package barkingdog.array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.OptionalInt;

public class BOJ1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        int[] array = new int[9];

        for (int i = 0; i < str.length(); i++) {
            char num = str.charAt(i);
            if (num == '9') {
                array[6]++;
            } else {
                array[num - 48]++;
            }
        }

        array[6] = (array[6] + 1) / 2;
        OptionalInt max = Arrays.stream(array).max();
        bw.write(String.valueOf(max.getAsInt()));

        bw.flush();
        bw.close();
        br.close();
    }
}
