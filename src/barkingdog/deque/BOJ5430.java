package barkingdog.deque;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            Deque<Integer> deque = new ArrayDeque<>();
            String cmd = br.readLine();
            int size = Integer.parseInt(br.readLine());
            String array = br.readLine();
            StringBuilder sb = new StringBuilder();
            boolean isReversed = false;
            boolean isError = false;

            // 입력 배열 가공
            String replace = array.replace(',', ' ')
                    .replace('[', ' ')
                    .replace(']', ' ');
            StringTokenizer st = new StringTokenizer(replace);


            for (int j = 0; j < size; j++) {
                deque.add(Integer.parseInt(st.nextToken()));
            }

            //명령어 수행
            for (int j = 0; j < cmd.length(); j++) {
                char c = cmd.charAt(j);

                if (c == 'R') {
                    isReversed = !isReversed;
                }

                if (c == 'D') {
                    if (deque.isEmpty()) {
                        isError = true;
                        break;
                    } else {
                        if (isReversed) {
                            deque.pollLast();
                        } else {
                            deque.pollFirst();
                        }
                    }
                }
            }


            if (isError) {
                bw.write("error");
            } else {
                if (isReversed) {
                    int n = deque.size();
                    sb.append("[");
                    if (n != 0) {
                        for (int k = 0; k < n - 1; k++) {
                            sb.append(deque.pollLast()).append(",");
                        }
                        sb.append(deque.pollLast());
                    }
                    sb.append("]");
                    bw.write(sb.toString());
                } else {
                    bw.write(Arrays.toString(deque.toArray()).replace(" ", ""));
                }
            }

            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
