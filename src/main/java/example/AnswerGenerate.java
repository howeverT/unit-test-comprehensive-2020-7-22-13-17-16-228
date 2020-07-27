package example;

public class AnswerGenerate implements AnswerGenerator{
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
