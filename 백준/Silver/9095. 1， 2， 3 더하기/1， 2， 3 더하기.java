import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static int n;
    static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder stringBuilder = new StringBuilder();

        n = Integer.parseInt(bufferedReader.readLine());
        array = new int[11];
        array[1] = 1;
        array[2] = 2;
        array[3] = 4;

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(bufferedReader.readLine());
            stringBuilder.append(function(number)).append("\n");
        }

        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    static int function(int number) {
        for (int i = 4; i <= number; i++) {
            array[i] = array[i - 1] + array[i - 2] + array[i - 3];
        }

        return array[number];
    }
}