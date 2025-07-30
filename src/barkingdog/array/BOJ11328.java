package barkingdog.array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ11328 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            int[] firstArray = new int[26];
            int[] nextArray = new int[26];
            boolean flag = true;
            StringTokenizer st = new StringTokenizer(br.readLine());
            String first = st.nextToken();
            String next = st.nextToken();

            if (first.length() != next.length()) {
                bw.write("Impossible");
                bw.write("\n");
                continue;
            }

            for (int j = 0; j < first.length(); j++) {
                firstArray[first.charAt(j) - 'a']++;
                nextArray[next.charAt(j) - 'a']++;
            }

            for (int k = 0; k < 26; k++) {
                if (firstArray[k] != nextArray[k]) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                bw.write("Possible");
            } else {
                bw.write("Impossible");
            }
            bw.write("\n");

        }

        bw.flush();
        bw.close();
        br.close();
    }
}
