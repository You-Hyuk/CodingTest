import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] array;
    static int[][] copy;
    static int max;
    static boolean isAdded;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer;

        n = Integer.parseInt(bufferedReader.readLine());
        array = new int[n][n];
        copy = new int[n][n];

        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < n; j++) {
                array[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        max = 0;

        if (n == 1) {
            max = array[0][0];
        }

        for (int i = 0; i < Math.pow(4, 5); i++) {
            int temp = i;

            for (int k = 0; k < n; k++) {
                System.arraycopy(array[k], 0, copy[k], 0, n);
            }

            for (int j = 0; j < 5; j++) {
                int direction = temp % 4;
                temp = temp / 4;
                move(direction);
            }
        }

        bufferedWriter.write(String.valueOf(max));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    static void move(int direction) {
        Stack<Integer> stack = new Stack<>();
        isAdded = false;
        // 위
        if (direction == 0) {
            // 열 고정, 행 기준 스택 사용
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int num = copy[j][i];
                    addBlock(stack, num);
                }
                fillStack(stack);
                for (int k = n - 1; k >= 0; k--) {
                    copy[k][i] = stack.pop();
                }
            }
        }
        // 오른쪽
        if (direction == 1) {
            // 행 고정, 열 기준 스택 사용
            for (int i = 0; i < n; i++) {
                for (int j = n - 1; j >= 0; j--) {
                    int num = copy[i][j];
                    addBlock(stack, num);
                }
                fillStack(stack);
                for (int k = 0; k < n; k++) {
                    copy[i][k] = stack.pop();
                }
            }
        }
        // 아래
        if (direction == 2) {
            // 열 고정, 행 기준 스택 사용
            for (int i = 0; i < n; i++) {
                for (int j = n - 1; j >= 0; j--) {
                    int num = copy[j][i];
                    addBlock(stack, num);
                }
                fillStack(stack);

                for (int k = 0; k < n; k++) {
                    copy[k][i] = stack.pop();
                }
            }
        }
        // 왼쪽
        if (direction == 3) {
            // 행 고정, 열 기준 스택 사용
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int num = copy[i][j];
                    addBlock(stack, num);
                }
                fillStack(stack);
                for (int k = n - 1; k >= 0; k--) {
                    copy[i][k] = stack.pop();
                }
            }
        }
    }

    static void fillStack(Stack<Integer> stack) {
        int size = stack.size();
        for (int i = 0; i < n - size; i++) {
            stack.push(0);
        }
    }

    static void addBlock(Stack<Integer> stack, int num) {
        if (num == 0) {
            return;
        }

        if (stack.isEmpty()) {
            isAdded = false;
            stack.push(num);
            return;
        }

        if (stack.peek() == num && !isAdded) {
            stack.pop();
            stack.push(num * 2);
            isAdded = true;
            if (num * 2 > max) {
                max = num * 2;
            }
        } else if (stack.peek() == num && isAdded) {
            stack.push(num);
            isAdded = false;
            if (num > max) {
                max = num;
            }
        } else if (stack.peek() != num) {
            stack.push(num);
            isAdded = false;
            if (num > max) {
                max = num;
            }
        }
    }

}