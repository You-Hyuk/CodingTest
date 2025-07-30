package practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class BOJ25192 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<String> list = new LinkedList<>();
        Set<String> set = new HashSet<>();

        int k = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i = 0; i < k; i++) {
            String str = br.readLine();
            if (str.equals("ENTER")){
                set.clear();
            } else if (set.add(str)) {
                result++;
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
