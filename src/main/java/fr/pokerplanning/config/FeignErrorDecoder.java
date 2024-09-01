package fr.pokerplanning.config;

import fr.pokerplanning.exception.JiraClientException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;

public class FeignErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        HttpStatus status = HttpStatus.valueOf(response.status());
        switch (status) {
            case BAD_REQUEST:
                return new JiraClientException("Bad request to Jira: " + response.reason());
            case UNAUTHORIZED:
                return new JiraClientException("Unauthorized: Check your Jira credentials.");
            case NOT_FOUND:
                return new JiraClientException("Resource not found: " + response.request().url());
            case INTERNAL_SERVER_ERROR:
                return new JiraClientException("Internal server error at Jira: " + response.reason());
            default:
                return new JiraClientException("Unexpected error: " + response.reason());
        }
    }
}
