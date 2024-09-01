package fr.pokerplanning.service;

import fr.pokerplanning.model.UserStory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "jiraClient", url = "${jira.api.url}")
public interface JiraClient {

    @GetMapping("/rest/api/2/search?jql=project={projectKey}&fields=summary,description")
    List<UserStory> getUserStories(@PathVariable("projectKey") String projectKey);

    @PutMapping("/rest/api/2/issue/{issueIdOrKey}")
    void updateEstimation(@PathVariable("issueIdOrKey") String issueIdOrKey, @RequestBody Object updatePayload);
}
