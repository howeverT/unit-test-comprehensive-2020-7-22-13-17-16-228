package example;


public class Process {
    public String play(int[] inputGuess, int times, GuessNumber guessNumber) {
        String guessOutput = guessNumber.guess(inputGuess);
        if (!guessNumber.isLegalList(inputGuess)) {
            return ConstantHouse.WRONG_MESSAGE;
        } else {
            if (guessOutput.equals("4A0B")) {
                return ConstantHouse.SUCCESS_MESSAGE;
            }
        }
        if (times >= 6 && !guessOutput.equals(ConstantHouse.SUCCESS_MESSAGE)) {
            return guessOutput + "\n" + ConstantHouse.FAIL_MESSAGE;
        }
        return guessOutput;
    }

    public int gameProcess(int[] inputGuess, int times, GuessNumber guessNumber) {
        String message = play(inputGuess, times, guessNumber);
        if (message.equals(ConstantHouse.SUCCESS_MESSAGE)) {
            System.out.println(message);
            return 7;
        } else if (message.equals(ConstantHouse.WRONG_MESSAGE)) {
            System.out.println(message);
        } else {
            System.out.println(message);
            times++;
        }
        return times;
    }
}
