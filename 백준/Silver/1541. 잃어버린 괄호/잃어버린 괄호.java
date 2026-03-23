import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = bufferedReader.readLine();

        boolean flag = false;

        int index = 0;
        int result = 0;

        for (int i = 0; i < line.length(); i++) {
            char input = line.charAt(i);
            if (!Character.isDigit(input)) {
                int number = Integer.parseInt(line.substring(index, i));

                if (flag) {
                    result -= number;
                } else {
                    result += number;
                }

                if (input == '-') {
                    flag = true;
                }

                index = i + 1;
            }
        }

        int last = Integer.parseInt(line.substring(index));

        if (flag) {
            result -= last;
        } else {
            result += last;
        }

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}