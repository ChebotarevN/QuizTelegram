package app.commander.command;

import app.commander.sender.LearnSender;
import app.commander.sender.Sender;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public class LearnCommand extends Command {
    @Override
    public Sender execute(SendMessage message) {
        return new LearnSender();
    }
}