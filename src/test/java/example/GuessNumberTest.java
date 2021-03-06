package example;


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class GuessNumberTest {
    @Test
    void should_return_4A0B_when_guess_given_answer_1234_and_input_guess_1234() {
        //given
        int[] answer = {1, 2, 3, 4};
        AnswerGenerator answerGenerator = Mockito.mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn(answer);
        GuessNumber guessNumber = new GuessNumber(answerGenerator);
        int[] inputGuess = {1, 2, 3, 4};


        //when
        String result = guessNumber.guess(inputGuess);

        //then
        assertEquals("4A0B", result);
    }

    @Test
    void should_return_0A0B_when_guess_given_answer_1234_and_input_guess_5678() {
        //given
        int[] answer = {1, 2, 3, 4};
        AnswerGenerator answerGenerator = Mockito.mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn(answer);
        GuessNumber guessNumber = new GuessNumber(answerGenerator);
        int[] inputGuess = {5, 6, 7, 8};


        //when
        String result = guessNumber.guess(inputGuess);

        //then
        assertEquals("0A0B", result);
    }

    @Test
    void should_return_0A4B_when_guess_given_answer_1234_and_input_guess_4321() {
        //given
        int[] answer = {1, 2, 3, 4};
        AnswerGenerator answerGenerator = Mockito.mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn(answer);
        GuessNumber guessNumber = new GuessNumber(answerGenerator);
        int[] inputGuess = {4, 3, 2, 1};


        //when
        String result = guessNumber.guess(inputGuess);

        //then
        assertEquals("0A4B", result);
    }

    @Test
    void should_return_0A4B_when_guess_given_answer_1234_and_input_guess_1243() {
        //given
        int[] answer = {1, 2, 3, 4};
        AnswerGenerator answerGenerator = Mockito.mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn(answer);
        GuessNumber guessNumber = new GuessNumber(answerGenerator);
        int[] inputGuess = {1, 2, 4, 3};


        //when
        String result = guessNumber.guess(inputGuess);

        //then
        assertEquals("2A2B", result);
    }

    @Test
    void should_return_true_when_isLegal_given_input_guess_1234() {
        //given
        int[] inputGuess = {1, 2, 3, 4};
        GuessNumber guessNumber = new GuessNumber();


        //when
        boolean result = guessNumber.isLegalList(inputGuess);

        //then
        assertTrue(result);
    }

    @Test
    void should_return_false_when_isLegal_given_input_guess_12() {
        //given
        int[] inputGuess = {1, 2};
        GuessNumber guessNumber = new GuessNumber();


        //when
        boolean result = guessNumber.isLegalList(inputGuess);

        //then
        assertFalse(result);
    }

    @Test
    void should_return_false_when_isLegal_given_input_guess_1223() {
        //given
        int[] inputGuess = {1, 2, 2, 3};
        GuessNumber guessNumber = new GuessNumber();


        //when
        boolean result = guessNumber.isLegalList(inputGuess);

        //then
        assertFalse(result);
    }

    @Test
    void should_return_false_when_isLegal_given_input_guess_11243() {
        //given
        int[] inputGuess = {11, 2, 4, 3};
        GuessNumber guessNumber = new GuessNumber();


        //when
        boolean result = guessNumber.isLegalList(inputGuess);

        //then
        assertFalse(result);
    }

    @Test
    void should_return_true_when_generate_answer_given_answer_random() {
        //given
        GuessNumber guessNumber = new GuessNumber();
        AnswerGenerate answerGenerate = new AnswerGenerate();


        //when
        boolean result = guessNumber.isLegalList(answerGenerate.generate());

        //then
        assertTrue(result);
    }

    @Test
    void should_return_false_when_generate_answer_given_answer_1226() {
        //given
        int[] answer = {1, 2, 2, 6};
        AnswerGenerator answerGenerator = Mockito.mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn(answer);
        GuessNumber guessNumber = new GuessNumber(answerGenerator);


        //when
        boolean result = guessNumber.isLegalList(guessNumber.getAnswer());

        //then
        assertFalse(result);
    }

    @Test
    void should_return_false_when_generate_answer_given_answer_13267() {
        //given
        int[] answer = {1, 3, 2, 6, 7};
        AnswerGenerator answerGenerator = Mockito.mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn(answer);
        GuessNumber guessNumber = new GuessNumber(answerGenerator);


        //when
        boolean result = guessNumber.isLegalList(guessNumber.getAnswer());

        //then
        assertFalse(result);
    }

    @Test
    void should_return_wrong_input_when_play_given_inputGuess() {
        //given
        int[] answer = {1, 2, 3, 4};
        AnswerGenerator answerGenerator = Mockito.mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn(answer);
        GuessNumber guessNumber = new GuessNumber(answerGenerator);
        Process process = new Process();
        int[] inputGuess = {1, 2, 2, 6};


        //when
        String result = process.play(inputGuess, 1, guessNumber);

        //then
        assertEquals("Wrong Input,Input again", result);
    }

    @Test
    void should_return_you_win_when_play_given_inputGuess() {
        //given
        int[] answer = {1, 2, 3, 4};
        AnswerGenerator answerGenerator = Mockito.mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn(answer);
        GuessNumber guessNumber = new GuessNumber(answerGenerator);
        Process process = new Process();
        int[] inputGuess = {1, 2, 3, 4};


        //when
        String result = process.play(inputGuess, 1, guessNumber);

        //then
        assertEquals("You win", result);
    }

    @Test
    void should_return_2_when_game_process_given_inputGuess() {
        //given
        int[] answer = {1, 2, 3, 4};
        AnswerGenerator answerGenerator = Mockito.mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn(answer);
        GuessNumber guessNumber = new GuessNumber(answerGenerator);
        Process process = new Process();
        int[] inputGuess = {5, 2, 3, 4};

        //when
        int result = process.gameProcess(inputGuess, 1, guessNumber);

        //then
        assertEquals(2, result);
    }

    @Test
    void should_return_7_when_game_process_given_inputGuess_right() {
        //given
        int[] answer = {1, 2, 3, 4};
        AnswerGenerator answerGenerator = Mockito.mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn(answer);
        GuessNumber guessNumber = new GuessNumber(answerGenerator);
        Process process = new Process();
        int[] inputGuess = {1, 2, 3, 4};

        //when
        int result = process.gameProcess(inputGuess, 1, guessNumber);

        //then
        assertEquals(7, result);
    }

    @Test
    void should_return_1_when_game_process_given_inputGuess_illegal() {
        //given
        int[] answer = {1, 2, 3, 4};
        AnswerGenerator answerGenerator = Mockito.mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn(answer);
        GuessNumber guessNumber = new GuessNumber(answerGenerator);
        Process process = new Process();
        int[] inputGuess = {2, 2, 3, 4};

        //when
        int result = process.gameProcess(inputGuess, 1, guessNumber);

        //then
        assertEquals(1, result);
    }

}
