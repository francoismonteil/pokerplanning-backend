package fr.pokerplanning.service.impl;

import fr.pokerplanning.exception.JiraClientException;
import fr.pokerplanning.exception.JiraException;
import fr.pokerplanning.model.UserStory;
import fr.pokerplanning.service.JiraClient;
import fr.pokerplanning.service.JiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JiraServiceImpl implements JiraService {

    private final JiraClient jiraClient;
    private final String projectKey;

    @Autowired
    public JiraServiceImpl(JiraClient jiraClient, @Value("${jira.api.projectKey}") String projectKey) {
        this.jiraClient = jiraClient;
        this.projectKey = projectKey;
    }

    @Override
    public List<UserStory> fetchUserStories() {
        try {
            return jiraClient.getUserStories(projectKey);
        } catch (JiraClientException e) {
            // Logique pour gérer l'erreur
            throw new JiraException("Failed to fetch user stories from Jira", e);
        }
    }

    @Override
    public void updateEstimation(Long userStoryId, int estimation) {
        try {
            Object updatePayload = createUpdatePayload(estimation);
            jiraClient.updateEstimation(String.valueOf(userStoryId), updatePayload);
        } catch (JiraClientException e) {
            // Logique pour gérer l'erreur
            throw new JiraException("Failed to update estimation in Jira", e);
        }
    }

    private Object createUpdatePayload(int estimation) {
        // Création du payload
        return new Object(); // Placeholder
    }
}