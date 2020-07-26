package example;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        int times = 1;
        String result = "You lose";
        while (times <= 6) {
            System.out.println("please input 4 number:");
            Scanner in = new Scanner(System.in);
            GuessNumber guessNumber = new GuessNumber();
            int[] inputGuess = new int[4];
            for (int index = 0; index < inputGuess.length; index++) {
                inputGuess[index] = in.nextInt();
            }
            if (!guessNumber.isLegalList(inputGuess)){
                System.out.println("Wrong Input,Input again");
            }
            else {
                if (guessNumber.guess(inputGuess).equals("4A0B"))
                    result = "You win";
                else
                    System.out.println(guessNumber.guess(inputGuess));
                times++;
            }
        }
        System.out.println(result);


    }
}
