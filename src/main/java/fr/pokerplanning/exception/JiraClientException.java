package fr.pokerplanning.exception;

public class JiraClientException extends JiraException {
    public JiraClientException(String message) {
        super(message);
    }

    public JiraClientException(String message, Throwable cause) {
        super(message, cause);
    }
}
