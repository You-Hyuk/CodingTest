import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[] array;
    static int[] nums;
    static boolean[] issued;
    static StringBuilder stringBuilder;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        stringBuilder = new StringBuilder();
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());

        array = new int[m];
        nums = new int[n];
        issued = new boolean[100001];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        nums = Arrays.stream(nums)
                .sorted()
                .toArray();

        func(0);

        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.close();
        bufferedReader.close();
    }

    static void func(int k) {
        if (k == m) {
            for (int i = 0; i < m; i++) {
                stringBuilder.append(array[i]).append(" ");
            }
            stringBuilder.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            array[k] = nums[i];
            func(k + 1);
        }
    }
}