package practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ24060 {
    static int count = 0;
    static int num = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] list = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list[i] = (Integer.parseInt(st.nextToken()));
        }

        mergeSort(list, 0, list.length - 1, k);

        if (k > count) {
            bw.write(String.valueOf(-1));
        } else {
            bw.write(String.valueOf(num));
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void merge(int[] list, int p, int q, int r, int k) {
        int i = p;
        int j = q + 1;
        int t = 0;
        int[] temp = new int[r - p + 1];

        while (i <= q && j <= r) {
            if (list[i] <= list[j]) {
                temp[t++] = list[i++];
            } else {
                temp[t++] = list[j++];
            }
        }
        while (i <= q) {
            temp[t++] = list[i++];
        }
        while (j <= r) {
            temp[t++] = list[j++];
        }
        i = p;
        t = 0;
        while (i <= r) {
            list[i++] = temp[t++];
            count++;
            if (count == k) {
                num = temp[t - 1];
            }
        }
    }

    static void mergeSort(int[] list, int p, int r, int k) {
        if (p < r) {
            int q = Math.floorDiv(p + r, 2);
            mergeSort(list, p, q, k);
            mergeSort(list, q+ 1, r, k);
            merge(list, p, q, r, k);
        }
    }

}
