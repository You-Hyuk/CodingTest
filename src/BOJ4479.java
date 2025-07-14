import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ4479 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = "";

        while ((str = br.readLine()) != null) {
            int length = (int) Math.pow(3, Integer.parseInt(str));
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < length; i++) {
                sb.append("-");
            }
            function(sb, 0, length - 1);

            System.out.println(sb);
        }

        bw.close();
        br.close();
    }

    static void function(StringBuilder sb, int startIndex, int endIndex) {
        int length = endIndex - startIndex + 1;
        int firstIndex = length / 3 + startIndex;
        int secondIndex = 2 * length / 3 + startIndex;

        if (length > 3) {
            for (int i = firstIndex; i < secondIndex; i++) {
                sb.setCharAt(i, ' ');
            }
            function(sb, startIndex, firstIndex - 1);
            function(sb, secondIndex, endIndex);
        } else if (length == 3){
            sb.replace(startIndex, endIndex + 1, "- -");
        }
    }

}
