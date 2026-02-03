import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int s;
    static int[] nums;
    static int[] array;
    static int count;
    static boolean[] issued;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        s = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        nums = new int[n];
        count = 0;
        issued = new boolean[n + 1];


        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        func(0, 0);

        if (s == 0) {
            count--;
        }

        bufferedWriter.write(String.valueOf(count));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    // k는 현재 부분집합 원소의 개수
    static void func(int cur, int sum) {
        if (cur == n) {
            if (sum == s) {
                count++;
            }
            return;
        }

        func(cur + 1, sum);
        func(cur + 1, sum + nums[cur]);
    }

}