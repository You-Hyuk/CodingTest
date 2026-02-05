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
    static int[] nums;
    static int[] array;
    static boolean[] issued;
    static StringBuilder stringBuilder;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        stringBuilder = new StringBuilder();

        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());

        nums = new int[n];
        array = new int[m];
        issued = new boolean[10];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(nums);

        func(0, 0);

        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.close();
        bufferedReader.close();
    }

    static void func(int k, int index) {
        if (k == m) {
            for (int i = 0; i < m; i++) {
                stringBuilder.append(array[i]).append(" ");
            }
            stringBuilder.append("\n");
            return;
        }

        int before = 0;

        for (int i = index; i < n; i++) {
            if (!issued[i] && nums[i] != before) {
                issued[i] = true;
                array[k] = nums[i];
                before = array[k];
                func(k + 1, i + 1);
                issued[i] = false;
            }
        }
    }
}