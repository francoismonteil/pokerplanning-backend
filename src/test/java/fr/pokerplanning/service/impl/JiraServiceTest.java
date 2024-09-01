package fr.pokerplanning.service.impl;

import fr.pokerplanning.exception.JiraClientException;
import fr.pokerplanning.exception.JiraException;
import fr.pokerplanning.model.UserStory;
import fr.pokerplanning.service.JiraClient;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.List;

class JiraServiceImplTest {

    @Mock
    private JiraClient jiraClient;

    @Spy
    @InjectMocks
    private JiraServiceImpl jiraService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void updateEstimation_ShouldCallJiraClient() {
        // Arrange
        Long userStoryId = 1L;
        int estimation = 5;

        // Act
        jiraService.updateEstimation(userStoryId, estimation);

        // Assert
        verify(jiraClient, times(1)).updateEstimation(anyString(), any());
    }

    @Test
    void updateEstimation_ShouldThrowJiraException_WhenClientFails() {
        // Arrange
        Long userStoryId = 1L;
        int estimation = 5;
        doThrow(new JiraClientException("Error")).when(jiraClient).updateEstimation(anyString(), any());

        // Act & Assert
        assertThrows(JiraException.class, () -> jiraService.updateEstimation(userStoryId, estimation));
    }
}
