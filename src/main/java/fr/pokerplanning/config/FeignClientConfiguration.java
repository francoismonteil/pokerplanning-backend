package fr.pokerplanning.config;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Configuration
public class FeignClientConfiguration {

    @Value("${jira.api.email}")
    private String jiraEmail;

    @Value("${jira.api.token}")
    private String jiraToken;

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            String auth = jiraEmail + ":" + jiraToken;
            String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes(StandardCharsets.UTF_8));
            String authHeader = "Basic " + encodedAuth;
            requestTemplate.header("Authorization", authHeader);
        };
    }
}
