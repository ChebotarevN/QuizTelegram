package app.commander.sender;

import app.commander.*;
import app.commander.state.Learner;
import app.commander.state.StateSession;

import java.io.FileNotFoundException;

public class StudySender extends Sender {
    public StudySender() {
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
            String text = qt.getQuestion() + "?";
            for (int i = 0; i < qt.getVariant().size(); i++) {
                text += "\n" + qt.getVariant().get(i);
            }
            message.setText(text);
        } else {
            message.setText("" + stateSession.end());
        }
        return message;
    }
}
