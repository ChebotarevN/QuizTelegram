package app.commander.state;

import app.commander.Question;
import app.commander.QuestionList;

import java.io.File;
import java.io.FileNotFoundException;

public class Study implements StateSession {
    private int error, right;
    private Question question;
    private State state;

    public Study() {
        state = State.INIT;
    }

    public Question action() throws FileNotFoundException //формирует вопрос из списка вопросов
    {
        state = State.ACTION;
        QuestionList questionList;
        try {
            questionList = new QuestionList(new File("src/main/resources/quest"));
        } catch (Exception e) {
            state = State.ERROR;
            return null;
        }
        question = questionList.getQuestion();
        return question;
    }

    public boolean check(String answer) //проверяет ответ answer на вопрос
    {
        state = State.CHECK;
        int mess = 0;
        try {
            mess = Integer.parseInt(answer);
        } catch (Exception e) {
            state = State.ERROR;
            return false;
        }
        return mess == question.getRightAnswer();
    }

    public String end() //выводит статистику по результатам теста
    {
        state = State.END;
        return String.format("Вы правильно ответили на %d вопросов из %d. Процент правильных ответов составил %f%", right, right + error, right / error);
    }

    @Override
    public State getState() {
        ;
        return state;
    }
}
