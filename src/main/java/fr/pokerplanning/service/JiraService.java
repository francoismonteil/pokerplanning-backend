package fr.pokerplanning.service;

import fr.pokerplanning.model.UserStory;
import java.util.List;

public interface JiraService {
    List<UserStory> fetchUserStories();
    void updateEstimation(Long userStoryId, int estimation);
}
