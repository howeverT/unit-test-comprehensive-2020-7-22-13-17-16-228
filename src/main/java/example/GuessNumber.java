package example;

public class GuessNumber {
    public String guess(int[] inputGuess, int[] answer) {
        if (isCurrent(inputGuess,answer))
            return "4A0B";

        return null;
    }
    public boolean isCurrent(int[] inputGuess, int[] answer){
        for (int index = 0; index < inputGuess.length; index++) {
            if (inputGuess[index]!=answer[index])
                return false;
        }
        return true;
    }
}
