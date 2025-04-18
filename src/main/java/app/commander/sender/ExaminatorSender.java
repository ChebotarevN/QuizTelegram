package app.commander.sender;

import app.commander.*;
import app.commander.state.Learner;
import app.commander.state.StateSession;

import java.io.FileNotFoundException;

public class ExaminatorSender extends Sender{
    public ExaminatorSender() {
        stateSession = new Learner();
    }

    @Override
    public void onMessageReceived(String message) {
        stateSession.check(message);
    }

    @Override
    public SendMessage createSendMessage() throws FileNotFoundException {
        SendMessage message = new SendMessage();
        if (stateSession.getState() == StateSession.State.ACTION || stateSession.getState() == StateSession.State.INIT) {
            Question qt = stateSession.action();
            message.setText(qt.getQuestion() + "?");
        } else {
            message.setText("" + stateSession.end());
        }
        return message;
    }
}
