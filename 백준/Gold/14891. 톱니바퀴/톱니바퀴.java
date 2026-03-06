import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Cogwheel> cogwheels;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        cogwheels = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            List<Integer> poles = new ArrayList<>();
            String string = bufferedReader.readLine();
            int leftPole = 0;
            int rightPole = 0;
            for (int j = 0; j < 8; j++) {
                int pole = Character.getNumericValue(string.charAt(j));
                poles.add(pole);
                if (j == 2) {
                    rightPole = pole;
                }
                if (j == 6) {
                    leftPole = pole;
                }
            }
            cogwheels.add(new Cogwheel(poles));
        }

        int k = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer;

        for (int i = 0; i < k; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int number = Integer.parseInt(stringTokenizer.nextToken());
            int direction = Integer.parseInt(stringTokenizer.nextToken());
            spin(number, direction);
        }

        int result = 0;

        if (cogwheels.get(0).getPoles().get(0) == 1) {
            result += 1;
        }
        if (cogwheels.get(1).getPoles().get(0) == 1) {
            result += 2;
        }
        if (cogwheels.get(2).getPoles().get(0) == 1) {
            result += 4;
        }
        if (cogwheels.get(3).getPoles().get(0) == 1) {
            result += 8;
        }

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    static void spin(int number, int direction) {
        List<Integer> directions = new ArrayList<>(List.of(0, 0, 0, 0));
        directions.set(number - 1, direction);
        Cogwheel cogwheel = cogwheels.get(number - 1);

        if (number == 1) {
            directions.set(1,
                    determineDirection(cogwheel.getRightPole(), cogwheels.get(1).getLeftPole(), direction)
            );
            directions.set(2,
                    determineDirection(cogwheels.get(1).getRightPole(), cogwheels.get(2).getLeftPole(),
                            directions.get(1))
            );
            directions.set(3,
                    determineDirection(cogwheels.get(2).getRightPole(), cogwheels.get(3).getLeftPole(),
                            directions.get(2))
            );
        }
        if (number == 2) {
            directions.set(0, determineDirection(cogwheel.getLeftPole(), cogwheels.get(0).getRightPole(), direction));
            directions.set(2, determineDirection(cogwheel.getRightPole(), cogwheels.get(2).getLeftPole(), direction));
            directions.set(3, determineDirection(cogwheels.get(2).getRightPole(), cogwheels.get(3).getLeftPole(), directions.get(2)));
        }
        if (number == 3) {
            directions.set(1, determineDirection(cogwheel.getLeftPole(), cogwheels.get(1).getRightPole(), direction));
            directions.set(0, determineDirection(cogwheels.get(1).getLeftPole(), cogwheels.get(0).getRightPole(), directions.get(1)));
            directions.set(3, determineDirection(cogwheel.getRightPole(), cogwheels.get(3).getLeftPole(), direction));
        }
        if (number == 4) {
            directions.set(2, determineDirection(cogwheel.getLeftPole(), cogwheels.get(2).getRightPole(), direction));
            directions.set(1, determineDirection(cogwheels.get(2).getLeftPole(), cogwheels.get(1).getRightPole(), directions.get(2)));
            directions.set(0, determineDirection(cogwheels.get(1).getLeftPole(), cogwheels.get(0).getRightPole(), directions.get(1)));
        }

        for (int i = 0; i < 4; i++) {
            cogwheels.get(i).rotate(directions.get(i));
        }

    }

    static int determineDirection(int standardPole, int pole, int direction) {
        if (standardPole == pole || direction == 0) {
            return 0;
        }
        if (direction == 1) {
            return -1;
        }
        return 1;
    }

    static class Cogwheel {
        List<Integer> poles;

        public Cogwheel(List<Integer> poles) {
            this.poles = poles;
        }

        public int getLeftPole() {
            return this.poles.get(6);
        }

        public int getRightPole() {
            return this.poles.get(2);
        }

        public List<Integer> getPoles() {
            return poles;
        }

        //회전 메소드(덱 이용)
        void rotate(int direction) {
            if (direction == 0) {
                return;
            }

            List<Integer> rotatePoles = new ArrayList<>();

            if (direction == 1) {
                rotatePoles.add(poles.get(7));
                rotatePoles.addAll(poles.subList(0, 7));
                this.poles = rotatePoles;
            }
            if (direction == -1) {
                rotatePoles.addAll(poles.subList(1, 8));
                rotatePoles.add(poles.get(0));
                this.poles = rotatePoles;
            }
        }
    }

}