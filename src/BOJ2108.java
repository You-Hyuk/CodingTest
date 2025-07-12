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

public class BOJ2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> duplicateList = new ArrayList<>();

        double sum = 0.0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            list.add(num);
            sum += num;
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 산술 평균
        int result = (int) (Math.round(sum / n));

        //중앙값
        list.sort(Comparator.naturalOrder());
        int middle = list.get(n / 2);

        //최빈값
        int firstFreq = 0;
        int firstNum = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();

            if (freq > firstFreq) {
                firstFreq = freq;
                firstNum = num;
                duplicateList.clear();
                duplicateList.add(firstNum);
            } else if (freq == firstFreq) {
                duplicateList.add(num);
            }
        }

        duplicateList.sort(Comparator.naturalOrder());

        if (duplicateList.size() > 1) {
            firstNum = duplicateList.get(1);
        } else if (duplicateList.size() == 1) {
            firstNum = duplicateList.get(0);
        }

        //범위
        int range = 0;
        if (n != 1) {
            range = list.get(n - 1) - list.get(0);
        }


        StringBuilder sb = new StringBuilder();
        sb.append(result).append("\n")
                .append(middle).append("\n")
                .append(firstNum).append("\n")
                .append(range).append("\n");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
