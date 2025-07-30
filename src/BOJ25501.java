import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ25501 {
    public static int count = 0;
    public static int recursion(String s, int l, int r){
        count++;
        if(l >= r)
            return 1;
        else if(s.charAt(l) != s.charAt(r))
            return 0;
        else
            return recursion(s, l+1, r-1);
    }
    public static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            StringBuilder sb = new StringBuilder();
            count = 0;
            String input = br.readLine();
            sb.append(isPalindrome(input)).append(" ").append(count).append("\n");
            bw.write(sb.toString());
        }
        bw.flush();
        bw.close();
        br.close();
    }
}