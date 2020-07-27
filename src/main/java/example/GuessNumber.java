package example;

import java.util.HashMap;

public class GuessNumber {

    private int[] answer;

    private AnswerGenerate answerGenerate =new AnswerGenerate();

    public int[] getAnswer() {
        return answer;
    }


    public GuessNumber() {
        this.answer = answerGenerate.generate();
    }

    public GuessNumber(AnswerGenerator answerGenerator) {
        this.answer = answerGenerator.generate();
    }

    public String guess(int[] inputGuess) {

        return String.format("%dA%dB", calNumOfA(inputGuess, answer), calNumOfB(inputGuess, answer));
    }


    public int calNumOfA(int[] inputGuess, int[] answer) {
        int countOfA = 0;
        for (int index = 0; index < inputGuess.length; index++) {
            if (inputGuess[index] == answer[index])
                countOfA++;
        }
        return countOfA;
    }

    public int calEqualNum(int[] inputGuess, int[] answer) {
        int countOfEqual = 0;
        HashMap<Integer, String> answerMap = new HashMap<>();
        for (int i : answer) {
            answerMap.put(i, "exist");
        }
        for (int guess : inputGuess) {
            if ("exist".equals(answerMap.get(guess)))
                countOfEqual++;
        }
        return countOfEqual;
    }

    public int calNumOfB(int[] inputGuess, int[] answer) {
        return calEqualNum(inputGuess, answer) - calNumOfA(inputGuess, answer);
    }

    public boolean isLegalList(int[] legalList) {
        HashMap<Integer, Integer> inputMap = new HashMap<>();
        for (int legal : legalList) {
            if (legal >= 0 && legal <= 9)
                inputMap.put(legal, 1);
            else
                return false;
        }
        return inputMap.size() == 4;
    }


}
