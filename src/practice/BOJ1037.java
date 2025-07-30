package practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.io.IOException;

public class BOJ1037 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int min = Integer.parseInt(st.nextToken());
        int max = min;
        while (st.hasMoreTokens()) {
            int input = Integer.parseInt(st.nextToken());
            if(input < min) {
                min = input;
            }

            if(input > max) {
                max = input;
            }
        }

        bw.write(String.valueOf(min * max));
        bw.flush();
        br.close();
        bw.close();
    }
}