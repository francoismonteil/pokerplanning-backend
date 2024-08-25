package fr.pokerplanning.controller;

import fr.pokerplanning.model.UserStory;
import fr.pokerplanning.service.JiraService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PokerPlanningController {

    private final JiraService jiraService;

    public PokerPlanningController(JiraService jiraService) {
        this.jiraService = jiraService;
    }

    @GetMapping("/user-stories")
    public List<UserStory> getUserStories() {
        return jiraService.fetchUserStories();
    }

    @PutMapping("/user-stories/{id}/estimation")
    public void updateEstimation(@PathVariable Long id, @RequestBody int estimation) {
        jiraService.updateEstimation(id, estimation);
    }
}
