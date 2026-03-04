import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int w;
    static int l;
    static Queue<Integer> queue;

    static int time;
    static int sum;
    static List<Integer> trucks;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        time = 0;

        n = Integer.parseInt(stringTokenizer.nextToken());
        w = Integer.parseInt(stringTokenizer.nextToken());
        l = Integer.parseInt(stringTokenizer.nextToken());

        trucks = new ArrayList<>();
        queue = new ArrayDeque<>();

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {
            trucks.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        for (int i = 0; i < w; i++) {
            queue.add(0);
        }

        function();
        bufferedWriter.write(String.valueOf(time));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    static void function() {
        boolean isFinished = false;
        int index = 0;

        while (!queue.isEmpty()) {
            time++;
            int weight = queue.poll();

            sum -= weight;

            if (!isFinished) {
                if (trucks.get(index) + sum <= l) {
                    queue.add(trucks.get(index));
                    sum += trucks.get(index);
                    index++;

                    if (index == n) {
                        isFinished = true;
                    }
                } else {
                    queue.add(0);
                }
            }
        }

    }
}