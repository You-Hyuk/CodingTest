import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ26069 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        set.add("ChongChong");

        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String first = st.nextToken();
            String second = st.nextToken();

            if (set.contains(first) || set.contains(second)) {
                set.add(first);
                set.add(second);
            }
        }

        bw.write(String.valueOf(set.size()));
        bw.flush();
        bw.close();
        br.close();
    }
}
