package app.commander.command;

import app.commander.SendMessage;
import app.commander.sender.ExaminatorSender;
import app.commander.sender.Sender;

public class ExemCommand extends Command {
    @Override
    public Sender execute(SendMessage message) {
        return new ExaminatorSender();
    }
}
