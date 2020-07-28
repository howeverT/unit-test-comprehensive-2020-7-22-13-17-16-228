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
}
