package barkingdog.array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        int[] array = new int[10000000];
        List<Integer> input = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            input.add(Integer.parseInt(st.nextToken()));
        }

        input.sort(Comparator.naturalOrder());
        int sum = 0;

        int result = Integer.parseInt(br.readLine());
        for (Integer integer : input) {
            int temp = result - integer;
            if (temp >= 0) {
                if (array[temp] == 1) {
                    sum++;
                }
            }
            array[integer] = 1;
        }

        bw.write(String.valueOf(sum));

        bw.flush();
        bw.close();
        br.close();
    }
}
