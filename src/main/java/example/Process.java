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
}
