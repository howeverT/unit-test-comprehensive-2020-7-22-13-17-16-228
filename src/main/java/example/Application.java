package example;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        int times = 1;
        String message;
        GuessNumber guessNumber = new GuessNumber();
        while (times <= 6) {
            System.out.println("please input 4 number:");
            Scanner in = new Scanner(System.in);
            Process process = new Process();
            int[] inputGuess = new int[4];
            for (int index = 0; index < inputGuess.length; index++) {
                inputGuess[index] = in.nextInt();
            }
            times= process.gameProcess(inputGuess, times, guessNumber);
        }



    }
}
