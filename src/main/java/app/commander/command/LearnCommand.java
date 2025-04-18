package app.commander.command;

import app.commander.SendMessage;
import app.commander.sender.LearnSender;
import app.commander.sender.Sender;

public class LearnCommand extends Command {
    @Override
    public Sender execute(SendMessage message) {
        return new LearnSender();
    }
}
