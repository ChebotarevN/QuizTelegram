package app.commander.command;

import app.commander.sender.ExaminatorSender;
import app.commander.sender.Sender;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public class ExemCommand extends Command {
    @Override
    public Sender execute(SendMessage message) {
        return new ExaminatorSender();
    }
}
