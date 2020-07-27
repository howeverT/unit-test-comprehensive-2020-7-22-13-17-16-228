package example;

import java.util.HashMap;

public class GuessNumber implements AnswerGenerator {

    private int[] answer;

    public int[] getAnswer() {
        return answer;
    }

    public void setAnswer(int[] answer) {
        this.answer = answer;
    }

    public GuessNumber() {
        this.answer = generate();
    }

    public GuessNumber(AnswerGenerator answerGenerator) {
        this.answer = answerGenerator.generate();
    }

    public String guess(int[] inputGuess) {

        return calNumOfA(inputGuess, answer) + "A" + calNumOfB(inputGuess, answer) + "B";
    }


    public int calNumOfA(int[] inputGuess, int[] answer) {
        int result = 0;
        for (int index = 0; index < inputGuess.length; index++) {
            if (inputGuess[index] == answer[index])
                result++;
        }
        return result;
    }

    public int calEqualNum(int[] inputGuess, int[] answer) {
        int result = 0;
        HashMap<Integer, String> answerMap = new HashMap<>();
        for (int i : answer) {
            answerMap.put(i, "exist");
        }
        for (int guess : inputGuess) {
            if ("exist".equals(answerMap.get(guess)))
                result++;
        }
        return result;
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


    public HashMap<Integer, Integer> answerLocation() {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 1;
        for (int i : answer) {
            map.put(i, count++);
        }
        return map;
    }

    @Override
    public int[] generate() {
        int[] result = new int[4];
        int count = 0;
        while (count < 4) {
            int num = (int) (Math.random() * 9);
            boolean isInResult = true;
            for (int index = 0; index < 4; index++) {
                if (num == result[index]) {
                    isInResult = false;
                    break;
                }
            }
            if (isInResult) {
                result[count] = num;
                count++;
            }
        }
        return result;
    }


}
