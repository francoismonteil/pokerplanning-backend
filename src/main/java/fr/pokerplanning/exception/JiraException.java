package fr.pokerplanning.exception;

public class JiraException extends RuntimeException {
    public JiraException(String message) {
        super(message);
    }

    public JiraException(String message, Throwable cause) {
        super(message, cause);
    }
}
