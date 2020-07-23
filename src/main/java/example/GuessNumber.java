package example;

public class GuessNumber{

    private int[] answer;
    public GuessNumber(AnswerGenerator answerGenerator) {
        this.answer=answerGenerator.generate();
    }

    public String guess(int[] inputGuess) {
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
