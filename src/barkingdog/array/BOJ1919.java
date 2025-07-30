package barkingdog.array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ1919 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String first = br.readLine();
        String second = br.readLine();
        int[] firstArray = new int[26];
        int result = 0;

        for (int i = 0; i < first.length(); i++) {
            firstArray[first.charAt(i) - 'a']++;
        }

        for (int i = 0; i < second.length(); i++) {
            if (firstArray[second.charAt(i) - 'a'] == 0) {
                result++;
            } else {
                firstArray[second.charAt(i) - 'a']--;
            }
        }

        for (int i : firstArray) {
            result += i;
        }

        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
        br.close();
    }
}
