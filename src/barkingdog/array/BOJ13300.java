package barkingdog.array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ13300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int total = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());
        int sum = 0;
        int roomNum = 0;

        int[] girl = new int[6];
        int[] boy = new int[6];

        while (sum < total) {
            st = new StringTokenizer(br.readLine());

            int gender = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken());

            if (gender == 0) {
                if (girl[grade - 1] == max) {
                    roomNum++;
                    girl[grade - 1] = 1;
                } else if (girl[grade - 1] == 0){
                    roomNum++;
                    girl[grade - 1]++;
                } else {
                    girl[grade - 1]++;
                }
            } else {
                if (boy[grade - 1] == max) {
                    roomNum++;
                    boy[grade - 1] = 1;
                } else if (boy[grade - 1] == 0){
                    roomNum++;
                    boy[grade - 1]++;
                } else {
                    boy[grade - 1]++;
                }
            }
            sum++;
        }

        bw.write(String.valueOf(roomNum));

        bw.flush();
        bw.close();
        br.close();
    }
}
