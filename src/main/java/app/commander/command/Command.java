package app.commander.command;

import app.commander.SendMessage;
import app.commander.sender.Sender;

import java.util.Objects;

public abstract class Command {
    protected String text;

    public abstract Sender execute(SendMessage message);

    public Command getText(String message) {
        if (Objects.equals(message, "/exam")) {
            return new ExemCommand();
        } else if (Objects.equals(message, "/study")) {
            return new StudyCommand();
        } else if (Objects.equals(message, "/learn")) {
            return new LearnCommand();
        }
        return null;
    }
}
