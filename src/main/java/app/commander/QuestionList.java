package app.commander;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class QuestionList {
    private List<Question> questionList;

    public QuestionList(File file) throws FileNotFoundException {
        questionList = new ArrayList<>();
        Question question = null;
        List<String> variants = new ArrayList<>();
        Scanner in = new Scanner(file);
        while (in.hasNext()) {
            String text = in.nextLine();
            if (!text.startsWith(" ")) {
                if (question == null) {
                    question = new Question();
                    question.setQuestion(text);
                } else {
                    question.setVariant(variants);
                    questionList.add(question);
                    question = new Question();
                    question.setQuestion(text);
                    variants = new ArrayList<>();
                }
            } else {
                variants.add(text);
            }
        }
        if (question != null) {
            question.setVariant(variants);
            questionList.add(question);
        }
    }

    public Question getQuestion() {
        Random random = new Random();
        return questionList.get(random.nextInt(questionList.size()));
    }
}
