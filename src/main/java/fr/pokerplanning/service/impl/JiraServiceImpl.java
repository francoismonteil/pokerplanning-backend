package fr.pokerplanning.service.impl;

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
        return jiraClient.getUserStories(projectKey);
    }

    @Override
    public void updateEstimation(Long userStoryId, int estimation) {
        // Payload for the update, this will depend on Jira's expected structure
        Object updatePayload = createUpdatePayload(estimation);
        jiraClient.updateEstimation(String.valueOf(userStoryId), updatePayload);
    }

    private Object createUpdatePayload(int estimation) {
        // Create the payload based on Jira's expected format for updating an estimation
        // Typically, this would be a JSON structure
        return new Object(); // Placeholder, needs proper implementation
    }
}