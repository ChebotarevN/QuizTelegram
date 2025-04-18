package app.commander.command;

import app.commander.SendMessage;
import app.commander.sender.Sender;
import app.commander.sender.StudySender;

public class StudyCommand extends Command {
    @Override
    public Sender execute(SendMessage message) {
        return new StudySender();
    }
}
