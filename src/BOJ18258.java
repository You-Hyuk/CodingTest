import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < count; i++) {
            StringTokenizer inst = new StringTokenizer(br.readLine());

            switch (inst.nextToken()) {
                case "push" :
                    queue.add(Integer.parseInt(inst.nextToken()));
                    break;
                case "front" :
                    if (queue.isEmpty()){
                        bw.write(String.valueOf(-1) + "\n");
                    } else {
                        bw.write(String.valueOf(queue.peekFirst()) + "\n");
                    }
                    break;
                case "back" :
                    if (queue.isEmpty()){
                        bw.write(String.valueOf(-1) + "\n");
                    } else {
                        bw.write(String.valueOf(queue.peekLast()) + "\n");
                    }
                    break;
                case "empty" :
                    bw.write(String.valueOf(queue.isEmpty() ? 1 : 0) + "\n");
                    break;
                case "pop" :
                    if (queue.isEmpty()){
                        bw.write(String.valueOf(-1) + "\n");
                    } else {
                        bw.write(String.valueOf(queue.pollFirst()) + "\n");
                    }
                    break;
                case "size" :
                    bw.write(String.valueOf(queue.size()) + "\n");
                    break;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
