package app.commander;

import java.util.List;

public class Question {
    private String question;
    private List<String> variant;
    private int rightAnswer;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getVariant() {
        return variant;
    }

    public void setVariant(List<String> variant) {
        this.variant = variant;
    }

    public int getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(int rightAnswer) {
        this.rightAnswer = rightAnswer;
    }
}
