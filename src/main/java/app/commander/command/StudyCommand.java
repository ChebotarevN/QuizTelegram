package app.commander.command;

import app.commander.sender.Sender;
import app.commander.sender.StudySender;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public class StudyCommand extends Command {
    @Override
    public Sender execute(SendMessage message) {
        return new StudySender();
    }
}