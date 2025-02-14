package com.spring_ollama.controller;

import java.util.List;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ChatController {

    private final ChatClient chatClient;

    public ChatController(ChatClient.Builder chatClient) {
        this.chatClient = chatClient.build();
    }

    @GetMapping("/test")
    public String testing() {
        return "api double hit";
    }

    @GetMapping("/chat/{chat}")
    public ResponseEntity<String> promptWithPathVariable(@PathVariable String chat) {
        System.out.println("processing");
        try {
            String response = chatClient
                    .prompt(chat)
                    .call()
                    .content();
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    // New endpoint to analyze job postings
    @PostMapping("/analyze-jobs")
    public ResponseEntity<String> analyzeJobPostings(@RequestBody List<String> companyWebsites) {
    	System.out.println("processing in analyze job");
        try {
            // Step 1: Prepare the prompt for DeepSeek
            StringBuilder promptBuilder = new StringBuilder();
            promptBuilder.append("Analyze the following company websites and provide a list of new job postings:\n");
            for (String website : companyWebsites) {
                promptBuilder.append("- ").append(website).append("\n");
            }
            String prompt = promptBuilder.toString();

            // Step 2: Send the prompt to Ollama DeepSeek
            String deepSeekResponse = chatClient
                    .prompt(prompt)
                    .call()
                    .content();

            String cleanedResponse = deepSeekResponse.replaceAll("<think>.*?</think>", ""); 
            return ResponseEntity.ok(cleanedResponse);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}