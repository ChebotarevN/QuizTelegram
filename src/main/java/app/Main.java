package app;

import app.commander.SendMessage;
import app.commander.command.Command;
import app.commander.command.ExemCommand;
import app.commander.sender.Sender;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("asd");
        Command command = new ExemCommand();
        Command comd = command.getText("/study");
        Sender sender = comd.execute(sendMessage);
        sendMessage = sender.createSendMessage();
        System.out.println(sendMessage.getText());
    }
}