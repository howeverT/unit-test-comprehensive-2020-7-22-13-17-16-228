package example;

import java.util.HashMap;

public class GuessNumber{

    private int[] answer;

    public GuessNumber() {
    }

    public GuessNumber(AnswerGenerator answerGenerator) {
        this.answer=answerGenerator.generate();
    }

    public String guess(int[] inputGuess) {

        return calNumOfA(inputGuess,answer)+"A"+calNumOfB(inputGuess,answer)+"B";
    }


    public int calNumOfA(int[] inputGuess, int[] answer){
        int result=0;
        for (int index = 0; index < inputGuess.length; index++) {
            if (inputGuess[index]==answer[index])
                result++;
        }
        return result;
    }

    public int calEqualNum(int[] inputGuess, int[] answer){
        int result=0;
        HashMap<Integer,String> answerMap=new HashMap<>();
        for (int i : answer) {
            answerMap.put(i, "exist");
        }
        for (int guess : inputGuess) {
            if ("exist".equals(answerMap.get(guess)))
                result++;
        }
        return result;
    }

    public int calNumOfB(int[] inputGuess, int[] answer){
        return calEqualNum(inputGuess,answer)-calNumOfA(inputGuess,answer);
    }

    public boolean isLegalList(int[] inputGuess){
        HashMap<Integer,Integer> inputMap=new HashMap<>();
        for (int guess : inputGuess) {
            inputMap.put(guess,1);
        }
        return inputMap.size() == 4;
    }


}
