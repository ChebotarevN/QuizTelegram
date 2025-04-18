package app.commander.sender;

import app.commander.SendMessage;
import app.commander.state.StateSession;

import java.io.FileNotFoundException;

public abstract class Sender {
    StateSession stateSession; //режим
    long chatID;//пользователь

    public abstract void onMessageReceived(String message);//получить сообщение

    public abstract SendMessage createSendMessage() throws FileNotFoundException;//отправить сообщение
}