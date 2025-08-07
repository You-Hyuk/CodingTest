import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        int num = Integer.parseInt(br.readLine());
        LinkedList<Character> linkedList = new LinkedList<>();
        for (int i = 0; i < input.length(); i++) {
            linkedList.add(input.charAt(i));
        }

        ListIterator<Character> output = linkedList.listIterator();

        while (output.hasNext()) {
            output.next();
        }

        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command){
                case "L":
                    if (output.hasPrevious()) {
                        output.previous();
                    }
                    break;
                case "D":
                    if (output.hasNext()) {
                        output.next();
                    }
                    break;
                case "B":
                    if (output.hasPrevious()) {
                        output.previous();
                        output.remove();
                    }
                    break;
                case "P":
                    output.add(st.nextToken().charAt(0));
                    break;
            }
        }

        for (Character c : linkedList) {
            bw.write(c);
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
