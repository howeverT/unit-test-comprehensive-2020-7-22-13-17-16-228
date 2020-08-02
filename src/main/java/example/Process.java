package example;


public class Process {
    public String play(int[] inputGuess, int times, GuessNumber guessNumber) {
        String guessOutput = guessNumber.guess(inputGuess);
        if (!guessNumber.isLegalList(inputGuess)) {
            return Constants.WRONG_MESSAGE;
        } else {//TODO
            if (guessOutput.equals("4A0B")) {
                return Constants.SUCCESS_MESSAGE;
            }
        }
        if (times >= 6 && !guessOutput.equals(Constants.SUCCESS_MESSAGE)) {
            return guessOutput + "\n" + Constants.FAIL_MESSAGE;//TODO
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
