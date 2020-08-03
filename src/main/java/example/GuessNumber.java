package example;

import java.util.HashMap;

import static example.Constants.*;

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

        return String.format("%dA%dB", calNumOfCorrectNumber(inputGuess, answer), calNumOfB(inputGuess, answer));
    }


    public int calNumOfCorrectNumber(int[] inputGuess, int[] answer) {//TODO
        int countOfA = 0;
        for (int index = 0; index < inputGuess.length; index++) {
            if (inputGuess[index] == answer[index]) {
                countOfA++;
            }
        }
        return countOfA;
    }

    public int calEqualNum(int[] inputGuess, int[] answer) {
        int countOfEqual = 0;
        HashMap<Integer, String> answerMap = new HashMap<>();
        for (int i : answer) {//TODO
            answerMap.put(i, EXIST_MESSAGE);
        }
        for (int guess : inputGuess) {
            if (EXIST_MESSAGE.equals(answerMap.get(guess))) {
                countOfEqual++;
            }
        }
        return countOfEqual;
    }

    public int calNumOfB(int[] inputGuess, int[] answer) {//TODO
        return calEqualNum(inputGuess, answer) - calNumOfCorrectNumber(inputGuess, answer);
    }

    public boolean isLegalList(int[] legalList) {
        HashMap<Integer, Integer> inputMap = new HashMap<>();
        for (int legal : legalList) {
            if (legal >= 0 && legal <= 9) {
                inputMap.put(legal, 1);
            } else {
                return false;
            }
        }
        return inputMap.size() == 4;
    }


}
