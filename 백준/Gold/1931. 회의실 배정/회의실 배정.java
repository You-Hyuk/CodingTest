import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bufferedReader.readLine());

        Conference[] conferences = new Conference[n];
        StringTokenizer stringTokenizer;


        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(stringTokenizer.nextToken());
            int end = Integer.parseInt(stringTokenizer.nextToken());
            conferences[i] = new Conference(start, end);
        }

        Arrays.sort(conferences, Comparator.comparing(Conference::getEndTime).thenComparing(Conference::getStartTime));

        int result = 0;
        int time = 0;

        for (int i = 0; i < n; i++) {
            if (conferences[i].getStartTime() < time) {
                 continue;
            }

            result++;
            time = conferences[i].getEndTime();
        }

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }

    static class Conference {
        int startTime;
        int endTime;

        public Conference(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public int getStartTime() {
            return startTime;
        }

        public int getEndTime() {
            return endTime;
        }
    }
}