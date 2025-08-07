package barkingdog.linkedlist;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;

public class BOJ5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            String input = br.readLine();
            LinkedList<Character> linkedList = new LinkedList<>();
            ListIterator<Character> iterator = linkedList.listIterator();
            for (int j = 0; j < input.length(); j++) {
                char c = input.charAt(j);
                if (c == '<') {
                    if (iterator.hasPrevious()) {
                        iterator.previous();
                    }
                } else if (c == '>') {
                    if (iterator.hasNext()) {
                        iterator.next();
                    }
                } else if (c == '-') {
                    if (iterator.hasPrevious()) {
                        iterator.previous();
                        iterator.remove();
                    }
                } else {
                    iterator.add(c);
                }
            }

            for (Character c : linkedList) {
                bw.write(c);
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
