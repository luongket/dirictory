package Base.game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QuestionLoader {
    public static List<Question> loadQuestions(String filePath) throws IOException {
        List<Question> questions = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            Question currentQuestion = null;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("@")) {
                    if (currentQuestion != null) {
                        questions.add(currentQuestion);
                    }
                    currentQuestion = new Question();
                    currentQuestion.setQuestion(line.substring(1).trim());
                    currentQuestion.setChoices(new ArrayList<>());
                } else if (line.startsWith("+")) {

                    currentQuestion.setCorrectAnswer(line.substring(1).trim());
                    currentQuestion.getChoices().add(line.substring(1).trim());
                } else if (line.startsWith("-")) {

                    if (currentQuestion.getChoices().size() < 3) {
                        currentQuestion.getChoices().add(line.substring(1).trim());
                    }
                }
            }

            if (currentQuestion != null) {
                questions.add(currentQuestion);
            }
        }

        return questions;
    }
}