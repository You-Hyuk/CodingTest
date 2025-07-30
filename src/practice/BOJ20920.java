package practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BOJ20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();

        // 단어를 Key, 빈도를 Value로 관리
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            if (word.length() >= m) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        List<Map.Entry<String, Integer>> entryArrayList = new ArrayList<>(map.entrySet());

        List<Map.Entry<String, Integer>> list = entryArrayList.stream().sorted(
                        (Comparator.comparing(Map.Entry<String, Integer>::getValue, Comparator.reverseOrder())
                                .thenComparing(e -> e.getKey().length(), Comparator.reverseOrder())
                                .thenComparing(Map.Entry::getKey, Comparator.naturalOrder()))
                )
                .collect(Collectors.toList());


        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : list) {
            sb.append(entry.getKey()).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
