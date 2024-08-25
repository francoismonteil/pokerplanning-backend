package fr.pokerplanning.service.impl;

import fr.pokerplanning.model.UserStory;
import fr.pokerplanning.service.JiraService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class JiraServiceImpl implements JiraService {

    @Override
    public List<UserStory> fetchUserStories() {
        // Logique pour récupérer les User Stories depuis Jira
        return new ArrayList<>(); // Placeholder
    }

    @Override
    public void updateEstimation(Long userStoryId, int estimation) {
        // Logique pour mettre à jour l'estimation dans Jira
    }
}
